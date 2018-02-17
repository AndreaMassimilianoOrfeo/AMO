package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.batch.cu;

import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.DepconCudWrapper;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.service.cu.DepconConverterService;

public class Reader implements ResourceAwareItemReaderItemStream<DepconCudWrapper> {

	private static final Logger LOGGER = Logger.getLogger(Reader.class);
	@Autowired
	DepconConverterService depconConverterService;
	
	private Resource resource;
	private Iterator<DepconCudWrapper> iter;
	Date timeStart = new Date();
	
	public DepconCudWrapper read() throws Exception {
		
		if (iter == null){
			Date timeMarshall = new Date();
			iter = depconConverterService.convertCudDepcon(resource).iterator();
			LOGGER.info("Tempo unmarshall:" + (new Date().getTime() - timeMarshall.getTime() ));
		}

		if (iter.hasNext()){
			DepconCudWrapper result = iter.next();
			return result;
		}else {
			LOGGER.info("Tempo totale Iterator:" + (new Date().getTime() - timeStart.getTime() ));
			
			return null;
		}
	}


	public void setResource(Resource arg0) {
		resource = arg0;
	}


	public void close() throws ItemStreamException {
		LOGGER.info("close Reader");
	}


	public void open(ExecutionContext arg0) throws ItemStreamException {
		LOGGER.info("open Reader");
	}


	public void update(ExecutionContext arg0) throws ItemStreamException {
		LOGGER.info("update Reader");
	}


	public Iterator<DepconCudWrapper> getIter() {
		return iter;
	}


	public void setIter(Iterator<DepconCudWrapper> iter) {
		this.iter = iter;
	}

}
