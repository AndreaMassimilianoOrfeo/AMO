package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch;

import it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino.Anagrafica;
import it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino.Ced;
import it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino.Document;
import it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino.EnteApp;
import it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino.Matricola;
import it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino.Testata;
import it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino.Totali;
import it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino.AnagraficaType;
import it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino.Cedolini;
import it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino.CedolinoType;
import it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino.CedolinoType.Messaggi;
import it.gov.mef.noipa.postemissione.parser.autogenerated.cud.Cud;
import it.gov.mef.noipa.postemissione.parser.autogenerated.cud.CudType;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.BarcodeType;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.CedolinoDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.CudDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.MessaggioDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.PostEmissioneDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeElasticSearch;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeElasticSearchStorico;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeJDBC;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class WriterFile implements ItemWriter<Object> {

	private static final Logger LOG = Logger.getLogger(WriterFile.class);

	private String nomeFile_origine;
	private String anno;
	private Map<String, String> mappaTipoEmissioni;
	private int idPostemissione;
	private boolean caricaArtefattiOracle;
	private String tipoPostemissione;
	private PostEmissioneDocument postEmissioneDocument;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM", Locale.ITALIAN);

	@Autowired
	private ServiceFacadeJDBC serviceFacadeJDBC;
	//@Autowired
	//private ServiceFacadeElasticSearch serviceFacadeElasticSearch;
	//@Autowired
	//private ServiceFacadeElasticSearchStorico serviceFacadeElasticSearchStorico;

	public void write(List<? extends Object> items) throws Exception {

		LOG.info(">>> WriterFile - start");
		LOG.info(">>>>> idPostEmissione: " + idPostemissione);
		LOG.info(">>>>> elaborazione file: " + nomeFile_origine);
		
		postEmissioneDocument = serviceFacadeJDBC.getPostemissione(idPostemissione);
		Assert.notNull(postEmissioneDocument, "Nessuna post emissione con id:" + idPostemissione);
		anno = getAnnoRata("" + postEmissioneDocument.getRata());

		for (Object item : items) {
			if (item.getClass().equals(Cedolini.class)) {

				LOG.info("Elaborazione cedolino");
				mapCedolini((Cedolini) item);

			} else if (item.getClass().equals(Cud.class)) {
				LOG.info("Elaborazione CUD");

				mapCud((Cud) item);
			}
		}

	}

	private void mapCedolini(Cedolini item) throws Exception {
		int i = 1;

		try {
			List<CedolinoType> listaCedolini = item.getCedolino();
			Map<String, CedolinoDocument> mappaCedolinoDocument = new HashMap<String, CedolinoDocument>();
			Map<String, Ced> mappaCedolino = new HashMap<String, Ced>();
			Map<String, List<MessaggioDocument>> mappaListaMessaggioDocument = new HashMap<String, List<MessaggioDocument>>();

			String codTipologiaEmissione;
			String descTipologiaEmissione;
			String dataProduzione;
			CedolinoDocument cedolinoDocument;
			String idIndexCedolino;
			List<MessaggioDocument> listMessaggi;
			List<String> listaMessaggi;
			String sequMessaggioString;
			String titolo;
			Messaggi messaggiType;
			MessaggioDocument msg;
			for (CedolinoType cedolino : listaCedolini) {

				cedolino.getTestata().getAnagrafica().setCodFiscaleAmministrato(cedolino.getTestata().getAnagrafica().getCodFiscaleAmministrato().toUpperCase());
				cedolino.getTestata().getAnagrafica().setCognome(cedolino.getTestata().getAnagrafica().getCognome().toUpperCase());
				cedolino.getTestata().getAnagrafica().setNome(cedolino.getTestata().getAnagrafica().getNome().toUpperCase());

				/**
				 * insert dati oracle
				 */
				if (caricaArtefattiOracle) {
					LOG.info("Scrittura righe oracle");
					serviceFacadeJDBC.insertArtefattiPostEmissione(
							nomeFile_origine,
							idPostemissione,
							sdf.format(postEmissioneDocument.getDataEmissione()),
							cedolino.getTestata().getAnagrafica().getMatricola().getIscrizione(),
							cedolino.getTestata().getEnteApp().getCodEnte(),
							cedolino.getTestata().getIDCedolino(),
							cedolino.getTestata().getRata(),
							cedolino.getTestata().getEnteApp().getCodSedeUffServizio(),
							cedolino.getTestata().getEnteApp().getCodUffResp()
					);
					serviceFacadeJDBC.insertCedolini(
							nomeFile_origine,
							idPostemissione,
							sdf.format(postEmissioneDocument.getDataEmissione()),
							cedolino.getTestata().getAnagrafica().getMatricola().getIscrizione(),
							cedolino.getTestata().getEnteApp().getCodEnte(),
							cedolino.getTestata().getIDCedolino(),
							cedolino.getTestata().getRata(),
							cedolino.getTestata().getEnteApp().getCodSedeUffServizio(),
							cedolino.getTestata().getEnteApp().getCodUffResp()
					);
				}

				/**
				 * insert dati elastic search
				 */
				codTipologiaEmissione = getTipologiaEmissione(cedolino.getTestata().getBarcode());
				descTipologiaEmissione = getDescTipologiaEmissione(codTipologiaEmissione);
				dataProduzione = sdf.format(item.getDataProduzione().toGregorianCalendar().getTime());

				cedolinoDocument = new CedolinoDocument(true, false, idPostemissione, "", nomeFile_origine, codTipologiaEmissione,
						descTipologiaEmissione, dataProduzione, postEmissioneDocument.getDescrizioneSottosistema(), cedolino);

				idIndexCedolino = creaIndiceCedolino(cedolino, item);
				LOG.debug("Elastic search: cedolino - ced -" + idIndexCedolino);

				listMessaggi = new ArrayList<MessaggioDocument>();

				if (cedolinoDocument.getDocument().getMessaggi() != null) {
					listaMessaggi = cedolinoDocument.getDocument().getMessaggi().getMessaggio();
					if (listaMessaggi != null && listaMessaggi.size() > 0) {
						sequMessaggioString = "msg" + idIndexCedolino;
						titolo = "Messaggio al cedolino - " + cedolino.getTestata().getDescrRata();
						messaggiType = new Messaggi();
						messaggiType.getMessaggio().add(sequMessaggioString);
						cedolinoDocument.getDocument().setMessaggi(messaggiType);
						msg = new MessaggioDocument(idPostemissione, nomeFile_origine, idIndexCedolino, listaMessaggi, titolo);
						listMessaggi.add(msg);
					}
				}

				mappaCedolinoDocument.put(idIndexCedolino, cedolinoDocument);
				mappaCedolino.put(idIndexCedolino, convert(idIndexCedolino, cedolinoDocument));
				mappaListaMessaggioDocument.put(idIndexCedolino, listMessaggi);

				if (i % 250 == 0 || i == listaCedolini.size()) {
					//serviceFacadeElasticSearch.insertCedolino(anno, mappaCedolino, mappaListaMessaggioDocument, nomeFile_origine);
					//serviceFacadeElasticSearchStorico.insertCedolino(anno, mappaCedolinoDocument, mappaListaMessaggioDocument, nomeFile_origine);
					mappaCedolinoDocument.clear();
					mappaListaMessaggioDocument.clear();
				}

				i++;
			}

		} catch (Exception e) {
			LOG.error("ERRORE ", e);
			LOG.error("delete su elastic search cedolino - ced- nomeFile: " + nomeFile_origine);
			//serviceFacadeElasticSearch.deleteCedolino(anno, nomeFile_origine, idPostemissione);
			//serviceFacadeElasticSearchStorico.deleteCedolino(anno, nomeFile_origine, idPostemissione);
			//serviceFacadeElasticSearchStorico.deleteMessaggio(anno, nomeFile_origine, idPostemissione);
			throw e;
		} finally {
			LOG.info("finally chiusura di searchClientService");
		}
	}

	private Ced convert(String idIndexCedolino, CedolinoDocument cedolinoDocument) {
		CedolinoType cedolino = cedolinoDocument.getDocument();
		CedolinoType.Totali cedTotali = cedolino.getTotali();
		CedolinoType.Testata cedTestata = cedolino.getTestata();
		CedolinoType.Testata.EnteApp cedEnteApp = cedTestata.getEnteApp();
		AnagraficaType cedAnagrafica = cedTestata.getAnagrafica();
		Totali totali = new Totali(cedTotali.getQuintoCedibile(), cedTotali.getTotaleNetto(), cedTotali.getQuintoCedibileNumber(), cedTotali.getTotaleNettoNumber());
		EnteApp enteApp = new EnteApp(cedEnteApp.getCodUffResp(), cedEnteApp.getDesEnte(), cedEnteApp.getCodFiscEnte(), cedEnteApp.getCodEnte(), cedEnteApp.getDesUffResp(), cedEnteApp.getDesSedeUffServizio(), cedEnteApp.getCodSedeUffServizio(),cedEnteApp.getCodUnitaOrganizzativa(),cedEnteApp.getDesUnitaOrganizzativa());
		Matricola matricola = new Matricola(cedAnagrafica.getMatricola().getIscrizione());
		Anagrafica anagrafica = new Anagrafica(cedAnagrafica.getDataNascita(), cedAnagrafica.getCognome(), cedAnagrafica.getNome(), cedAnagrafica.getCodFiscaleAmministrato(), matricola);
		Testata testata = new Testata(cedTestata.getIDCedolino(), cedTestata.getLingua().toString(), cedTestata.getDescrRata(), cedTestata.getRata(), enteApp, anagrafica);
		it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino.Messaggi messaggi = new it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino.Messaggi();
		Document document = new Document(totali, testata, messaggi);
		return new Ced(idIndexCedolino, cedolinoDocument.isArchiviato(), cedolinoDocument.getCodTipologiaEmissione(),
				cedolinoDocument.getNomeFile(), cedolinoDocument.isVisibile(), document, cedolinoDocument.getIdPostemissione(),
				cedolinoDocument.getDescTipologiaEmissione(), cedolinoDocument.getDataProduzione(), cedolinoDocument.getSistemaProvenienza());
	}

	private void mapCud(Cud item) throws Exception {
		int i = 1;

		try {
			List<CudType> listaCud = item.getCud();

			Map<String, CudDocument> mappaCudDocument = new HashMap<String, CudDocument>();

			String codTipologiaEmissione;
			String descTipologiaEmissione;
			CudDocument cudDocument;
			String idIndexCedolino;
			for (CudType cud : listaCud) {

				cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().setCodFiscaleAmministrato(cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().getCodFiscaleAmministrato().toUpperCase());
				cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().setCognome(cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().getCognome().toUpperCase());
				cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().setNome(cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().getNome().toUpperCase());

				/**
				 * insert dati oracle
				 */
				if (caricaArtefattiOracle) {
					LOG.info("Scrittura righe oracle");
					serviceFacadeJDBC.insertArtefattiPostEmissione(
							nomeFile_origine,
							idPostemissione,
							sdf.format(postEmissioneDocument.getDataEmissione()),
							cud.getDatiGenerali().getIscrizione().getIscrizione(),
							cud.getDatiGenerali().getBarcode().split(" ")[1],
							cud.getDatiGenerali().getIscrizione().getIscrizione(),
							cud.getDatiPrevidenziali().getINPDAP().getAnnoRif(),
							cud.getDatiGenerali().getUfficioServizio(),
							cud.getDatiGenerali().getDpt()
					);
					serviceFacadeJDBC.insertCedolini(
							nomeFile_origine,
							idPostemissione,
							sdf.format(postEmissioneDocument.getDataEmissione()),
							cud.getDatiGenerali().getIscrizione().getIscrizione(),
							cud.getDatiGenerali().getBarcode().split(" ")[1],
							cud.getDatiGenerali().getIscrizione().getIscrizione(),
							cud.getDatiPrevidenziali().getINPDAP().getAnnoRif(),
							cud.getDatiGenerali().getUfficioServizio(),
							cud.getDatiGenerali().getDpt()
					);
				}

				/**
				 * insert dati elastic search
				 */
				codTipologiaEmissione = getTipologiaEmissione(cud.getDatiGenerali().getBarcode());
				descTipologiaEmissione = getDescTipologiaEmissione(codTipologiaEmissione);

				cudDocument = new CudDocument(true, false, idPostemissione, "", nomeFile_origine, codTipologiaEmissione, descTipologiaEmissione, cud);

				idIndexCedolino = creaIndiceCud(
						cud.getDatiGenerali().getIscrizione().getIscrizione(),
						cud.getDatiPrevidenziali().getINPDAP().getAnnoRif(),
						cud.getTestata().getLingua().value()
				);

				LOG.debug("Elastic search: cedolino - ced -" + idIndexCedolino);

				mappaCudDocument.put(idIndexCedolino, cudDocument);

				if (i % 250 == 0 || i == listaCud.size()) {
					//serviceFacadeElasticSearchStorico.insertCud(anno, mappaCudDocument, nomeFile_origine);
				}

				i++;
			}

		} catch (Exception e) {
			LOG.error("ERRORE ", e);
			LOG.error("delete su elastic search cedolino - ced- nomeFile: " + nomeFile_origine);
			//serviceFacadeElasticSearchStorico.deleteCedolino(anno, nomeFile_origine, idPostemissione);
			//serviceFacadeElasticSearchStorico.deleteMessaggio(anno, nomeFile_origine, idPostemissione);
			throw e;
		} finally {
			LOG.info("finally chiusura di searchClientService");
		}
	}

	private String creaIndiceCud(String iscrizione, String annoRif, String lingua) {
		StringBuffer sb = new StringBuffer("");

		if ("O".equalsIgnoreCase(tipoPostemissione)) {
			sb.append("CUD_").append(iscrizione).append("_").append(anno).append("_").append(lingua);
		} else {
			sb.append("CUD_").append(iscrizione).append("_").append(anno).append("_").append("0");
		}

		return sb.toString();
	}

	private String creaIndiceCedolino(CedolinoType cedolino, Cedolini item) {
		CedolinoType.Testata tst = cedolino.getTestata();
		String barcode = tst.getBarcode();
		String iscrizione = tst.getAnagrafica().getMatricola().getIscrizione();
		String rata = tst.getRata();
		String idCedolino = tst.getIDCedolino();
		String lingua = tst.getLingua().value();
		String string = postEmissioneDocument.getDescrizioneSottosistema();
		Date dataEmissione = item.getDataProduzione().toGregorianCalendar().getTime();
		BarcodeType bt = new BarcodeType(barcode);
		StringBuffer sb = new StringBuffer("");

		if ("O".equalsIgnoreCase(tipoPostemissione)) {
			sb.append("SPT_").append(bt.getNumeroMatricola()).append("_").append(bt.getMeseDiCompetenza()).append("_").
					append(bt.getProgressivoEmissione()).append("_").append(bt.getAnnoDiCompetenza()).append("_").append(bt.getTipoCedolino()).append("_")
					.append(bt.getMeseEmissione()).append("_").append(bt.getAnnoEmissione()).append("_")
					.append(bt.getTipoEmissione()).append(bt.getProgressivoTipologia()).append(bt.getFlagCessato());
		} else {
			sb.append(string).append("_1_").append(iscrizione).append("_").append(rata).append("_").append(sdf.format(dataEmissione)).append("_").append(idCedolino)
					.append("_").append(lingua);
		}

		return sb.toString();
	}

	private String getDescTipologiaEmissione(String codice) {
		String descTipologiaEmissione = mappaTipoEmissioni.get(codice);
		if (descTipologiaEmissione != null) {
			return descTipologiaEmissione;
		}

		return "Stipendi";
	}

	private String getTipologiaEmissione(String barcode) {
		BarcodeType bt = new BarcodeType(barcode);
		String tipologiaEmissione = bt.getProgressivoTipologia();
		return tipologiaEmissione;
	}

	private String getAnnoRata(String rata) {
		return rata.substring(0, 4);
	}

	public void setResource(Resource resource) {
		this.nomeFile_origine = resource.getFilename();
	}

	public void setIdPostemissione(int idPostemissione) {
		this.idPostemissione = idPostemissione;
	}

	public void setCaricaArtefattiOracle(boolean caricaArtefattiOracle) {
		this.caricaArtefattiOracle = caricaArtefattiOracle;
	}

	public void setMappaTipoEmissioni(Map<String, String> mappaTipoEmissioni) {
		this.mappaTipoEmissioni = mappaTipoEmissioni;
	}

	public void setTipoPostemissione(String tipoPostemissione) {
		this.tipoPostemissione = tipoPostemissione;
	}
}
