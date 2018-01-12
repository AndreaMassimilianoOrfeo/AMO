package it.gov.mef.cuconverter.util;

import java.io.StringReader;
import java.util.List;

import org.coury.jfilehelpers.engines.FileHelperEngine;

import it.gov.mef.cuconverter.model.CudPrimaPagina;
import it.gov.mef.cuconverter.model.SimpleDelimiterRecord;

public class DepconCUfUtil {
	
	public static final int PRIMA_PAGINA = 1 ;
	public static final int SECONDA_PAGINA = 2 ;
	
	public static final String DELIMITER_PAGINA_PRIMA = "\\$CUD1\\$" ;
	public static final String DELIMITER_PAGINA_SECONDA = "\\$CUD2\\$" ;

	public static String [] getListaCu (String depConFileContent) throws Exception
	{
    	String depConFileContentToTokenize = depConFileContent.replaceFirst(DELIMITER_PAGINA_PRIMA, "");
		return depConFileContentToTokenize.split(DELIMITER_PAGINA_PRIMA);
	}
	
	public static String getPaginaCud(int numeroPagina , String rigaCu ) throws Exception {
		
		if ( numeroPagina < PRIMA_PAGINA || numeroPagina > SECONDA_PAGINA) throw new Exception("numero pagina utilizzabili 1 o 2 ");
		
		String [] pagineCud = rigaCu.split(DELIMITER_PAGINA_SECONDA);
		
		return pagineCud[numeroPagina-1].replaceAll("\\n", ""); 
	}
	
	public static CudPrimaPagina getCudPrimaPagina(String primaPaginaCud) throws Exception {
		
		CudPrimaPagina pagina = new CudPrimaPagina();
		
		FileHelperEngine<CudPrimaPagina> engine = new FileHelperEngine<CudPrimaPagina>(CudPrimaPagina.class);
		
		StringReader stringReader = new StringReader(primaPaginaCud);
		
		List<CudPrimaPagina> lista = engine.readStream(stringReader, -1);
		
		if ( lista!=null )
			pagina = lista.get(0);
		
		return pagina;
			
	}
	
	public static SimpleDelimiterRecord getSimpleDelimiterRecord(String fileFlatContent) throws Exception {
		
		SimpleDelimiterRecord simpleDelimiterRecord = new SimpleDelimiterRecord();
		
		FileHelperEngine<SimpleDelimiterRecord> engine = new FileHelperEngine<>(SimpleDelimiterRecord.class);
		
		StringReader stringReader = new StringReader(fileFlatContent);
		
		List<SimpleDelimiterRecord> lista = engine.readStream(stringReader, -1);
		
		if ( lista!=null )
			simpleDelimiterRecord = lista.get(0);
		
		return simpleDelimiterRecord;

		
	}
	
	
}
