package it.gov.mef.cuconverter.util;


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
}
