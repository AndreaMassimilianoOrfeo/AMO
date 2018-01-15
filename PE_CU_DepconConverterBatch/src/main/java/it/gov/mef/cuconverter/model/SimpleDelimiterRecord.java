package it.gov.mef.cuconverter.model;

import java.util.Date;

import org.coury.jfilehelpers.annotations.DelimitedRecord;
import org.coury.jfilehelpers.annotations.FieldConverter;
import org.coury.jfilehelpers.enums.ConverterKind;

@DelimitedRecord("*")
public class SimpleDelimiterRecord {
	
	@FieldConverter(converter=ConverterKind.Currency,format="###,###.##")
	public Double importo ;
	
	@FieldConverter(converter=ConverterKind.Date,format="yyyy-MM-dd")
	public Date data; 
}
