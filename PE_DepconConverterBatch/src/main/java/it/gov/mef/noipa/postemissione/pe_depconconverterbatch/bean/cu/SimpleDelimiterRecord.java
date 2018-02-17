package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu;

import java.util.Date;

import org.coury.jfilehelpers.annotations.DelimitedRecord;
import org.coury.jfilehelpers.annotations.FieldConverter;
import org.coury.jfilehelpers.enums.ConverterKind;

@DelimitedRecord("*")
public class SimpleDelimiterRecord {
	
	@FieldConverter(converter=ConverterKind.Currency,format="###,###.##")
	public String importo ;
	
	@FieldConverter(converter=ConverterKind.Date,format="yyyy-MM-dd")
	public Date data; 
}
