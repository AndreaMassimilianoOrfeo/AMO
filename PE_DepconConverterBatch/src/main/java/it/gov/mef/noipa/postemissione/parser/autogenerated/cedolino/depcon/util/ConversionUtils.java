package it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino.depcon.util;


public class ConversionUtils {

	public static String convertRata(String letteraMese, String letteraAnno) throws Exception{
		String mese ="";
		switch (letteraMese.charAt(0)){
			case 'A' : mese="01";break;
			case 'B' : mese="02";break;
			case 'C' : mese="03";break;
			case 'D' : mese="04";break;
			case 'E' : mese="05";break;
			case 'F' : mese="06";break;
			case 'G' : mese="07";break;
			case 'H' : mese="08";break;
			case 'I' : mese="09";break;
			case 'L' : mese="10";break;
			case 'M' : mese="11";break;
			case 'N' : mese="12";break;
			default  : throw new Exception("Date Conversion Error");
		}
		return "201"+letteraAnno+mese;
	}
}
