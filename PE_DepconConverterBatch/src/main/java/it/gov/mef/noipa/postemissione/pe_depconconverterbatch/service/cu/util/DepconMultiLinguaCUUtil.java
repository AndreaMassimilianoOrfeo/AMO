package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.service.cu.util;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.AnnotazioniCuWrapper;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudAnnotazione;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudFooter;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudPrimaPagina;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudSecondaPagina;
/**
 * Classe di utilità per il parsing applicativo dei file flat CU multilingua
 * @author a.orfeo
 *
 */
public class DepconMultiLinguaCUUtil {

	public static final int PRIMA_PAGINA = 1 ;
	public static final int SECONDA_PAGINA = 2 ;
	
	public static final String DELIMITER_PAGINA_PRIMA_I_ESCAPE = "\\$CUD1\\$" ;
	public static final String DELIMITER_PAGINA_SECONDA_I_ESCAPE = "\\$CUD2\\$" ;
	public static final String DELIMITER_PAGINA_PRIMA_T_ESCAPE = "\\$CUT1\\$" ;
	public static final String DELIMITER_PAGINA_SECONDA_T_ESCAPE = "\\$CUT2\\$" ;
	
	public static final String ITALIANO = "i" ;
	public static final String TEDESCO = "t" ;

	public static final String DELIMITER_PAGINA_PRIMA_I = "$CUD1$" ;
	public static final String DELIMITER_PAGINA_SECONDA_I = "$CUD2$" ;
	public static final String DELIMITER_PAGINA_PRIMA_T = "$CUT1$" ;
	public static final String DELIMITER_PAGINA_SECONDA_T = "$CUT2$" ;
	
	
	/**
	 * 
	 * @param depConFileContent
	 * @return array di stringhe , ogni item rappresenta una CU con prima e seconda pagina
	 * @throws Exception
	 */
	public static String [] getListaCu (String depConFileContent) throws Exception
	{
    	String depConFileContentToTokenize = depConFileContent.replaceFirst(DELIMITER_PAGINA_PRIMA_I_ESCAPE, "");
		return depConFileContentToTokenize.split(DELIMITER_PAGINA_PRIMA_I_ESCAPE);
	}
	
	/**
	 * Restituisce le pagine splittando per il separatore di pagine in input 
	 * @throws Exception
	 */
	public static String [] getPagineCud(String rigaCu,String regex) throws Exception {
		return rigaCu.split(regex);
	}

	/**
	 * 	// ricerca di tutte le occorrenze di ANO in seconda pagina
	 *	// la prima occorrebza di annotazione deve essere considerata dal primo byte utile dopo la fine record DP6
	 *  // fix a.orfeo 12022108 : in caso di assenza di Annotazioni il record AN0 non è valorizzato. 
	 *	// fino a quando l'indexOf("AN0") non resituisce -1 
	 * @param secondaPaginaCud
	 * @return
	 * @throws Exception
	 */
	public static AnnotazioniCuWrapper replaceAnnotazioniFromSecondaPagina(String secondaPaginaCud) throws Exception {
		return DepconCUfUtil.replaceAnnotazioniFromSecondaPagina(secondaPaginaCud);
	}
	
	/**
	 * Esegue il marshalling del file flat cu , sezione prima pagina , nel model corrispondente CudPrimaPagina
	 * @param primaPaginaCud
	 * @return
	 * @throws Exception
	 */
	public static CudPrimaPagina getCudPrimaPagina(String primaPaginaCud) throws Exception {
		return DepconCUfUtil.getCudPrimaPagina(primaPaginaCud);
	}
	
	/**
	 * Esegue il marshalling del file flat cu , sezione seconda pagina , nel model corrispondente CudSecondaPagina
	 * @param primaPaginaCud
	 * @return
	 * @throws Exception
	 */
	public static CudSecondaPagina getCudSecondaPagina (String secondaPaginaCud) throws Exception {
		return DepconCUfUtil.getCudSecondaPagina(secondaPaginaCud);
	}
	

	/**
	 * Esegue il marshalling del file flat cu , sezione seconda pagina , nel model corrispondente CudSecondaPagina
	 * @param primaPaginaCud
	 * @return
	 * @throws Exception
	 */
	public static CudAnnotazione getCudAnnotazione (String annotazione) throws Exception {
		return DepconCUfUtil.getCudAnnotazione(annotazione);
	}
	
	/**
	 * Esegue il marshalling del file flat cu , sezione 5X100, nel model corrispondente CudFooter
	 * @param primaPaginaCud
	 * @return
	 * @throws Exception
	 */
	public static CudFooter getCudFooter (String cudFooter) throws Exception {
		return DepconCUfUtil.getCudFooter(cudFooter);
	}

}
