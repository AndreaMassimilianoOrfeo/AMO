package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.batch.cu;

import org.apache.log4j.Logger;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.service.cu.DepconConverterService;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.service.cu.util.DepconCUfUtil;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.service.cu.util.FileUtil;

public class Main {
	
	private static Logger logger = Logger.getLogger(DepconConverterService.class);
	public static void main(String[] args) throws Exception{
		
		try {
		
			String file = "C:\\NoiPA\\POSTEMISSIONE\\postemissione_file\\BC3_cedol_cf_201702_088_20170222_01_bilingue.txt";
			//String file = "C:\\NoiPA\\POSTEMISSIONE\\postemissione_file\\depcon\\elaborati\\BC3_cedol_cf_201802_001_20180219_03.txt";
			//String file = "C:\\NoiPA\\POSTEMISSIONE\\postemissione_file\\cudbuono.txt";
			String depConFileContent = FileUtil.readFileByName(file);
			String [] cuds = DepconCUfUtil.getListaCu(depConFileContent);
			
			int numeroCuIta = cuds.length;
			int numeroCuITe = 0;
			
			for (int iCud = 0 , jCud = cuds.length ; iCud <jCud ; iCud++) {
				String cud = cuds[iCud];
				logger.info("******************* CUD NUMERO ["+(iCud+1)+"]****************************************");
				String [] pagineCud = DepconCUfUtil.getPagineCud(cud,DepconCUfUtil.DELIMITER_PAGINA_SECONDA_I_ESCAPE);
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
						if (secondaPaginaCud.contains(DepconCUfUtil.DELIMITER_PAGINA_PRIMA_T))
						{
							numeroCuITe++;
							logger.debug("trovata cu tedesca");
							int startIndexCuTedesca = secondaPaginaCud.indexOf(DepconCUfUtil.DELIMITER_PAGINA_PRIMA_T);
							logger.debug("startIndexCuTedesca :\n"+startIndexCuTedesca);
							String cuTedesca = secondaPaginaCud.substring(startIndexCuTedesca, secondaPaginaCud.length());
							cuTedesca = cuTedesca.replaceFirst(DepconCUfUtil.DELIMITER_PAGINA_PRIMA_T_ESCAPE, "");
							logger.debug("cuTedesca :\n"+cuTedesca);
							String [] pagineCuTedesco =  cuTedesca.split(DepconCUfUtil.DELIMITER_PAGINA_SECONDA_T_ESCAPE);
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
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
