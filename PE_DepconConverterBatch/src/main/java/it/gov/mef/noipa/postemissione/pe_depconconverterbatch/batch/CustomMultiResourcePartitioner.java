package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.batch;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.Constants;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.OrigineDati;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.db.ServiceFacade;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.util.Assert;

public class CustomMultiResourcePartitioner implements Partitioner {

	@Autowired
	private ServiceFacade serviceFacade;
	private static final Logger LOGGER = Logger.getLogger(CustomMultiResourcePartitioner.class);
    private static final String PARTITION_KEY = "partition";
    private Resource[] resources = new Resource[0];
    private String inputKeyName = "inputFilePath";
    private String outputKeyName = "outputFileName";
    
    private String outputDir;
    @SuppressWarnings("unused")
	private String fileExtension;
    private String rataEmissione;
    private String progressivoEmissione;
    
    private OracleSequenceMaxValueIncrementer seqIdPostemissione;
    private OracleSequenceMaxValueIncrementer seqIdOrigineDati;
    
    private Map<String, OrigineDati> origineDatiMap;
	private String mode;


	public static long startTime;
	

    /**
     * Assign the filename of each of the injected resources to an
     * {@link ExecutionContext}.
     * 
     * @see Partitioner#partition(int)
     */
    public Map<String, ExecutionContext> partition(int gridSize) {
		startTime = System.currentTimeMillis();
        Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>(gridSize);
        
        long idPostEmissione = 0;
        
        if(origineDatiMap.isEmpty()) {
        	 idPostEmissione = seqIdPostemissione.nextLongValue();
             Integer idDocumento = 0;

             if (mode.equals("cedolino"))
            	 idDocumento = 1;
             else if (mode.equals("cud") || mode.equals("cu"))
            	 idDocumento = 2;
             
             serviceFacade.insertPostemissione(idPostEmissione, idDocumento, rataEmissione, progressivoEmissione, Constants.FLUSSO_DATI_DEPCON_PRESO_IN_CARICO );
        }else {
        	for (OrigineDati origineDati : origineDatiMap.values()) {
        		idPostEmissione = origineDati.getIdPostEmissione();
        		break;
			}
        }
        
        LOGGER.info("Elaborazione postemissione " + idPostEmissione);

        int i = 0;
        for (Resource resource : resources) {
            ExecutionContext context = new ExecutionContext();
            Assert.state(resource.exists(), "Resource does not exist: " + resource);
            
            String nomeFileOutput = getFileName(resource);
            try {
            	OrigineDati origineDatiFromContext  = origineDatiMap.get(resource.getFilename()); 
            	
            	long idOrigineDati;
            	
            	if(origineDatiFromContext == null) {
            		idOrigineDati = seqIdOrigineDati.nextLongValue();
            		serviceFacade.insertOrigineDati(idPostEmissione, idOrigineDati, nomeFileOutput, Constants.FLUSSO_DATI_DEPCON_PRESO_IN_CARICO );
                	
            	}else {
            		idOrigineDati = origineDatiFromContext.getIdOrigineDati();
            	}
            	
            	
            	
            	
        		OrigineDati origineDati = new OrigineDati();
        		origineDati.setNomeFile(nomeFileOutput);
        		origineDati.setIdPostEmissione(idPostEmissione);
        		origineDati.setIdOrigineDati(idOrigineDati);
        		origineDati.setTotDoc(BigInteger.ZERO);
        		origineDati.setTotNetto(Double.parseDouble("0"));
        		origineDatiMap.put(resource.getFilename(), origineDati);            	
            	
            	context.putInt("counter", 1);
                context.putString(inputKeyName, resource.getURL().toExternalForm());
                context.put(outputKeyName, createOutputFilename(i, resource, nomeFileOutput));
            } catch (IOException e) {
                throw new IllegalArgumentException("File could not be located for: " + resource, e);
            }
            map.put(PARTITION_KEY+ resource.getFilename(), context);
            i++;
        }
        
        return map;
    }



    
    

    /**
     * Creates distinct output file name per partition.
     *
     * @param partitionId
     * @param context
     * @param resource
     * @return 
     */
    private String createOutputFilename(int partitionId, Resource resource, String nomeFileOutput) {
    	StringBuffer outputFileCompleteName = new StringBuffer(outputDir);
    	outputFileCompleteName.append("/");
    	outputFileCompleteName.append(nomeFileOutput);
        logOutputFilename(resource, outputFileCompleteName);
        return outputFileCompleteName.toString();
    }
    
    private String getFileName(Resource resource) {
    	String name = resource.getFilename();
    	name = name + ".xml";
    	return name;
    }

    private void logOutputFilename(Resource resource, StringBuffer outputFileName) {
    	StringBuffer sb = new StringBuffer("for inputfile:'");
    	sb.append(resource.getFilename());
    	sb.append("' outputfilename:'");
    	sb.append(outputFileName);
    	sb.append("' was created");
    	LOGGER.info(sb);
	}

	public void setResources(Resource[] resources) {
        this.resources = resources;
    }

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public void setOrigineDatiMap(Map<String, OrigineDati> origineDatiMap) {
		this.origineDatiMap = origineDatiMap;
	}
	
	public void setSeqIdPostemissione(
			OracleSequenceMaxValueIncrementer seqIdPostemissione) {
		this.seqIdPostemissione = seqIdPostemissione;
	}

	public void setSeqIdOrigineDati(
			OracleSequenceMaxValueIncrementer seqIdOrigineDati) {
		this.seqIdOrigineDati = seqIdOrigineDati;
	}

	public void setRataEmissione(String rataEmissione) {
		this.rataEmissione = rataEmissione;
	}

	public void setProgressivoEmissione(String progressivoEmissione) {
		this.progressivoEmissione = progressivoEmissione;
	}   
	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
