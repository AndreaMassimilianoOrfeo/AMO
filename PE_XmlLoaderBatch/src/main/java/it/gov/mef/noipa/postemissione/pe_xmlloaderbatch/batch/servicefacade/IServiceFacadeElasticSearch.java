package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade;

import java.util.List;
import java.util.Map;

import it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino.Ced;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.CudDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.MessaggioDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.PostEmissioneDocument;

public interface IServiceFacadeElasticSearch {
	
	public void insertPostemissione(int idPostemissione, PostEmissioneDocument postEmissioneDocument, String type);
	public void insertCedolino(String anno, Map<String, Ced> mappaCedolinoDocument, Map<String, List<MessaggioDocument>> mappaListaMessaggioDocument, String nomeFile_origine) throws Exception;
	public void insertCud(String anno, Map<String, CudDocument> mappaCudDocument, String nomeFile_origine) throws Exception;
	public void deleteCedolino(String anno, String filename, int idPostemissione);
	public void deleteMessaggio(String anno, String filename, int idPostemissione);
	public void deleteCu(String anno, String filename, int idPostemissione) ;
}
