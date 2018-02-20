package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.service.cu.util;

import java.io.StringReader;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.coury.jfilehelpers.engines.FileHelperEngine;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.AnnotazioniCuWrapper;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudAnnotatzionePosition;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudAnnotazione;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudFooter;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudPrimaPagina;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudSecondaPagina;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.SimpleDelimiterRecord;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.exception.cu.AnnotazioneNotPresentException;
/**
 * Classe di utilità per il parsing applicativo dei file flat CU
 * @author a.orfeo
 *
 */
public class DepconCUfUtil {
	
	private static Logger logger = Logger.getLogger(DepconCUfUtil.class);
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
		
		AnnotazioniCuWrapper annotazioniCuWrapper = new AnnotazioniCuWrapper();
		try {
			
			int annotationePositionStart = 0;
			int annotationePositionEnd = 0;
			int fromIndex = 0;
			String tmpStrSecondaPaginaCud = "";
			int startAnnotazioniPosition = 791;
		
			annotationePositionStart = startAnnotazioniPosition;
			annotationePositionEnd = annotationePositionStart + 114;
			
			String annotazione="";
			CudAnnotazione cudAnnotazione=null;
			/**
			 * Tentativo di lettura della prima annotazione 
			 * fix a.orfeo 12022108 : in caso di assenza di Annotazioni il record AN0 nel file txt depcon non � valorizzato.
			 */
			try {
				logger.debug("replaceAnnotazioniFromSecondaPagina first annotationPositionStart["+annotationePositionStart+"] annotationePositionEnd["+annotationePositionEnd+"]");
				annotazione = secondaPaginaCud.substring(annotationePositionStart,annotationePositionEnd);
				logger.debug("replaceAnnotazioniFromSecondaPagina first annotazione["+annotazione+"] ");
				fromIndex = annotationePositionStart + 114;
				
				if (!annotazione.startsWith(" AN0"))
				{
					logger.warn("replaceAnnotazioniFromSecondaPagina WARNING Annotazione non presente nel depcon in parsing...");
					annotazioniCuWrapper.setCudSecondaPaginaCleared(secondaPaginaCud);
					return annotazioniCuWrapper;
				}
				
				cudAnnotazione = getCudAnnotazione(annotazione);
				annotazioniCuWrapper.getMappaPosizioniAnnotazioniCud().put(new Integer(1), new CudAnnotatzionePosition(new Integer(annotationePositionStart), new Integer(annotationePositionEnd), annotazione));
				annotazioniCuWrapper.getMappaAnnotazioniCud().put(new Integer(annotationePositionStart), cudAnnotazione);
			
			} catch (Exception e) {
				logger.warn("replaceAnnotazioniFromSecondaPagina WARNING " + e.getMessage());
				throw new AnnotazioneNotPresentException(e.getMessage(),e);
			}
			
			int numeroOccorrenzaAn0 = 2 ;
			
			//la prima occorrenza di una annotazione comincia al byte 791 della seconda pagina
			while (annotationePositionStart != -1 ) {
				
				annotationePositionStart = secondaPaginaCud.indexOf(" AN0",fromIndex);
				
				if ( annotationePositionStart == -1)
					break;
				
				annotationePositionEnd = annotationePositionStart + 114;
				
				logger.debug("replaceAnnotazioniFromSecondaPagina annotationPositionStart["+annotationePositionStart+"] annotationePositionEnd["+annotationePositionEnd+"]");
				
				annotazione = secondaPaginaCud.substring(annotationePositionStart,annotationePositionEnd);
				logger.debug("replaceAnnotazioniFromSecondaPagina annotazione["+annotazione+"] ");
				
				cudAnnotazione = getCudAnnotazione(annotazione);
				annotazioniCuWrapper.getMappaPosizioniAnnotazioniCud().put(new Integer(numeroOccorrenzaAn0), new CudAnnotatzionePosition(new Integer(annotationePositionStart), new Integer(annotationePositionEnd), annotazione));
				annotazioniCuWrapper.getMappaAnnotazioniCud().put(new Integer(annotationePositionStart), cudAnnotazione);
				
				fromIndex = annotationePositionStart + 114;
				numeroOccorrenzaAn0++;
			}
			
			// finito il ciclo , conosco le posizioni delle n possibi occorrenze
			// a questo punto  è possibile , iterativamente , cancellare le n occorrenze di annotazione dalla secondaPaginaCud
			Set<Integer> keySetPosition = annotazioniCuWrapper.getMappaPosizioniAnnotazioniCud().keySet();
			tmpStrSecondaPaginaCud = secondaPaginaCud;
			for (Integer keyPosition : keySetPosition) {
				CudAnnotatzionePosition annotatzionePosition = annotazioniCuWrapper.getMappaPosizioniAnnotazioniCud().get(keyPosition);
				tmpStrSecondaPaginaCud = tmpStrSecondaPaginaCud.replace(annotatzionePosition.getAnnotazione(), "");
				logger.debug("replaceAnnotazioniFromSecondaPagina tmpStrSecondaPaginaCud["+tmpStrSecondaPaginaCud+"] ");
			}
			
			logger.debug("replaceAnnotazioniFromSecondaPagina endReplace tmpStrSecondaPaginaCud["+tmpStrSecondaPaginaCud+"] ");
			annotazioniCuWrapper.setCudSecondaPaginaCleared(tmpStrSecondaPaginaCud);
		}
		catch(AnnotazioneNotPresentException e)
		{
			logger.warn("replaceAnnotazioniFromSecondaPagina WARNING Annotazione non presente nel depcon in parsing...");
			annotazioniCuWrapper.setCudSecondaPaginaCleared(secondaPaginaCud);
			return annotazioniCuWrapper;
		}
		catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			throw e;
		}
		return annotazioniCuWrapper;
	}
	
	/**
	 * Esegue il marshalling del file flat cu , sezione prima pagina , nel model corrispondente CudPrimaPagina
	 * @param primaPaginaCud
	 * @return
	 * @throws Exception
	 */
	public static CudPrimaPagina getCudPrimaPagina(String primaPaginaCud) throws Exception {
		
		CudPrimaPagina pagina = new CudPrimaPagina();
		
		FileHelperEngine<CudPrimaPagina> engine = new FileHelperEngine<CudPrimaPagina>(CudPrimaPagina.class);
		
		StringReader stringReader = new StringReader(primaPaginaCud);
		
		List<CudPrimaPagina> lista = engine.readStream(stringReader, -1);
		
		if ( lista!=null )
			pagina = lista.get(0);
		
		return pagina;
	}
	
	/**
	 * Esegue il marshalling del file flat cu , sezione seconda pagina , nel model corrispondente CudSecondaPagina
	 * @param primaPaginaCud
	 * @return
	 * @throws Exception
	 */
	public static CudSecondaPagina getCudSecondaPagina (String secondaPaginaCud) throws Exception {
		
		CudSecondaPagina pagina = new CudSecondaPagina();
		
		FileHelperEngine<CudSecondaPagina> engine = new FileHelperEngine<CudSecondaPagina>(CudSecondaPagina.class);
		
		StringReader stringReader = new StringReader(secondaPaginaCud);
		
		List<CudSecondaPagina> lista = engine.readStream(stringReader, -1);
		
		if ( lista!=null )
			pagina = lista.get(0);
		
		return pagina;
	}
	

	/**
	 * Esegue il marshalling del file flat cu , sezione seconda pagina , nel model corrispondente CudSecondaPagina
	 * @param primaPaginaCud
	 * @return
	 * @throws Exception
	 */
	public static CudAnnotazione getCudAnnotazione (String annotazione) throws Exception {
		
		CudAnnotazione cudAnnotazione = new CudAnnotazione();
		
		FileHelperEngine<CudAnnotazione> engine = new FileHelperEngine<CudAnnotazione>(CudAnnotazione.class);
		
		StringReader stringReader = new StringReader(annotazione);
		
		List<CudAnnotazione> lista = engine.readStream(stringReader, -1);
		
		if ( lista!=null )
			cudAnnotazione = lista.get(0);
		
		return cudAnnotazione;
	}
	
	/**
	 * Esegue il marshalling del file flat cu , sezione 5X100, nel model corrispondente CudFooter
	 * @param primaPaginaCud
	 * @return
	 * @throws Exception
	 */
	public static CudFooter getCudFooter (String cudFooter) throws Exception {
		
		CudFooter cuFooter = new CudFooter();
		
		FileHelperEngine<CudFooter> engine = new FileHelperEngine<CudFooter>(CudFooter.class);
		
		StringReader stringReader = new StringReader(cudFooter);
		
		List<CudFooter> lista = engine.readStream(stringReader, -1);
		
		if ( lista!=null )
			cuFooter = lista.get(0);
		
		return cuFooter;
	}
	
	
	/**
	 * metodo di dimostrazione di validazione/conversione di importi e date , usato solo dal relativo Junit Test Case
	 * @param fileFlatContent
	 * @return
	 * @throws Exception
	 */
	public static SimpleDelimiterRecord getSimpleDelimiterRecord(String fileFlatContent) throws Exception {
		
		SimpleDelimiterRecord simpleDelimiterRecord = new SimpleDelimiterRecord();
		
		FileHelperEngine<SimpleDelimiterRecord> engine = new FileHelperEngine<>(SimpleDelimiterRecord.class);
		
		StringReader stringReader = new StringReader(fileFlatContent);
		
		List<SimpleDelimiterRecord> lista = engine.readStream(stringReader, -1);
		
		if ( lista!=null )
			simpleDelimiterRecord = lista.get(0);
		
		return simpleDelimiterRecord;
	}
	
	public static String getLinguaBySeparator(String separatorInput) throws Exception {
		
		if ( ! DELIMITER_PAGINA_PRIMA_I.equals(separatorInput) && ! DELIMITER_PAGINA_PRIMA_T.equals(separatorInput) )
			throw new Exception("Tracciato CU invalido , separatori non trovati.");
		
		if (DELIMITER_PAGINA_PRIMA_I.equals(separatorInput))
			return ITALIANO ;
		else
			return TEDESCO ;
	}
	
}
