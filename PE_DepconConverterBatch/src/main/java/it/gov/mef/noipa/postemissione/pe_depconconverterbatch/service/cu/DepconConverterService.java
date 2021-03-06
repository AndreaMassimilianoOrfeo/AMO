package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.service.cu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.AnnotazioniCuWrapper;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudFooter;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudPrimaPagina;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudSecondaPagina;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudSecondaPaginaWrapper;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.DepconCudWrapper;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.multilingua.DepconCudMultiLinguaWrapper;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.serice.cu.validation.DepconCuValidator;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.service.cu.util.DepconCUfUtil;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.service.cu.util.DepconMultiLinguaCUUtil;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.service.cu.util.FileUtil;

@Service
public class DepconConverterService {
	
	private static Logger logger = Logger.getLogger(DepconConverterService.class);
	
	public List <DepconCudWrapper> convertCudDepcon( Resource resource ) throws Exception
	{
		List <DepconCudWrapper> listaCu = new ArrayList<DepconCudWrapper>();
		DepconCudWrapper depconCudWrapper = new DepconCudWrapper();
		try {
		
			String depConFileContent = FileUtil.readFileByName(resource.getFile().getPath());
			
			String [] cuds = DepconCUfUtil.getListaCu(depConFileContent);
			logger.info("convertCudDepcon numero CU presenti :"+cuds.length);
			for (int iCud = 0 , jCud = cuds.length ; iCud <jCud ; iCud++) {
				String cud = cuds[iCud];
				logger.info("******************* CUD NUMERO ["+(iCud+1)+"]****************************************");
				
				String [] pagineCud = DepconCUfUtil.getPagineCud(cud);
				logger.info("******************* PAGINE CU ["+pagineCud.length+"] ****************************************");
				for(int i = 0 , j = pagineCud.length ; i < j ; i ++ ){
					logger.info("******************* PAGINA NUMERO ["+(i+1)+"]****************************************");
					if (i==0) // caso prima pagina
					{
						String primaPaginaCud = pagineCud[0].replaceAll("\\n", "");
						logger.info("primaPaginaCud :\n"+primaPaginaCud);
						CudPrimaPagina cudPrimaPagina = DepconCUfUtil.getCudPrimaPagina(primaPaginaCud);
						
						if (! DepconCuValidator.isValidCuPrimaPagina(cudPrimaPagina) )
							throw new Exception("Errore di validazione sulla prima pagina :" ) ;
						
						depconCudWrapper.setCudPrimaPagina(cudPrimaPagina);
						
					}
					else
					{
						
						if ( depconCudWrapper.getMappaCuSecondaPaginaWrapper()==null )
							depconCudWrapper.setMappaCuSecondaPaginaWrapper(new LinkedHashMap<Integer, CudSecondaPaginaWrapper>());
						
						String secondaPaginaCud = pagineCud[i].replaceAll("\\n", "");
						logger.debug("secondaPaginaCud len: \n"+secondaPaginaCud.length());
						logger.info("secondaPaginaCud :\n"+secondaPaginaCud);
						
						// TOGLIERE DALLA SECONDA PAGINA TUTTE LE RIGHE AN0 (Annotazioni) - non � possibile mapparle in quanto non fillate ( non ci sono mai tutte e 14 le righe )
						AnnotazioniCuWrapper annotazioniCuWrapper = DepconCUfUtil.replaceAnnotazioniFromSecondaPagina(secondaPaginaCud);
						// TOGLIERE DALLA SECONDA PAGINA TUTTE LE RIGHE AN0 (Annotazioni) - non � possibile mapparle in quanto non fillate ( non ci sono mai tutte e 14 le righe )
						
						secondaPaginaCud = annotazioniCuWrapper.getCudSecondaPaginaCleared();
						
						// una sola occorrenza di seconda pagina
						if (secondaPaginaCud.contains("$5X1"))
						{	
							int totalLen = secondaPaginaCud.length();
							String totalRecordToSplit = new String(secondaPaginaCud);
							int indexOf5X1 = totalRecordToSplit.indexOf("$5X1");
							secondaPaginaCud = totalRecordToSplit.substring(0, indexOf5X1);
							String cudFooter = totalRecordToSplit.substring(indexOf5X1, totalLen);
							logger.info("cudFooter :\n"+cudFooter);
							
							CudSecondaPagina cudSecondaPagina = DepconCUfUtil.getCudSecondaPagina(secondaPaginaCud);
							
							//DepconCuValidator.inspectJFileHelperModel(cudSecondaPagina);
							
							if (! DepconCuValidator.isValidCudSecondaPagina(cudSecondaPagina) )
								throw new Exception("Errore di validazione su pagina cud numero : " + i ) ;
							
							depconCudWrapper.getMappaCuSecondaPaginaWrapper().put(new Integer(i), new CudSecondaPaginaWrapper(cudSecondaPagina , annotazioniCuWrapper.getMappaAnnotazioniCud())) ;
							
							CudFooter footer = DepconCUfUtil.getCudFooter(cudFooter);
							
							if (! DepconCuValidator.isValidCudFooter(footer) )
								throw new Exception("Errore di validazione sezione 5*1000 : ") ;
							
							depconCudWrapper.setCudFooter(footer);
						}
						else
							// piu occorrenze di seconda pagina
						{
							CudSecondaPagina cudSecondaPagina = DepconCUfUtil.getCudSecondaPagina(secondaPaginaCud);
							
							//DepconCuValidator.inspectJFileHelperModel(cudSecondaPagina);
							
							if (! DepconCuValidator.isValidCudSecondaPagina(cudSecondaPagina) )
								throw new Exception("Errore di validazione su pagina cud numero : " + i ) ;
							
							depconCudWrapper.getMappaCuSecondaPaginaWrapper().put(new Integer(i), new CudSecondaPaginaWrapper(cudSecondaPagina , annotazioniCuWrapper.getMappaAnnotazioniCud())) ;		
						}
					}
				}
				listaCu.add(depconCudWrapper);
			} // fine ciclo lista cu nel file resource
		} 
		catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			throw e;
		}
		return listaCu;
	}
	
	public List<DepconCudMultiLinguaWrapper> convertCudDepconMultilingua ( Resource resource ) throws Exception{
		List <DepconCudMultiLinguaWrapper> listaCu = new ArrayList<DepconCudMultiLinguaWrapper>();
		try {
			
			//DepconCudMultiLinguaWrapper depconCudMultiLinguaWrapper = new DepconCudMultiLinguaWrapper();
						
			String depConFileContent = FileUtil.readFileByName(resource.getFile().getPath());
			String [] cuds = DepconMultiLinguaCUUtil.getListaCu(depConFileContent);
			
			int numeroCuIta = cuds.length;
			int numeroCuITe = 0;
			
			for (int iCud = 0 , jCud = cuds.length ; iCud <jCud ; iCud++) {
				String cud = cuds[iCud];
				logger.info("******************* CUD NUMERO ["+(iCud+1)+"]****************************************");
				String [] pagineCud = DepconMultiLinguaCUUtil.getPagineCud(cud,DepconMultiLinguaCUUtil.DELIMITER_PAGINA_SECONDA_I_ESCAPE);
				logger.info("******************* PAGINE CU ["+pagineCud.length+"] ****************************************");
				for(int i = 0 , j = pagineCud.length ; i < j ; i ++ ){
					logger.info("******************* PAGINA NUMERO ["+(i+1)+"]****************************************");
					if (i==0) // caso prima pagina
					{
						String primaPaginaCud = pagineCud[0].replaceAll("\\n", "");
						logger.debug("primaPaginaCud len["+primaPaginaCud.length()+"]");
						logger.info("primaPaginaCud :\n"+primaPaginaCud);
					}
					else
					{
						String secondaPaginaCud = pagineCud[i].replaceAll("\\n", "");
						logger.debug("secondaPaginaCud len["+secondaPaginaCud.length()+"]");
						logger.info("secondaPaginaCud :\n"+secondaPaginaCud);
						
						// se nella seconda pagina si presenetano istanze di $CUT1$ vuol dire che esiste una cu in lingua tedesca
						if (secondaPaginaCud.contains(DepconMultiLinguaCUUtil.DELIMITER_PAGINA_PRIMA_T))
						{
							numeroCuITe++;
							logger.debug("trovata cu tedesca");
							int startIndexCuTedesca = secondaPaginaCud.indexOf(DepconMultiLinguaCUUtil.DELIMITER_PAGINA_PRIMA_T);
							logger.debug("startIndexCuTedesca :\n"+startIndexCuTedesca);
							String cuTedesca = secondaPaginaCud.substring(startIndexCuTedesca, secondaPaginaCud.length());
							cuTedesca = cuTedesca.replaceFirst(DepconMultiLinguaCUUtil.DELIMITER_PAGINA_PRIMA_T_ESCAPE, "");
							logger.debug("cuTedesca :\n"+cuTedesca);
							String [] pagineCuTedesco =  cuTedesca.split(DepconMultiLinguaCUUtil.DELIMITER_PAGINA_SECONDA_T_ESCAPE);
							String primaPaginaCuTedesco = pagineCuTedesco[1];
							String secondaPaginaCuTedesco = pagineCuTedesco[0];
							logger.info("primaPaginaCuTedesco :\n"+primaPaginaCuTedesco);
							logger.debug("primaPaginaCuTedesco len["+primaPaginaCuTedesco.length()+"]");
							logger.info("secondaPaginaCuTedesco :\n"+secondaPaginaCuTedesco);
							logger.debug("secondaPaginaCuTedesco len["+secondaPaginaCuTedesco.length()+"]");
						}
						
						// una sola occorrenza di seconda pagina
						if (secondaPaginaCud.contains("$5X1"))
						{	
							int totalLen = secondaPaginaCud.length();
							String totalRecordToSplit = new String(secondaPaginaCud);
							int indexOf5X1 = totalRecordToSplit.indexOf("$5X1");
							secondaPaginaCud = totalRecordToSplit.substring(0, indexOf5X1);
							String cudFooter = totalRecordToSplit.substring(indexOf5X1, totalLen);
							logger.info("cudFooter :\n"+cudFooter);
							logger.debug("cudFooter len["+cudFooter.length()+"]");
						}
					}
				}
			}
			logger.info("convertCudDepcon numeroCuIta presenti :"+numeroCuIta);
			logger.info("convertCudDepcon numeroCuITe presenti :"+numeroCuITe);
		}
		catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			throw e;
		}
		return listaCu;
	}
	
}