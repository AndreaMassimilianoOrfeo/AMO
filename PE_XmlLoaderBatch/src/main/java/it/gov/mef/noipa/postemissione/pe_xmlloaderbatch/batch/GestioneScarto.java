package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper.ScartoXml;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeJDBCCedLoader;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.Scarti;
import org.springframework.beans.factory.annotation.Autowired;

public class GestioneScarto {

	@Autowired
	public ServiceFacadeJDBCCedLoader serviceFacadeJDBCCedLoader;

	public void inserimentoScarto(ServiceFacadeJDBCCedLoader JDBCCedLoader, String fileName, String pdf, int codErrore, String errore, int idOrigineDati) throws FileNotFoundException, UnsupportedEncodingException {

		Scarti scarto = new Scarti();
		scarto.setPdf(pdf);
		scarto.setDescErroreScarto(errore);
		scarto.setErroreScarto(codErrore);

		ScartoXml.listScarti.add(scarto);
	}
}
