package it.gov.mef.cuconverter.model;

import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;

@FixedLengthRecord()
public class CudSecondaPagina {

	//DC1
	@FieldFixedLength(1)
	public String spazio1;
	
	@FieldFixedLength(1)
	public String flagConiuge;

	@FieldFixedLength(2)
	public String spazio2;

	@FieldFixedLength(16)
	public String cfConiuge;
	
	@FieldFixedLength(2)
	public String messiACaricoConiuge;

}
