package it.gov.mef.cuconverter.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;

public class FileUtil {

	private static Logger logger = Logger.getLogger(FileUtil.class);
	
    public static String readFileByName ( String depConFileName ) throws Exception
	{
		FileInputStream fis = null;
		File f = null;
		String depConFileContent = "";
		
		try {
		
			f = new File (depConFileName) ;
			fis = new FileInputStream(f);
			int avaiable = fis.available();
			byte [] arr = new byte [avaiable];
			fis.read(arr);
			depConFileContent=new String(arr);
				
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		finally{
			fis.close();
		}
		return depConFileContent;
	}
}
