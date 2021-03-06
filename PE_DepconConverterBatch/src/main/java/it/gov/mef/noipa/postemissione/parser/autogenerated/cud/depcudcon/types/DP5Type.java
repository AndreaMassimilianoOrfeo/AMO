package it.gov.mef.noipa.postemissione.parser.autogenerated.cud.depcudcon.types;

//<xs:element name="totContribTFS" type="xs:string" jrb:length="13" jrb:row="1" nillable="true"/>
//<xs:element name="totImpTFR" type="xs:string" jrb:length="13" jrb:row="1" nillable="true"/>
//<xs:element name="totContribTFR" type="xs:string" jrb:length="13" jrb:row="1" nillable="true"/>
//<xs:element name="totImpGestCredito" type="xs:string" jrb:length="13" jrb:row="1" nillable="true"/>
//<xs:element name="totContribGestCredito" type="xs:string" jrb:length="13" jrb:row="1" nillable="true"/>
//<xs:element name="totImpENPDEP" type="xs:string" jrb:length="13" jrb:row="1" nillable="true"/>
//<xs:element name="totContribEnpdep" type="xs:string" jrb:length="13" jrb:row="1" nillable="true"/>


public class DP5Type {
	protected String recordValue;

	public DP5Type(String recordValue) {
		super();
		this.recordValue = recordValue;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public void setRecordValue(String value) {
		this.recordValue = value;
	}

	public String getTotContribTFS() {
		int startingPosition = 0;
		int length = 13;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getTotImpTFR() {
		int startingPosition = 13;
		int length = 13;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getTotContribTFR() {
		int startingPosition = 26;
		int length = 13;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getTotImpGestCredito() {
		int startingPosition = 39;
		int length = 13;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getTotContribGestCredito() {
		int startingPosition = 52;
		int length = 13;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getTotImpENPDEP() {
		int startingPosition = 65;
		int length = 13;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getTotContribEnpdep() {
		int startingPosition = 78;
		int length = 13;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}


}
