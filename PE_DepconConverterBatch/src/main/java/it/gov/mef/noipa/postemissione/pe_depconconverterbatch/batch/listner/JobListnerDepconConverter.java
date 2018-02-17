package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.batch.listner;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.Constants;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.OrigineDati;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.db.ServiceFacade;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

public class JobListnerDepconConverter implements JobExecutionListener {

	@Autowired
	private ServiceFacade serviceFacade;
	private static final Logger LOGGER = Logger.getLogger(JobListnerDepconConverter.class);
	
	static public Date time;

	public void afterJob(JobExecution je) {
		
		String exitCode = je.getExitStatus().getExitCode();
		@SuppressWarnings("unchecked")
		Map<String, OrigineDati> origineDatiMap = ( HashMap<String, OrigineDati>)je.getExecutionContext().get("pe.depconconverter.originedati");
		for (String nomeFile : origineDatiMap.keySet()) {
			LOGGER.debug(">>>Job exit code: "+exitCode);
			int statoPostEmissione = Constants.FLUSSO_DATI_DEPCON_CONVERTITO;  
			
			if (!exitCode.equals(ExitStatus.COMPLETED.getExitCode()) ) {
				statoPostEmissione = Constants.KO_FLUSSO_DATI_DEPCON_NON_CONVERTITO;
			}
			
			long idPostEmissione = origineDatiMap.get(nomeFile).getIdPostEmissione();
			serviceFacade.updateStatoPostemissione(idPostEmissione, statoPostEmissione);
			break;
		}
		
		LOGGER.info(new Date() + " Tempo Totale Esecuzione: " + getDurationBreakdown(new Date().getTime() - JobListnerDepconConverter.time.getTime() ));
		
	}

	public void beforeJob(JobExecution je) {
		time = new Date();
		LOGGER.debug("START AT: " + time);
		LOGGER.debug("------------before job:"+je.getExecutionContext().get("pe.depconconverter.originedati"));
		if (je.getExecutionContext().get("pe.depconconverter.originedati")==null) {
			Map<String, OrigineDati> origineDati = new HashMap<String, OrigineDati>();
			je.getExecutionContext().put("pe.depconconverter.originedati", origineDati);
		}
		
	}
	
	 public static String getDurationBreakdown(long millis) {
	        if(millis < 0){
	            throw new IllegalArgumentException("Duration must be greater than zero!");
	        }

	        long days = TimeUnit.MILLISECONDS.toDays(millis);
	        millis -= TimeUnit.DAYS.toMillis(days);
	        long hours = TimeUnit.MILLISECONDS.toHours(millis);
	        millis -= TimeUnit.HOURS.toMillis(hours);
	        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
	        millis -= TimeUnit.MINUTES.toMillis(minutes);
	        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

	        StringBuilder sb = new StringBuilder(64);
	        sb.append(millis);
	        sb.append("ms = ");
	        sb.append(days);
	        sb.append(" Days ");
	        sb.append(hours);
	        sb.append(" Hours ");
	        sb.append(minutes);
	        sb.append(" Minutes ");
	        sb.append(seconds);
	        sb.append(" Seconds");

	        return sb.toString();
	    }

}
