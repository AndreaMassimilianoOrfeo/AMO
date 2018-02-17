package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.listner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.Constants;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeJDBC;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeJDBCCedLoader;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.PostEmissioneDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper.ScartoXml;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.log4j.Logger;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class StepListnerCedLoader extends StepExecutionListenerSupport {

	private static final Logger LOGGER = Logger.getLogger(StepListnerCedLoader.class);

	private Resource resource;
	private String fileLavoratiDir;
	private String landDir;
	private int idPostemissione;
	private String tipoPostemissione;
	private String LAND_EXT = ".persec";
	private PostEmissioneDocument postEmissioneDocument;
	private Date dtProcesso;
	private int sequIdFileElaborato;
	private int sequIdProcesso;
	private String taskNameStart = "START";
	private String taskNameEnd = "END";
	private int idFileElaborato;

	@Autowired
	private ServiceFacadeJDBCCedLoader serviceFacadeJDBCCedLoader;

	@Autowired
	private ServiceFacadeJDBC serviceFacadeJDBC;

	public void beforeStep(StepExecution stepExecution) {

		LOGGER.info(">>> BeforeStep Cedolino Loader");
		LOGGER.info(">>> Metodo di inizializzazione Cedolino Loader");

		postEmissioneDocument = serviceFacadeJDBC.getPostemissione(idPostemissione);
		Assert.notNull(postEmissioneDocument, "Nessuna post emissione con id:" + idPostemissione);

		String tipoModelloElaborazione = postEmissioneDocument.getTypeDocumento();
		String fileName = resource.getFilename();

		// recupero il tipo di elaborazione --- cedolino o cud ---
		String elaborazione = "";
		if (tipoModelloElaborazione == "cedolino") {
			elaborazione = "STP";
		} else {
			elaborazione = "CUD";
		}

		// recupero id_origine_ dati da origine dati PE_MONITORAGGIO
		int idOrigineDati = serviceFacadeJDBC.returnIdOrigineDati(idPostemissione, fileName, Constants.ARTEFATTI_PUBBLICATI);

		try {
			// inserimento caricamenti_portale PE_MONITORAGGIO
			serviceFacadeJDBC.insertCaricamentiPortale(idOrigineDati, idPostemissione, Constants.DOCUMENTI_PRESI_IN_CARICO);

			// RECUPERO DT PROCESSO DA UCEDOLINO
			dtProcesso = serviceFacadeJDBCCedLoader.dtProcesso();
			// LOADER_SEQU_ID_PROCESSO DA UCEDOLINO
			sequIdProcesso = serviceFacadeJDBCCedLoader.sequIdProcesso();
			// RECUPERO ID FILE ELABORATO DA UCEDOLINO
			sequIdFileElaborato = serviceFacadeJDBCCedLoader.sequIdFileElaborato();
			// INSERT D_STORICO BATCH --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.insertDStoricoBatch(fileName, elaborazione);
			// INSERT PROCESSO --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.insertProcesso(fileName, sequIdProcesso, dtProcesso);
			// INSERT STATO PROCESSO --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.insertStatoProcesso(fileName, dtProcesso, "START", "KO");
			// INSERT HISTORY PROCESSO --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.insertHistoryProcesso(fileName, dtProcesso, taskNameStart);
			// INSERT D_ELABORAZIONE_FILE --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.insertDElaborazioneFile(sequIdFileElaborato, elaborazione, fileName);

		} catch (Exception e) {

			// INSERT history processo --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.insertHistoryProcessoEnd(resource.getFilename(), dtProcesso, taskNameEnd);
			// aggiorna D_STORICO_BATCH --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.updateDStoricoBatch(resource.getFilename());
			// aggiorna D_ELABORAZIONE_FILE --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.updateDElaborazioneFile(1, idFileElaborato);
			// update STATO PROCESSO --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.updateStatoProcesso("KO", resource.getFilename(), dtProcesso);
			// update caricamenti portale --- PE_MONITORAGGIO ---
			serviceFacadeJDBC.updateCaricamentiPortale(Constants.KO_DOCUMENTI_NON_ARCHIVIATI, idOrigineDati,
					idPostemissione, Constants.DOCUMENTI_PRESI_IN_CARICO);
			Assert.notNull(e, e.getMessage());
		}
		// FINE BEFORE STEP
	}

	public ExitStatus afterStep(StepExecution stepExecution) {
		LOGGER.info(">>> AfterStep Cedolino Loader");
		LOGGER.info(">>> Metodo finale di Cedolino Loader");

		// recupero id_origine_ dati da origine dati
		int idOrigineDati = serviceFacadeJDBC.returnIdOrigineDati(idPostemissione, resource.getFilename(), Constants.ARTEFATTI_PUBBLICATI);
		/* recupero id_file_elaborato */
		idFileElaborato = serviceFacadeJDBCCedLoader.returnSequIdFileElaborato(resource.getFilename());

		String exitCode = stepExecution.getExitStatus().getExitCode();
		String landFileName = landDir + "/" + resource.getFilename() + LAND_EXT;
		String fileXml = "";

		if (exitCode.equals(ExitStatus.FAILED.getExitCode())) {
			// PARTE DI ESECUZIONE SE IL CARICAMENTO E' STATO EFFETTUATO CON SCARTI --- INIZIO ---

			LOGGER.info("Sezione finale di aggiornamento con scarto");
			// chiamata alla classe che genera il file XML dalla tabella scarto
			ScartoXml xml = new ScartoXml();

			try {
				fileXml = xml.creaXml(serviceFacadeJDBCCedLoader, idOrigineDati, resource.getFilename(), dtProcesso);
			} catch (FileNotFoundException e) {
				LOGGER.error("Impossibile generare lo scarto", e);
			}

			serviceFacadeJDBCCedLoader.updateStatoProcessoScarto("KO", resource.getFilename(), dtProcesso, fileXml);
			// INSERT history processo --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.insertHistoryProcessoEnd(resource.getFilename(), dtProcesso, taskNameEnd);
			// aggiorna D_STORICO_BATCH --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.updateDStoricoBatch(resource.getFilename());
			// aggiorna D_ELABORAZIONE_FILE --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.updateDElaborazioneFile(1, idFileElaborato);
			// update caricamenti portale su PE_MONITORAGGIO
			serviceFacadeJDBC.updateCaricamentiPortaleScarto(Constants.KO_DOCUMENTI_NON_ARCHIVIATI, idOrigineDati, idPostemissione,
					Constants.DOCUMENTI_PRESI_IN_CARICO, fileXml);

		} else {

			// PARTE DI ESECUZIONE SE IL CARICAMENTO E' STATO EFFETTUATO SENZA ERRORI --- INIZIO ---
			LOGGER.info("Sezione finale di aggiornamento con successo");
			// cancella tabelle temporanee
			// INSERT history processo --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.insertHistoryProcessoEnd(resource.getFilename(), dtProcesso, taskNameEnd);
			// aggiorna D_STORICO_BATCH --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.updateDStoricoBatch(resource.getFilename());
			// aggiorna D_ELABORAZIONE_FILE --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.updateDElaborazioneFile(0, idFileElaborato);
			// update STATO PROCESSO --- UCEDOLINO ---
			serviceFacadeJDBCCedLoader.updateStatoProcesso("OK", resource.getFilename(), dtProcesso);
			// update caricamenti portale --- PE_MONITORAGGIO ---
			serviceFacadeJDBC.updateCaricamentiPortale(Constants.DOCUMENTI_PUBBLICATI_CON_SUCCESSO, idOrigineDati,
					idPostemissione, Constants.DOCUMENTI_PRESI_IN_CARICO);

			try {
				Files.move(resource.getFile().toPath(), new File(fileLavoratiDir + "/" + resource.getFilename()).toPath(), REPLACE_EXISTING);
			} catch (IOException e) {
				LOGGER.error("Impossibile spostare il file nella directory " + fileLavoratiDir + "/" + resource.getFilename(), e);
				try {
					Files.deleteIfExists(new File(landFileName).toPath());
				} catch (IOException e1) {
					LOGGER.error("Impossibile cancellare il file " + landFileName, e1);
				}

				stepExecution.setStatus(BatchStatus.FAILED);
				return new ExitStatus(ExitStatus.FAILED.getExitCode(), "ERROR MOVE FILE - LAVORATI");
			}
			// PARTE DI ESECUZIONE SE IL CARICAMENTO E' STATO EFFETTUATO SENZA ERRORI --- FINE ---
		}

		LOGGER.debug("mv file:" + resource.getFilename());

		return stepExecution.getExitStatus();
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setFileLavoratiDir(String fileLavoratiDir) {
		this.fileLavoratiDir = fileLavoratiDir;
	}

	public void setLandDir(String landDir) {
		this.landDir = landDir;
	}

	public void setIdPostemissione(int idPostemissione) {
		this.idPostemissione = idPostemissione;
	}

	public void setTipoPostemissione(String tipoPostemissione) {
		this.tipoPostemissione = tipoPostemissione;
	}
}
