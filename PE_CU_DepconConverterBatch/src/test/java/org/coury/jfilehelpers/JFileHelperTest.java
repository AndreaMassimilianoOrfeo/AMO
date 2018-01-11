package org.coury.jfilehelpers;

import it.gov.mef.cuconverter.config.AppConfig;
import it.gov.mef.cuconverter.util.DepconCUfUtil;
import it.gov.mef.cuconverter.util.FileUtil;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


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

			String fileCU = "BC3_cedol_cf_201703_555_20170331_01.txt";
			String parseCuInputDir = appConfig.getConfPropertiesVale("parseCuInputDir");
			String depConFileContent = FileUtil.readFileByName(parseCuInputDir+fileCU);
			Assert.assertTrue("il file depcon cu comincia per $CUD1$", depConFileContent.startsWith("$CUD1$"));
			
			String [] cuds = DepconCUfUtil.getListaCu(depConFileContent);
			for (String cud : cuds) {
				logger.info("********************************************************************\n"+cud);
				
				String primaPaginaCud = DepconCUfUtil.getPaginaCud(DepconCUfUtil.PRIMA_PAGINA, cud);
				String secondaPaginaCud = DepconCUfUtil.getPaginaCud(DepconCUfUtil.SECONDA_PAGINA, cud);
				Assert.assertTrue("primaPaginaCud inizia con  DG1", primaPaginaCud.startsWith(" DG1"));
				Assert.assertTrue("primaPaginaCud inizia con  DC1", secondaPaginaCud.startsWith(" DC1"));
			}
			
			Assert.assertTrue("il file depcon contiene 3 cu", cuds.length == 3);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
		}
    }
	
	
    
}
