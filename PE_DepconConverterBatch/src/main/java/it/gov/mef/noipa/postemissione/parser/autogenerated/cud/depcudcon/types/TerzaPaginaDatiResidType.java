package it.gov.mef.noipa.postemissione.parser.autogenerated.cud.depcudcon.types;

/*
	<xs:element name="recordId" type="xs:string" fixed="\$5X1" jrb:length="4"/>
	<xs:element name="codiceFiscaleEnte" type="xs:string" jrb:row="1"/>
	<xs:element name="codiceFiscale" type="xs:string" jrb:row="2"  />
	<xs:element name="cognome" type="xs:string" jrb:length="36" jrb:row="3"/>
	<xs:element name="nome" type="xs:string" jrb:length="37" jrb:row="3"  />
	<xs:element name="sesso" type="xs:string" jrb:row="3"/>
	<xs:element name="data" type="xs:string" jrb:length="11" jrb:row="4"  />
	<xs:element name="comuneResidenza" type="xs:string" jrb:length="32" jrb:row="4"  />
	<xs:element name="provinciaResidenza" type="xs:string" jrb:row="4" /> 
*/

public class TerzaPaginaDatiResidType {
	protected String recordValue;

	public TerzaPaginaDatiResidType(String recordValue) {
		super();
		this.recordValue = recordValue;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public void setRecordValue(String value) {
		this.recordValue = value;
	}


	public String getData() {
		int startingPosition = 0;
		int length = 11;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getComuneResidenza() {
		int startingPosition = 11;
		int length = 32;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getProvinciaResidenza() {
		int startingPosition = 43;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, recordValue.length());
		} else {
			return null;
		}
	}


}
