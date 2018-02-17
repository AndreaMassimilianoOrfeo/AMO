package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean;

public class ComboBean {

	private String codice;
	private String descrizione;

	public ComboBean(String codice, String descrizione) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
