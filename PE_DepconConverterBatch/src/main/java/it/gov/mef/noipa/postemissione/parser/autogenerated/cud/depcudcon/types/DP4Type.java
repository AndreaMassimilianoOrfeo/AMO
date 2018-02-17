package it.gov.mef.noipa.postemissione.parser.autogenerated.cud.depcudcon.types;


//<xs:element name="codiceFiscaleAmministrazione" type="xs:string" jrb:length="11" nillable="true"/>
//<xs:element name="codiceIdentSPT" type="xs:string" jrb:length="7" nillable="true"/>
//<xs:element name="pens" type="xs:string" jrb:length="1" nillable="true"/>
//<xs:element name="prev" type="xs:string" jrb:length="4" nillable="true"/>
//<xs:element name="cred" type="xs:string" jrb:length="1" nillable="true"/>
//<xs:element name="enpdep" type="xs:string" jrb:length="1" nillable="true"/>
//<xs:element name="annoRiferimento" type="xs:string" jrb:length="4" nillable="true"/>
//<xs:element name="totImpPensionistico" type="xs:string" jrb:length="13" nillable="true"/>
//<xs:element name="totContribPensionistici" type="xs:string" jrb:length="13" nillable="true"/>
//<xs:element name="totImpTFS" type="xs:string" jrb:length="13" nillable="true"/>

public class DP4Type {
	protected String recordValue;

	public DP4Type(String recordValue) {
		super();
		this.recordValue = recordValue;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public void setRecordValue(String value) {
		this.recordValue = value;
	}


	public String getCodiceFiscaleAmministrazione() {
		int startingPosition = 0;
		int length = 11;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getCodiceIdentSPT() {
		int startingPosition = 11;
		int length = 7;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getPens() {
		int startingPosition = 18;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getPrev() {
		int startingPosition = 19;
		int length = 4;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getCred() {
		int startingPosition = 23;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}


	public String getEnpdep() {
		int startingPosition = 24;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	
	public String getAnnoRiferimento() {
		int startingPosition = 25;
		int length = 4;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}
	
	public String getTotImpPensionistico() {
		int startingPosition = 29;
		int length = 13;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getTotContribPensionistici() {
		int startingPosition = 42;
		int length = 13;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getTotImpTFS() {
		int startingPosition = 55;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition);
		} else {
			return null;
		}
	}


}