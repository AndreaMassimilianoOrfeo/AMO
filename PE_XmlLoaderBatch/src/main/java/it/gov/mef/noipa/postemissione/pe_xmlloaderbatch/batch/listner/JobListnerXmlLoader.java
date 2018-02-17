package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.listner;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.Constants;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper.ScartoXml;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeJDBC;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

public class JobListnerXmlLoader implements JobExecutionListener {

	@Autowired
	private ServiceFacadeJDBC serviceFacade;

	private static final Logger LOGGER = Logger.getLogger(JobListnerXmlLoader.class);

	public void beforeJob(JobExecution jobExecution) {
	}

	public void afterJob(JobExecution je) {

		int idPostemissione = Integer.valueOf(je.getJobParameters().getString("id.postemissione"));
		String exitCode = je.getExitStatus().getExitCode();

		LOGGER.info(">>> Job exit code: " + exitCode + " idPostemissione:" + idPostemissione);

		int statoPostEmissione = Constants.DOCUMENTI_INOLTRATI_PER_LA_PRODUZIONE_CON_SUCCESSO;

		if (!exitCode.equals(ExitStatus.COMPLETED.getExitCode())) {
			statoPostEmissione = Constants.KO_DOCUMENTI_INDICIZZATI_NON_INOLTRATI;
		}

		List<Integer> listaStatiOrig = new ArrayList<Integer>();
		listaStatiOrig.add(Constants.FLUSSO_DATI_XML_PRESO_IN_CARICO);

		serviceFacade.updateStatoPostemissione(idPostemissione, statoPostEmissione, listaStatiOrig);
	}

}
