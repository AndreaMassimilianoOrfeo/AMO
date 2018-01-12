package org.coury.jfilehelpers;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.gov.mef.cuconverter.config.AppConfig;
import it.gov.mef.cuconverter.model.CudPrimaPagina;
import it.gov.mef.cuconverter.model.SimpleDelimiterRecord;
import it.gov.mef.cuconverter.util.DepconCUfUtil;
import it.gov.mef.cuconverter.util.FileUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class JFileHelperTest {
	
	private static Logger logger = Logger.getLogger(JFileHelperTest.class);
	
	//DI
    @Autowired
    AppConfig appConfig;
	
	@Test
    public void parseCuTest()
    {
		try {

			String fileCU = "BC3_cedol_cf_first_test.txt";
			String parseCuInputDir = appConfig.getConfPropertiesVale("parseCuInputDir");
			String depConFileContent = FileUtil.readFileByName(parseCuInputDir+fileCU);
			Assert.assertTrue("il file depcon cu comincia per $CUD1$", depConFileContent.startsWith("$CUD1$"));
			
			String [] cuds = DepconCUfUtil.getListaCu(depConFileContent);
			for (String cud : cuds) {
				logger.info("******************* CUD ****************************************");
				logger.info("******************* PAGINA 1****************************************");
				String primaPaginaCud = DepconCUfUtil.getPaginaCud(DepconCUfUtil.PRIMA_PAGINA, cud);
				logger.info("\n"+primaPaginaCud);
				logger.info("******************* PAGINA 2****************************************");
				String secondaPaginaCud = DepconCUfUtil.getPaginaCud(DepconCUfUtil.SECONDA_PAGINA, cud);
				logger.info("\n"+secondaPaginaCud);
				Assert.assertTrue("primaPaginaCud inizia con  DG1", primaPaginaCud.startsWith(" DG1"));
				Assert.assertTrue("secondaPaginaCud inizia con  DC1", secondaPaginaCud.startsWith(" DC1"));
		
				CudPrimaPagina cudPrimaPagina = DepconCUfUtil.getCudPrimaPagina(primaPaginaCud);
				Assert.assertTrue("cudPrimaPagina valorizzato", cudPrimaPagina!=null);
				Assert.assertTrue("cudPrimaPagina dg1 test", "DG1".equals(cudPrimaPagina.dg1));
				Assert.assertTrue("cudPrimaPagina codiceDpt test", cudPrimaPagina.codiceDpt.length() == 3);
				Assert.assertTrue("cudPrimaPagina codiceDpt iscrizione", cudPrimaPagina.iscrizione.length() == 8);
			
			}
			
			Assert.assertTrue("il file depcon contiene 1 cu", cuds.length == 1);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			Assert.fail();
		}
    }
	
	@Test
	public void parseValidSimpleRecord()
	{
		try {
		
			String fileFlat = "valid_flat.txt";
			String dataValidationInputDir = appConfig.getConfPropertiesVale("dataValidationInputDir");
			String fileFlatContent = FileUtil.readFileByName(dataValidationInputDir+fileFlat);	
			SimpleDelimiterRecord record = DepconCUfUtil.getSimpleDelimiterRecord(fileFlatContent);
			Assert.assertTrue("record valorizzato", record!=null);
			Assert.assertTrue("importo valorizzato", record.importo!=null);
			Assert.assertTrue("data valorizzato", record.data!=null);
			
			logger.info("parseValidSimpleRecord importo:"+record.importo);
			logger.info("parseValidSimpleRecord data:"+record.data);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			Assert.fail();
		}
		
	}
	
	@Test
	public void currencyConverterTest() throws ParseException
	{
		String currency = "38.221,53";
		
		DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.ITALIAN);
		unusualSymbols.setDecimalSeparator(',');
		unusualSymbols.setGroupingSeparator('.');
		
		String cuPatterCurrency = "###,###.###";
		DecimalFormat formatter = new DecimalFormat(cuPatterCurrency, unusualSymbols);
		formatter.setGroupingSize(4);

		Number output = formatter.parse(currency);
			
		logger.info("currencyConverterTest output"+output);  
	}
	
    
}
