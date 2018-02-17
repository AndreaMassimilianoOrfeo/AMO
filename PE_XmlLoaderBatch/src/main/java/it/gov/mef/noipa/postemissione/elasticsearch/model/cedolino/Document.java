package it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino;

public class Document {

	private Testata testata;
	private Totali totali;
	private Messaggi messaggi;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Document() {
	}

	/**
	 *
	 * @param totali
	 * @param testata
	 * @param messaggi
	 */
	public Document(Totali totali, Testata testata, Messaggi messaggi) {
		this.totali = totali;
		this.testata = testata;
		this.messaggi = messaggi;
	}

	/**
	 *
	 * @return The totali
	 */
	public Totali getTotali() {
		return totali;
	}

	/**
	 *
	 * @param totali The totali
	 */
	public void setTotali(Totali totali) {
		this.totali = totali;
	}

	public Document withTotali(Totali totali) {
		this.totali = totali;
		return this;
	}

	/**
	 *
	 * @return The testata
	 */
	public Testata getTestata() {
		return testata;
	}

	/**
	 *
	 * @param testata The testata
	 */
	public void setTestata(Testata testata) {
		this.testata = testata;
	}

	public Document withTestata(Testata testata) {
		this.testata = testata;
		return this;
	}

	/**
	 *
	 * @return The messaggi
	 */
	public Messaggi getMessaggi() {
		return messaggi;
	}

	/**
	 *
	 * @param messaggi The messaggi
	 */
	public void setMessaggi(Messaggi messaggi) {
		this.messaggi = messaggi;
	}

}
