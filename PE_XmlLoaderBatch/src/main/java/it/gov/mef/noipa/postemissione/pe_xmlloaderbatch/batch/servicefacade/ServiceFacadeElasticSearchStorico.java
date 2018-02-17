package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade;

import it.gov.mef.noipa.postemissione.elasticsearch.client.SearchClientServiceImpl;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.CedolinoDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.CudDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.MessaggioDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.PostEmissioneDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.deletebyquery.DeleteByQueryResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.google.gson.Gson;

@Component
public class ServiceFacadeElasticSearchStorico implements IServiceFacadeElasticSearchStorico{

	@Autowired
	@Qualifier(value = "searchClientServiceStorico")
	private SearchClientServiceImpl searchClientService;

	private static final Logger LOG = Logger.getLogger(ServiceFacadeElasticSearchStorico.class);

	public void insertPostemissione(int idPostemissione, PostEmissioneDocument postEmissioneDocument, String type) {

		String gsonEmissioneDocument = new Gson().toJson(postEmissioneDocument);
		BulkRequestBuilder bulkRequest = searchClientService.getClient().prepareBulk();
		bulkRequest.add(
				searchClientService.getClient()
				.prepareIndex("postemissione", type, String.valueOf(idPostemissione))
				.setSource(gsonEmissioneDocument));

		BulkResponse bulkRes = bulkRequest.execute().actionGet();
		Assert.isTrue(!bulkRes.hasFailures(), "##### Bulk Request failure with error: " + bulkRes.buildFailureMessage() + "idPostemissione: " + idPostemissione);
		LOG.debug("Elasticsearch bulk indexing completed in: " + bulkRes.getTookInMillis() + " milliseconds - idPostemissione: " + idPostemissione);

	}

	public void insertCedolino(String anno, Map<String, CedolinoDocument> mappaCedolinoDocument, Map<String, List<MessaggioDocument>> mappaListaMessaggioDocument, String nomeFile_origine) throws Exception {
		BulkRequestBuilder bulkRequest = searchClientService.getClient().prepareBulk();

		List<String> listaIndexCedolini = new ArrayList<String>(mappaCedolinoDocument.keySet());
		for (String indexCedolino : listaIndexCedolini) {
			String gsonCedolinoDocument = new Gson().toJson(mappaCedolinoDocument.get(indexCedolino));
			bulkRequest.add(
					searchClientService.getClient()
					.prepareIndex("cedolino." + anno, "ced", indexCedolino)
					.setSource(gsonCedolinoDocument));
		}

		List<String> listaIndexMessaggi = new ArrayList<String>(mappaListaMessaggioDocument.keySet());
		for (String indexCedolino : listaIndexMessaggi) {
			List<MessaggioDocument> listMessaggi = mappaListaMessaggioDocument.get(indexCedolino);
			for (MessaggioDocument messaggioDocument : listMessaggi) {
				String gsonMsgDocument = new Gson().toJson(messaggioDocument);
				bulkRequest.add(
						searchClientService.getClient()
						.prepareIndex("messaggio." + anno, "cedolino", "msg" + indexCedolino)
						.setSource(gsonMsgDocument));
			}
		}

		BulkResponse bulkRes = bulkRequest.execute().actionGet();

		if (bulkRes.hasFailures()) {
			LOG.error("##### Bulk Request failure with error: " + bulkRes.buildFailureMessage());
			throw new Exception("##### Bulk Request failure with error: " + bulkRes.buildFailureMessage() + " Nome file: " + nomeFile_origine);
		}
		LOG.debug("Elasticsearch bulk indexing completed in: " + bulkRes.getTookInMillis() + " milliseconds - Nome file: " + nomeFile_origine);
		bulkRequest = searchClientService.getClient().prepareBulk();

	}

	public void insertCud(String anno, Map<String, CudDocument> mappaCudDocument, String nomeFile_origine) throws Exception {
		BulkRequestBuilder bulkRequest = searchClientService.getClient().prepareBulk();

		List<String> listaIndexCud = new ArrayList<String>(mappaCudDocument.keySet());
		for (String indexCud : listaIndexCud) {
			String gsonCudDocument = new Gson().toJson(mappaCudDocument.get(indexCud));
			bulkRequest.add(
					searchClientService.getClient()
					.prepareIndex("cud." + anno, "cud", indexCud)
					.setSource(gsonCudDocument));

		}

		BulkResponse bulkRes = bulkRequest.execute().actionGet();

		if (bulkRes.hasFailures()) {
			LOG.error("##### Bulk Request failure with error: " + bulkRes.buildFailureMessage());
			throw new Exception("##### Bulk Request failure with error: " + bulkRes.buildFailureMessage() + " Nome file: " + nomeFile_origine);
		}
		LOG.debug("Elasticsearch bulk indexing completed in: " + bulkRes.getTookInMillis() + " milliseconds - Nome file: " + nomeFile_origine);
		bulkRequest = searchClientService.getClient().prepareBulk();

	}

	public void deleteCedolino(String anno, String filename, int idPostemissione) {

		DeleteByQueryResponse responseDeleteCed = searchClientService.getClient()
				.prepareDeleteByQuery("cedolino." + anno)
				.setQuery(QueryBuilders.boolQuery()
						.must(QueryBuilders
								.termQuery("nomeFile", filename))
						.must(QueryBuilders
								.termQuery("idPostemissione", idPostemissione))
				).execute().actionGet();
		LOG.info("##### Response after delete ced:" + responseDeleteCed.status());
	}

	public void deleteCu(String anno, String filename, int idPostemissione) {

		DeleteByQueryResponse responseDeleteCed = searchClientService.getClient()
				.prepareDeleteByQuery("cu." + anno)
				.setQuery(QueryBuilders.boolQuery()
						.must(QueryBuilders
								.termQuery("nomeFile", filename))
						.must(QueryBuilders
								.termQuery("idPostemissione", idPostemissione))
				).execute().actionGet();
		LOG.info("##### Response after delete cu:" + responseDeleteCed.status());
	}

	
	public void deleteMessaggio(String anno, String filename, int idPostemissione) {

		DeleteByQueryResponse responseDeleteMsg = searchClientService.getClient()
				.prepareDeleteByQuery("messaggio." + anno)
				.setQuery(QueryBuilders.boolQuery()
						.must(QueryBuilders
								.termQuery("nomeFile", filename))
						.must(QueryBuilders
								.termQuery("idPostemissione", idPostemissione))
				).execute().actionGet();

		LOG.info("##### Response after delete  msg:" + responseDeleteMsg);

	}

}
