package it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino;

public class Matricola {

	private String iscrizione;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Matricola() {
	}

	/**
	 *
	 * @param iscrizione
	 */
	public Matricola(String iscrizione) {
		this.iscrizione = iscrizione;
	}

	/**
	 *
	 * @return The iscrizione
	 */
	public String getIscrizione() {
		return iscrizione;
	}

	/**
	 *
	 * @param iscrizione The iscrizione
	 */
	public void setIscrizione(String iscrizione) {
		this.iscrizione = iscrizione;
	}

	public Matricola withIscrizione(String iscrizione) {
		this.iscrizione = iscrizione;
		return this;
	}

}
