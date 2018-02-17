package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.ComboBean;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.Constants;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.PostEmissioneDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeElasticSearch;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeElasticSearchStorico;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeJDBC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class CustomMultiResourcePartitioner implements Partitioner {

	private static final Logger LOGGER = Logger.getLogger(CustomMultiResourcePartitioner.class);
	private static final String PARTITION_KEY = "partition";
	private Resource[] resources = new Resource[0];
	private String inputKeyName = "inputFilePath";
	private int idPostemissione;

	@Autowired
	private ServiceFacadeJDBC serviceFacadeJDBC;

	//@Autowired
	//private ServiceFacadeElasticSearch serviceFacadeElasticSearch;
	//@Autowired
	//private ServiceFacadeElasticSearchStorico serviceFacadeElasticSearchStorico;

	public static long startTime;

	/**
	 * Assign the filename of each of the injected resources to an
	 * {@link ExecutionContext}.
	 *
	 * @see Partitioner#partition(int)
	 */
	public Map<String, ExecutionContext> partition(int gridSize) {

		LOGGER.info(">>> Lettura file nella cartella ");
	
		startTime = System.currentTimeMillis();
		Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>(gridSize);

		List<Integer> listaStatiOrig = new ArrayList<Integer>();
		listaStatiOrig.add(Constants.FLUSSO_DATI_DEPCON_CONVERTITO);
		listaStatiOrig.add(Constants.KO_DOCUMENTI_INDICIZZATI_NON_INOLTRATI);

		int numAgg = serviceFacadeJDBC.updateStatoPostemissione(idPostemissione, Constants.FLUSSO_DATI_XML_PRESO_IN_CARICO, listaStatiOrig);

		Assert.isTrue(numAgg == 1, "Impossibile elaborare la postemissione con l'id " + idPostemissione + " codice stato diverso da " + Constants.FLUSSO_DATI_DEPCON_CONVERTITO + " o " + Constants.KO_DOCUMENTI_INDICIZZATI_NON_INOLTRATI);

		Map<String, String> mappaTipoEmissioni = new HashMap<String, String>();
		List<ComboBean> listaCombo = serviceFacadeJDBC.getDescTipoEmissioni(idPostemissione);

		for (ComboBean comboBean : listaCombo) {
			LOGGER.debug("Tipologie caricate:" + comboBean.getCodice() + " - " + comboBean.getDescrizione());
			mappaTipoEmissioni.put(comboBean.getCodice(), comboBean.getDescrizione());
		}

		PostEmissioneDocument postEmissioneDocument = serviceFacadeJDBC.getPostemissione(idPostemissione);
		Assert.notNull(postEmissioneDocument, "Nessuna post emissione con id:" + idPostemissione);

		for (Resource resource : resources) {
			ExecutionContext context = new ExecutionContext();
			Assert.state(resource.exists(), "Resource does not exist: " + resource);

			int numeroFilePerId = serviceFacadeJDBC.countOrigineDati(idPostemissione, Constants.FLUSSO_DATI_XML_PRESO_IN_CARICO, listaStatiOrig, resource.getFilename());

			if (numeroFilePerId > 0) {
				try {
					context.putString("rootElement", postEmissioneDocument.getRootElement());
					context.putString("pathRootElement", postEmissioneDocument.getPathRootElement());
					context.putString("schemaLocation", postEmissioneDocument.getSchemaLocation());

					context.putInt("counter", 1);
					context.putString(inputKeyName, resource.getURL().toExternalForm());
					context.put("mappaTipoEmissioni", mappaTipoEmissioni);
					int numAggOrigineDati = serviceFacadeJDBC.updateStatoOrigineDati(idPostemissione, Constants.FLUSSO_DATI_XML_PRESO_IN_CARICO, listaStatiOrig, resource.getFilename());
					if (numAggOrigineDati == 1) {
						LOGGER.info("File valido: " + resource.getURL().toExternalForm() + "di tipo: " + postEmissioneDocument.getTypeDocumento());
						map.put(PARTITION_KEY + "" + resource.getFilename(), context);
					} else {
						LOGGER.warn("Impossibile elaborare il file " + resource.getFilename() + " con id postemissione " + idPostemissione + ", codice stato diverso da " + Constants.FLUSSO_DATI_DEPCON_CONVERTITO + " o " + Constants.KO_DOCUMENTI_INDICIZZATI_NON_INOLTRATI);
					}
				} catch (IOException e) {
					throw new IllegalArgumentException("File could not be located for: " + resource, e);
				}
			} else {
				LOGGER.warn("Il file " + resource.getFilename() + " non appartiene alla postemissione: " + idPostemissione);
			}
		}

		//serviceFacadeElasticSearch.insertPostemissione(idPostemissione, postEmissioneDocument, postEmissioneDocument.getTypeDocumento());
		postEmissioneDocument.setPubblicato(true);
		//serviceFacadeElasticSearchStorico.insertPostemissione(idPostemissione, postEmissioneDocument, postEmissioneDocument.getTypeDocumento());
		postEmissioneDocument.setPubblicato(false);

		return map;
	}

	public void setResources(Resource[] resources) {
		this.resources = resources;
	}

	public void setIdPostemissione(int idPostemissione) {
		this.idPostemissione = idPostemissione;
	}

}
