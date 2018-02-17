package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.batch.listner;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.OrigineDati;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.db.ServiceFacade;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

public class StepListnerDepconConverter extends StepExecutionListenerSupport {

	@Autowired
	private ServiceFacade serviceFacade;
	private Resource resource;
	private String moveDir;
	private String outputFile;
	private Map<String, OrigineDati> origineDatiMap;
	
	private Logger logger = Logger.getLogger(StepListnerDepconConverter.class);
	
	public ExitStatus afterStep(StepExecution stepExecution) {
		String exitCode = stepExecution.getExitStatus().getExitCode();
		
		logger.debug(">>>>>>>>>>>>>>>>>>>>"+exitCode);

		if (!exitCode.equals(ExitStatus.COMPLETED.getExitCode())) {
			try {
				Files.deleteIfExists((new File(outputFile).toPath()));
				Files.deleteIfExists((new File(moveDir+"/"+resource.getFilename()).toPath()));
				serviceFacade.updateOrigineDatiStato(origineDatiMap, resource);
			} catch (Exception e) {
				serviceFacade.updateOrigineDatiStato(origineDatiMap, resource);
				logger.error("Errore durante il reset dell'elaborazione del file "+resource.getFilename(), e);
				return stepExecution.getExitStatus().addExitDescription(e);
			}
		}

        return stepExecution.getExitStatus();
    }


	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setMoveDir(String moveDir) {
		this.moveDir = moveDir;
	}
	
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
	
	public void setOrigineDatiMap(Map<String, OrigineDati> origineDatiMap) {
		this.origineDatiMap = origineDatiMap;
	}

	
}
