package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.batch.cu;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

import it.gov.mef.noipa.postemissione.parser.autogenerated.cu.cu.Cedolini;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.batch.CustomMultiResourcePartitioner;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.OrigineDati;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.db.ServiceFacade;


public class Writer implements ItemWriter<Cedolini.Cu> {

	@Autowired
	private ServiceFacade serviceFacade;
	private Marshaller marshaller;
	private String outputFile;
	private Resource resource;
	private String moveDir;
	private Map<String, OrigineDati> origineDatiMap;
	private Logger logger = Logger.getLogger(Writer.class);
	private String validareXml;

	public void setValidareXml(String validareXml) {
		this.validareXml = validareXml;
	}

	public void write(List<? extends Cedolini.Cu> lista) throws Exception {

		Date time = new Date();
	    creaFileXmlCu(lista);
		logger.info("Tempo creafileXML:" + (new Date().getTime() - time.getTime() ));

		time = new Date();
	    serviceFacade.updateStatoFile(origineDatiMap, resource);
	    
//	    logger.info("Delete del file: "+resource.getFile().toPath());
	    logger.info("mv del file: "+resource.getFile().toPath() + " to "+moveDir+"/"+resource.getFilename());	  

	    Files.move(resource.getFile().toPath() ,new File(moveDir+"/"+resource.getFilename()).toPath(), REPLACE_EXISTING);
	    
//	    Files.deleteIfExists(resource.getFile().toPath());

	    logger.info(" records processsed in "+(System.currentTimeMillis()- CustomMultiResourcePartitioner.startTime)+" milliseconds");
		logger.info("Tempo scrittura File:" + (new Date().getTime() - time.getTime() ));
	}

	private void creaFileXmlCu(List<? extends Cedolini.Cu> lista) throws JAXBException, FileNotFoundException, DatatypeConfigurationException, IOException, SAXException {
	
		JAXBContext jc = JAXBContext.newInstance( "it.gov.mef.noipa.postemissione.parser.autogenerated.cu.cu" );
		marshaller = jc.createMarshaller();
	    OutputStream os = new FileOutputStream(outputFile);
	    
	    Cedolini fileXmlCu = new Cedolini();
	    fileXmlCu.setCodiceSistemaEmittente("0001");
	    fileXmlCu.getCu().addAll(lista);
	    
	    if(validareXml==null || validareXml.equalsIgnoreCase("s")){
	       
	   	try {
	   		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
	        URL resourceFile = getClass().getResource("/cu/CU.xsd");
		    Schema schema = sf.newSchema(resourceFile);
		        
		    marshaller.setSchema(schema);
		    marshaller.marshal(fileXmlCu, os );        
		        
		    } catch (Exception e) {
		    	logger.error("Errore creaFileXmlCu ", e);
		    	throw e;
		    }
	   		finally {
	   			os.close();
			}
	    }
	}
	
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setMoveDir(String moveDir) {
		this.moveDir = moveDir;
	}
	
	public void setOrigineDatiMap(Map<String, OrigineDati> origineDatiMap) {
		this.origineDatiMap = origineDatiMap;
	}

}
