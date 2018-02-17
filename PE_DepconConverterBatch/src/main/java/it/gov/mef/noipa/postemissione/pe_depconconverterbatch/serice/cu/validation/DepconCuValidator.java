package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.serice.cu.validation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.coury.jfilehelpers.annotations.FieldFixedLength;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudFooter;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudPrimaPagina;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudSecondaPagina;

/**
 * Classe responsabile della validazione dei campi del depcon cu
 * @author a.orfeo
 *
 */
public class DepconCuValidator {

	private static Logger logger = Logger.getLogger(DepconCuValidator.class);
	
	/**
	 * ViA reflection cerco il valore specificato per l'annotation @FieldFixedLength
	 * di ogni campo del model
	 * a quel punto la len del value dell'iesimo field deve corrispiondere al valore della @FieldFixedLength 
	 */
	
	public static boolean isValidCuPrimaPagina( CudPrimaPagina cudPrimaPagina ) throws Exception{
		boolean result = true;
		try {
			
			int fixLenValue = 0;
			for(Field field : CudPrimaPagina.class.getFields()){
				
			
				// len del value dell'iesimo field
				String fieldName = field.getName();
				
				if (fieldName.contains("spazio") || fieldName.startsWith("spazio"))
					continue;
			
				// LEN @FieldFixedLength
				fixLenValue = field.getAnnotation(FieldFixedLength.class).value();
				
				String getterMetodPrefix="get";
				String method = getterMetodPrefix+WordUtils.capitalize(fieldName);
				
				Method getterMethod = cudPrimaPagina.getClass().getDeclaredMethod(method, null);
				String value = (String) getterMethod.invoke(cudPrimaPagina,null);
				logger.debug("isValidCuPrimaPagina fieldName["+fieldName+"] fixLenValue["+fixLenValue+"] method["+method+"] value["+value+"]");
				
				if ( fixLenValue != value.length() )
					return false;
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return result;
	}

	/**
	 * ViA reflection cerco il valore specificato per l'annotation @FieldFixedLength
	 * di ogni campo del model
	 * a quel punto la len del value dell'iesimo field deve corrispiondere al valore della @FieldFixedLength 
	 */
	
	public static boolean isValidCudSecondaPagina( CudSecondaPagina cudSecondaPagina ) throws Exception{
		boolean result = true;
		try {
			
			int fixLenValue = 0;
			for(Field field : CudSecondaPagina.class.getFields()){
				
			
				// len del value dell'iesimo field
				String fieldName = field.getName();
				
				if (fieldName.contains("spazio") || fieldName.startsWith("spazio"))
					continue;
			
				// LEN @FieldFixedLength
				fixLenValue = field.getAnnotation(FieldFixedLength.class).value();
				
				String getterMetodPrefix="get";
				String method = getterMetodPrefix+WordUtils.capitalize(fieldName);
				
				Method getterMethod = cudSecondaPagina.getClass().getDeclaredMethod(method, null);
				String value = (String) getterMethod.invoke(cudSecondaPagina,null);
				logger.debug("isValidCudSecondaPagina fieldName["+fieldName+"] fixLenValue["+fixLenValue+"] method["+method+"] value["+value+"]");
				
				if ( fixLenValue != value.length() )
					return false;
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return result;
	}
	
	
	
	/**
	 * ViA reflection cerco il valore specificato per l'annotation @FieldFixedLength
	 * di ogni campo del model
	 * a quel punto la len del value dell'iesimo field deve corrispiondere al valore della @FieldFixedLength 
	 */
	
	public static boolean isValidCudFooter( CudFooter cudFooter ) throws Exception{
		boolean result = true;
		try {
			
			int fixLenValue = 0;
			for(Field field : CudFooter.class.getFields()){
				
			
				// len del value dell'iesimo field
				String fieldName = field.getName();
				
				if (fieldName.contains("spazio") || fieldName.startsWith("spazio"))
					continue;
			
				// LEN @FieldFixedLength
				fixLenValue = field.getAnnotation(FieldFixedLength.class).value();
				
				String getterMetodPrefix="get";
				String method = getterMetodPrefix+WordUtils.capitalize(fieldName);
				
				Method getterMethod = cudFooter.getClass().getDeclaredMethod(method, null);
				String value = (String) getterMethod.invoke(cudFooter,null);
				logger.debug("isValidCudFooter fieldName["+fieldName+"] fixLenValue["+fixLenValue+"] method["+method+"] value["+value+"]");
				
				if ( fixLenValue != value.length() )
					return false;
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return result;
	}

	public static void inspectJFileHelperModel( Object object ) throws Exception{
		try {
			
			int fixLenValue = 0;
			for(Field field : object.getClass().getFields()){
				
			
				// len del value dell'iesimo field
				String fieldName = field.getName();
				
				// LEN @FieldFixedLength
				fixLenValue = field.getAnnotation(FieldFixedLength.class).value();
				
				String getterMetodPrefix="get";
				String method = getterMetodPrefix+WordUtils.capitalize(fieldName);
				
				Method getterMethod = object.getClass().getDeclaredMethod(method, null);
				String value = (String) getterMethod.invoke(object,null);
				logger.debug("inspectJFileHelperModel fieldName["+fieldName+"] fixLenValue["+fixLenValue+"] value["+value+"] len["+value.length()+"]");
				
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		
	}

}
