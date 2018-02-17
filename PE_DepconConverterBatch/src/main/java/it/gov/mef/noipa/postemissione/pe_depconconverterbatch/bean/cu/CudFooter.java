package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu;

import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FieldOptional;
import org.coury.jfilehelpers.annotations.FieldTrim;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.FixedMode;
import org.coury.jfilehelpers.enums.TrimMode;

@FixedLengthRecord(fixedMode=FixedMode.AllowLessChars)
public class CudFooter {
	

	// FOOTER CUD SEZIONE 5 * 1000
	@FieldFixedLength(4)
	public String $5X1;
	
	@FieldFixedLength(11)
	@FieldOptional
	public String codiceFiscaleSostitutoImposta;

	@FieldFixedLength(16)
	@FieldOptional
	public String codiceFiscaleSostitutoDichiarante;
	
	@FieldFixedLength(22)
	@FieldOptional
	public String cognome;

	@FieldFixedLength(14)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio43;
	
	@FieldFixedLength(21)
	@FieldOptional
	public String nome;

	@FieldFixedLength(16)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio44;

	@FieldFixedLength(1)
	@FieldOptional
	public String sesso;
	
	@FieldFixedLength(10)
	@FieldOptional
	public String dataNascita; 
	
	@FieldFixedLength(1)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio45;
	
	@FieldFixedLength(30)
	@FieldOptional
	public String comuneNascita;
	
	@FieldFixedLength(2)
	@FieldTrim(trimMode=TrimMode.Both)
	public String spazio46;

	@FieldFixedLength(2)
	public String provinciaNascita;

	public String get$5X1() {
		return $5X1;
	}

	public void set$5X1(String $5x1) {
		$5X1 = $5x1;
	}

	public String getCodiceFiscaleSostitutoImposta() {
		return codiceFiscaleSostitutoImposta;
	}

	public void setCodiceFiscaleSostitutoImposta(String codiceFiscaleSostitutoImposta) {
		this.codiceFiscaleSostitutoImposta = codiceFiscaleSostitutoImposta;
	}

	public String getCodiceFiscaleSostitutoDichiarante() {
		return codiceFiscaleSostitutoDichiarante;
	}

	public void setCodiceFiscaleSostitutoDichiarante(String codiceFiscaleSostitutoDichiarante) {
		this.codiceFiscaleSostitutoDichiarante = codiceFiscaleSostitutoDichiarante;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSpazio43() {
		return spazio43;
	}

	public void setSpazio43(String spazio43) {
		this.spazio43 = spazio43;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSpazio44() {
		return spazio44;
	}

	public void setSpazio44(String spazio44) {
		this.spazio44 = spazio44;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getSpazio45() {
		return spazio45;
	}

	public void setSpazio45(String spazio45) {
		this.spazio45 = spazio45;
	}

	public String getComuneNascita() {
		return comuneNascita;
	}

	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}

	public String getSpazio46() {
		return spazio46;
	}

	public void setSpazio46(String spazio46) {
		this.spazio46 = spazio46;
	}

	public String getProvinciaNascita() {
		return provinciaNascita;
	}

	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}
	
	
}
