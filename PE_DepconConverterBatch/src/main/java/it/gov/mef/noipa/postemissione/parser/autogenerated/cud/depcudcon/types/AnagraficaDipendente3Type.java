package it.gov.mef.noipa.postemissione.parser.autogenerated.cud.depcudcon.types;


//<xs:element name="recordDG6" type="xs:string" fixed=" DG6" jrb:length="4" jrb:row="2"/>
//<xs:element name="domicilioFiscale11AAComune" type="xs:string" jrb:length="40" jrb:row="2"/>
//<xs:element name="domicilioFiscale11AASiglaProvincia" type="xs:string" jrb:length="2" jrb:row="2"/>
//<xs:element name="domicilioFiscale11AACodiceComune" type="xs:string" jrb:length="4" jrb:row="2"/>
//<xs:element name="domicilioFiscale11AAComune1" type="xs:string" jrb:length="40" jrb:row="2" nillable="true"/>
//<xs:element name="domicilioFiscale11AASiglaProvincia1" type="xs:string" jrb:length="2" jrb:row="2" nillable="true"/>
//<xs:element name="domicilioFiscale11AACodiceComune1" type="xs:string" jrb:row="2" jrb:length="4" nillable="true"/>

public class AnagraficaDipendente3Type {
	protected String recordValue;

	public AnagraficaDipendente3Type(String recordValue) {
		super();
		this.recordValue = recordValue;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public void setRecordValue(String value) {
		this.recordValue = value;
	}

	public String getDomicilioFiscale11AAComune() {
		int startingPosition = 0;
		int length = 40;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getDomicilioFiscale11AASiglaProvincia() {
		int startingPosition = 40;
		int length = 2;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}
	
	public String getDomicilioFiscale11AACodiceComune() {
		int startingPosition = 42;
		int length = 4;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}


	public String getDomicilioFiscale11AAComune1() {
		int startingPosition = 46;
		int length = 40;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getDomicilioFiscale11AASiglaProvincia1() {
		int startingPosition = 86;
		int length = 2;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}
	
	public String getDomicilioFiscale11AACodiceComune1() {
		int startingPosition = 88;
		int length = 4;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}



}