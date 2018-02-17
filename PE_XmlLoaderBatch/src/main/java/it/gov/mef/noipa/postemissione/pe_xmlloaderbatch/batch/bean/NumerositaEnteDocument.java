package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean;

public class NumerositaEnteDocument {

	private int countEnte;
	private String codiEnte;

	public NumerositaEnteDocument() {
		super();
	}

	public NumerositaEnteDocument(int countEnte, String codiEnte) {

		super();

		this.countEnte = countEnte;
		this.codiEnte = codiEnte;
	}

	public int getCountEnte() {
		return countEnte;
	}

	public void setCountEnte(int countEnte) {
		this.countEnte = countEnte;
	}

	public String getCodiEnte() {
		return codiEnte;
	}

	public void setCodiEnte(String codiEnte) {
		this.codiEnte = codiEnte;
	}

}
