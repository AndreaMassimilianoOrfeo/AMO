package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.Constants;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.PostEmissioneDocument;
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

public class CustomMultiResourcePartitionerCedLoader implements Partitioner {

	private static final Logger LOGGER = Logger.getLogger(CustomMultiResourcePartitionerCedLoader.class);
	private static final String PARTITION_KEY = "partition";
	private Resource[] resources = new Resource[0];
	private String inputKeyName = "inputFilePath";
	private int idPostemissione;

	@Autowired
	private ServiceFacadeJDBC serviceFacadeJDBC;

	public static long startTime;

	/**
	 * Assign the filename of each of the injected resources to an
	 * {@link ExecutionContext}.
	 *
	 * @see Partitioner#partition(int)
	 */
	public Map<String, ExecutionContext> partition(int gridSize) {

		LOGGER.info(">>> Lettura file nella cartella per la classe CustomMultiResourcePartitionerCedLoader ");
		startTime = System.currentTimeMillis();
		Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>(gridSize);
		PostEmissioneDocument postEmissioneDocument = serviceFacadeJDBC.getPostemissione(idPostemissione);
		Assert.notNull(postEmissioneDocument, "Nessuna post emissione con id:" + idPostemissione);

		List<Integer> listaStatiOrig = new ArrayList<Integer>();
		listaStatiOrig.add(Constants.DOCUMENTI_PRESI_IN_CARICO);
		listaStatiOrig.add(Constants.DOCUMENTI_PUBBLICATI_CON_SUCCESSO);

		for (Resource resource : resources) {
			ExecutionContext context = new ExecutionContext();
			Assert.state(resource.exists(), "Resource does not exist: " + resource);

			int numeroFilePerId = serviceFacadeJDBC.countOrigineDatiCedLoader(idPostemissione, resource.getFilename(), Constants.ARTEFATTI_PUBBLICATI, listaStatiOrig);

			if (numeroFilePerId > 0) {

				try {

					context.putString("rootElement", postEmissioneDocument.getRootElement());
					context.putString("pathRootElement", postEmissioneDocument.getPathRootElement());
					context.putString("schemaLocation", postEmissioneDocument.getSchemaLocation());
					context.putInt("counter", 1);
					context.putString(inputKeyName, resource.getURL().toExternalForm());
					LOGGER.info(">>>>CustomMultiResourcePartitionerCedLoader:" + resource.getURL().toExternalForm());

				} catch (IOException e) {
					throw new IllegalArgumentException("File could not be located for: " + resource, e);

				}

				map.put(PARTITION_KEY + "" + resource.getFilename(), context);
			} else {
				LOGGER.warn("Il file " + resource.getFilename() + " non appartiene alla postemissione: " + idPostemissione);
			}

		}

		return map;
	}

	public void setResources(Resource[] resources) {
		this.resources = resources;
	}

	public void setIdPostemissione(int idPostemissione) {
		this.idPostemissione = idPostemissione;
	}

}
