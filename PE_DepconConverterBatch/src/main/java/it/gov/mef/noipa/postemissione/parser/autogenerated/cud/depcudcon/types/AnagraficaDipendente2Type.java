package it.gov.mef.noipa.postemissione.parser.autogenerated.cud.depcudcon.types;


//<xs:element name="recordDG5" type="xs:string" fixed=" DG5" jrb:length="4" jrb:row="1"/>
//<xs:element name="sesso" type="xs:string" jrb:length="1" jrb:row="1"/>
//<xs:element name="dataNascita" type="xs:string" jrb:length="10" jrb:row="1"/>
//<xs:element name="comuneNascita" type="xs:string" jrb:length="40" jrb:row="1"/>
//<xs:element name="SiglaProvinciaNascita" type="xs:string" jrb:length="2" jrb:row="1"/>
//<xs:element name="eventiEccezionali" type="xs:string" jrb:row="1" nillable="true"/>

public class AnagraficaDipendente2Type {
	protected String recordValue;

	public AnagraficaDipendente2Type(String recordValue) {
		super();
		this.recordValue = recordValue;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public void setRecordValue(String value) {
		this.recordValue = value;
	}

	public String getSesso() {

		int startingPosition = 0;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}
	
	public String getDataNascita() {
		int startingPosition = 1;
		int length = 10;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getComuneNascita() {
		int startingPosition = 11;
		int length = 40;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getSiglaProvinciaNascita() {
		int startingPosition = 51;
		int length = 2;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}
	}

	public String getEventiEccezionali() {
		int startingPosition = 53;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition);
		} else {
			return null;
		}
	}

}