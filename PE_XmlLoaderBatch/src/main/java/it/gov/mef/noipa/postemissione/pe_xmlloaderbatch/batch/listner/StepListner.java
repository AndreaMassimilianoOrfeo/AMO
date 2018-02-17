package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.listner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.Constants;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeJDBC;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.log4j.Logger;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

public class StepListner extends StepExecutionListenerSupport {

	private static final Logger LOGGER = Logger.getLogger(StepListner.class);

	private Resource resource;
	private String fileLavoratiDir;
	private String landDir;
	private int idPostemissione;
	private String tipoPostemissione;
	private String LAND_EXT = ".persec";

	@Autowired
	private ServiceFacadeJDBC serviceFacade;

	public ExitStatus afterStep(StepExecution stepExecution) {
		LOGGER.info(">>> AfterStep");

		String exitCode = stepExecution.getExitStatus().getExitCode();

		if (exitCode.equals(ExitStatus.COMPLETED.getExitCode())) {

			String landFileName = landDir + "/" + resource.getFilename() + LAND_EXT;

			if (!("O".equalsIgnoreCase(tipoPostemissione))) {
				try {
					Files.copy(resource.getFile().toPath(), new File(landFileName).toPath(), REPLACE_EXISTING);
				} catch (IOException e) {
					LOGGER.error("Impossibile copiare il file nella directory land " + landFileName, e);
					serviceFacade.aggiornaStatoOrigineDati(resource.getFilename(), Constants.KO_DOCUMENTI_INDICIZZATI_NON_INOLTRATI, idPostemissione);
					stepExecution.setStatus(BatchStatus.FAILED);
					return new ExitStatus(ExitStatus.FAILED.getExitCode(), "ERROR COPY FILE - LAND");
				}
			}

			try {
				Files.move(resource.getFile().toPath(), new File(fileLavoratiDir + "/" + resource.getFilename()).toPath(), REPLACE_EXISTING);
			} catch (IOException e) {
				LOGGER.error("Impossibile spostare il file nella directory " + fileLavoratiDir + "/" + resource.getFilename(), e);
				try {
					Files.deleteIfExists(new File(landFileName).toPath());
				} catch (IOException e1) {
					LOGGER.error("Impossibile cancellare il file " + landFileName, e1);
				}
				serviceFacade.aggiornaStatoOrigineDati(resource.getFilename(), Constants.KO_DOCUMENTI_INDICIZZATI_NON_INOLTRATI, idPostemissione);
				stepExecution.setStatus(BatchStatus.FAILED);
				return new ExitStatus(ExitStatus.FAILED.getExitCode(), "ERROR MOVE FILE - LAVORATI");
			}
			serviceFacade.aggiornaStatoOrigineDati(resource.getFilename(), Constants.DOCUMENTI_INOLTRATI_PER_LA_PRODUZIONE_CON_SUCCESSO, idPostemissione);

		} else {
			serviceFacade.aggiornaStatoOrigineDati(resource.getFilename(), Constants.KO_DOCUMENTI_INDICIZZATI_NON_INOLTRATI, idPostemissione);
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
