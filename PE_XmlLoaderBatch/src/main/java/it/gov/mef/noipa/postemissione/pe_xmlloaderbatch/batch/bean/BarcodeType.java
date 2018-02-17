package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean;

public class BarcodeType {

	private String recordValue;

	public BarcodeType(String recordValue) {
		super();
		this.recordValue = recordValue;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public void setRecordValue(String recordValue) {
		this.recordValue = recordValue;
	}

//    <xs:element name="recordId" type="xs:string" fixed=" BRC" jrb:length="4"/>
//    <xs:element name="raggruppamentoUno" type="xs:string" jrb:length="3"/>
//    <xs:element name="raggruppamentoDue" type="xs:string" jrb:length="3"/>
//    <xs:element name="codiceUfficioServizio" type="xs:string" jrb:length="4"/>
//    <xs:element name="cassa" type="xs:string" jrb:length="2"/>
//    <xs:element name="progressivoCedolino" type="xs:string" jrb:length="5"/>
//    <xs:element name="numeroPartita" type="xs:string" jrb:length="8"/>
//    <xs:element name="codiceUfficoResponsabile" type="xs:string" jrb:length="3"/>
//    <!-- 1 carattere - identificativo del mese di emissione con una lettera da "A" a "N" ->
//    <xs:element name="meseEmissione" type="xs:string" jrb:length="1"/>
//	  <xs:element name="progressivoEmissione" type="xs:string" jrb:length="1"/>
//    <xs:element name="annoEmissione" type="xs:string" jrb:length="1"/>
//	  <!-- 1 carattere - Tipo stipendio("F"issa, "S"peciale, "A"ccessoria, "7"30, "C"UD) ->
//    <xs:element name="tipoCedolino" type="xs:string" jrb:length="1"/>
//	  <xs:element name="numeroMatricola" type="xs:string" jrb:length="8"/>
//    <!-- 1 carattere - identificativo del mese di competenza con una lettera da "A" a "N" ->
//    <xs:element name="rataDiCompetenza" type="xs:string" jrb:length="1"/>
//    <!-- 1 cifre     - ultima cifra dell'anno di competenza ->
//    <xs:element name="annoDiCompetenza" type="xs:string" jrb:length="1"/>
//    <xs:element name="codiceEnte" type="xs:string" jrb:length="4"/>
//	  <xs:element name="numeroPacco" type="xs:string" jrb:length="2"/>
//	  <xs:element name="numeroEmissioni" type="xs:string" jrb:length="1"/>
//	  <xs:element name="tipoEmissione" type="xs:string" jrb:length="2"/>
//	  <!-- 01 o 90 se fuori bilancio ->
//	  <xs:element name="progressivoTipologia" type="xs:string" jrb:length="2"/>
//	  <!-- 1 carattere - flag cessato ("V"igente, "C"essato) ->
//	  <xs:element name="flagCessato" type="xs:string" jrb:length="1"/>
//	  <xs:element name="dataCessazione" type="xs:string" nillable="true"/>
	public String getRagruppamentoUno() {
		int startingPosition = 0;
		int length = 3;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getRagruppamentoDue() {
		int startingPosition = 3;
		int length = 3;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getCodiceUfficioServizio() {
		int startingPosition = 6;
		int length = 4;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getCassa() {
		int startingPosition = 10;
		int length = 2;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getProgressivoCedolino() {
		int startingPosition = 12;
		int length = 5;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getNumeroPartita() {
		int startingPosition = 17;
		int length = 8;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getCodiceUfficoResponsabile() {
		int startingPosition = 25;
		int length = 3;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getMeseEmissione() {
		int startingPosition = 28;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getProgressivoEmissione() {
		int startingPosition = 29;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getAnnoEmissione() {
		int startingPosition = 30;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getTipoCedolino() {
		int startingPosition = 31;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getNumeroMatricola() {
		int startingPosition = 32;
		int length = 8;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getMeseDiCompetenza() {
		int startingPosition = 40;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getAnnoDiCompetenza() {
		int startingPosition = 41;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getCodiceEnte() {
		int startingPosition = 42;
		int length = 4;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getNumeroPacco() {
		int startingPosition = 46;
		int length = 2;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getNumeroEmissioni() {
		int startingPosition = 48;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getTipoEmissione() {
		int startingPosition = 49;
		int length = 2;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getProgressivoTipologia() {
		int startingPosition = 51;
		int length = 2;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

	public String getFlagCessato() {
		int startingPosition = 53;
		int length = 1;
		if (startingPosition < recordValue.length()) {
			return recordValue.substring(startingPosition, Math.min(startingPosition + length, recordValue.length()));
		} else {
			return null;
		}

	}

}
