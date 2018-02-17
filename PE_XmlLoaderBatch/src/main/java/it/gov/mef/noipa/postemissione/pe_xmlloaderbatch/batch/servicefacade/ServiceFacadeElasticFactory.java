package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacadeElasticFactory {

	private static final Logger LOG = Logger.getLogger(ServiceFacadeElasticFactory.class);
	
	@Autowired
	ServiceFacadeElasticSearch serviceFacadeElasticSearch;
	
	@Autowired
	ServiceFacadeElasticSearchStorico serviceFacadeElasticSearchStorico;
	
	@Autowired
	ServiceFacadeElasticSearchMocked serviceFacadeElasticSearchMocked;
	
	@Autowired
	ServiceFacadeElasticSearchStoricoMocked serviceFacadeElasticSearchStoricoMocked;
	
	public IServiceFacadeElasticSearch getServiceFacadeElasticInstance() {
	
		String DB_ELASTICSEARCH_CLUSTERNAME = System.getProperty("DB_ELASTICSEARCH_CLUSTERNAME");
		String DB_ELASTICSEARCH_STORICO_CLUSTERNAME = System.getProperty("DB_ELASTICSEARCH_STORICO_CLUSTERNAME");
		
		boolean serviceFacadeElasticMocked = ( ( DB_ELASTICSEARCH_CLUSTERNAME.contains("svil") && DB_ELASTICSEARCH_STORICO_CLUSTERNAME.contains("svil") ) ? true : false ) ;
		
		LOG.info(">>>>> getServiceFacadeElasticInstance DB_ELASTICSEARCH_CLUSTERNAME : " + System.getProperty("DB_ELASTICSEARCH_CLUSTERNAME"));
		LOG.info(">>>>> getServiceFacadeElasticInstance DB_ELASTICSEARCH_STORICO_CLUSTERNAME : " +System.getProperty("DB_ELASTICSEARCH_STORICO_CLUSTERNAME"));

		if ( serviceFacadeElasticMocked )
			return serviceFacadeElasticSearchMocked;
		else
			return serviceFacadeElasticSearch;
	}
	
	public IServiceFacadeElasticSearchStorico getServiceFacadeElasticStoricoInstance() {
		
		String DB_ELASTICSEARCH_CLUSTERNAME = System.getProperty("DB_ELASTICSEARCH_CLUSTERNAME");
		String DB_ELASTICSEARCH_STORICO_CLUSTERNAME = System.getProperty("DB_ELASTICSEARCH_STORICO_CLUSTERNAME");
		
		boolean serviceFacadeElasticMocked = ( ( DB_ELASTICSEARCH_CLUSTERNAME.contains("svil") && DB_ELASTICSEARCH_STORICO_CLUSTERNAME.contains("svil") ) ? true : false ) ;
		
		LOG.info(">>>>> getServiceFacadeElasticInstance DB_ELASTICSEARCH_CLUSTERNAME : " + System.getProperty("DB_ELASTICSEARCH_CLUSTERNAME"));
		LOG.info(">>>>> getServiceFacadeElasticInstance DB_ELASTICSEARCH_STORICO_CLUSTERNAME : " +System.getProperty("DB_ELASTICSEARCH_STORICO_CLUSTERNAME"));

		if ( serviceFacadeElasticMocked )
			return serviceFacadeElasticSearchStoricoMocked;
		else
			return serviceFacadeElasticSearchStorico;
	}
}
