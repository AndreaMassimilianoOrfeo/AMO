package it.gov.mef.noipa.postemissione.parser.autogenerated.cud.depcudcon.types;

public class DatiGeneraliType {
	protected String recordValue;

	public DatiGeneraliType(String recordValue) {
		super();
		this.recordValue = recordValue;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public void setRecordValue(String value) {
		this.recordValue = value;
	}

	public String getDpt() {
		int startingPosition = 0;
		int length = 3;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getR1() {
		int startingPosition = 3;
		int length = 3;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}
	
	public String getR2() {
		int startingPosition = 6;
		int length = 3;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}
	
	public String getUfficioServizio() {
		int startingPosition = 9;
		int length = 4;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}
	
	public String getIscrizione() {
		int startingPosition = 13;
		int length = 8;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}
	
	public String getSedeMAE() {
		int startingPosition = 21;
		int length = 7;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}
	
	public String getDescrMAE() {
		int startingPosition = 28;
		int length = 15;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition,
					Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}


}
