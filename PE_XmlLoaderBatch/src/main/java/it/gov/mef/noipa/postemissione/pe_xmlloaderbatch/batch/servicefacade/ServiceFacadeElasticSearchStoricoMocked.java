package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.CedolinoDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.CudDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.MessaggioDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.PostEmissioneDocument;

@Component
public class ServiceFacadeElasticSearchStoricoMocked implements IServiceFacadeElasticSearchStorico {

	private static final Logger LOG = Logger.getLogger(ServiceFacadeElasticSearchMocked.class);
	
	@Override
	public void insertPostemissione(int idPostemissione, PostEmissioneDocument postEmissioneDocument, String type) {
		LOG.debug(""+this.getClass().getName()+"insertPostemissione idPostemissione["+idPostemissione+"] type["+type+"]" );
	}

	@Override
	public void insertCedolino(String anno, Map<String, CedolinoDocument> mappaCedolinoDocument,
			Map<String, List<MessaggioDocument>> mappaListaMessaggioDocument, String nomeFile_origine)
			throws Exception {
		LOG.debug(""+this.getClass().getName()+"insertCedolino anno["+anno+"] nomeFile_origine["+nomeFile_origine+"]" );

	}

	@Override
	public void insertCud(String anno, Map<String, CudDocument> mappaCudDocument, String nomeFile_origine)
			throws Exception {
		LOG.debug(""+this.getClass().getName()+"insertCud anno["+anno+"] nomeFile_origine["+nomeFile_origine+"]" );

	}

	@Override
	public void deleteCedolino(String anno, String filename, int idPostemissione) {
		LOG.debug(""+this.getClass().getName()+"deleteCedolino anno["+anno+"] filename["+filename+"] idPostemissione["+idPostemissione+"]" );

	}

	@Override
	public void deleteMessaggio(String anno, String filename, int idPostemissione) {
		LOG.debug(""+this.getClass().getName()+"deleteMessaggio anno["+anno+"] filename["+filename+"] idPostemissione["+idPostemissione+"]" );

	}

	@Override
	public void deleteCu(String anno, String filename, int idPostemissione) {
		LOG.debug(""+this.getClass().getName()+"deleteCu anno["+anno+"] filename["+filename+"] idPostemissione["+idPostemissione+"]" );
	}
}
