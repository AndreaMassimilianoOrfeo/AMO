package it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino;

public class Totali {

	private String totaleNetto;
	private String quintoCedibile;
	private Object totaleNettoNumber;
	private Object quintoCedibileNumber;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Totali() {
	}

	/**
	 *
	 * @param quintoCedibile
	 * @param quintoCedibileNumber
	 * @param totaleNetto
	 * @param totaleNettoNumber
	 */
	public Totali(String quintoCedibile, String totaleNetto, Object quintoCedibileNumber, Object totaleNettoNumber) {
		this.quintoCedibile = quintoCedibile;
		this.totaleNetto = totaleNetto;
		this.quintoCedibileNumber = quintoCedibileNumber;
		this.totaleNettoNumber = totaleNettoNumber;
	}

	/**
	 *
	 * @return The quintoCedibile
	 */
	public String getQuintoCedibile() {
		return quintoCedibile;
	}

	/**
	 *
	 * @param quintoCedibile The quintoCedibile
	 */
	public void setQuintoCedibile(String quintoCedibile) {
		this.quintoCedibile = quintoCedibile;
	}

	public Totali withQuintoCedibile(String quintoCedibile) {
		this.quintoCedibile = quintoCedibile;
		return this;
	}

	/**
	 *
	 * @return The totaleNetto
	 */
	public String getTotaleNetto() {
		return totaleNetto;
	}

	/**
	 *
	 * @param totaleNetto The totaleNetto
	 */
	public void setTotaleNetto(String totaleNetto) {
		this.totaleNetto = totaleNetto;
	}

	public Totali withTotaleNetto(String totaleNetto) {
		this.totaleNetto = totaleNetto;
		return this;
	}

	/**
	 *
	 * @return The quintoCedibileNumber
	 */
	public Object getQuintoCedibileNumber() {
		return quintoCedibileNumber;
	}

	/**
	 *
	 * @param quintoCedibileNumber The quintoCedibileNumber
	 */
	public void setQuintoCedibileNumber(Object quintoCedibileNumber) {
		this.quintoCedibileNumber = quintoCedibileNumber;
	}

	public Totali withQuintoCedibileNumber(Object quintoCedibileNumber) {
		this.quintoCedibileNumber = quintoCedibileNumber;
		return this;
	}

	/**
	 *
	 * @return The totaleNettoNumber
	 */
	public Object getTotaleNettoNumber() {
		return totaleNettoNumber;
	}

	/**
	 *
	 * @param totaleNettoNumber The totaleNettoNumber
	 */
	public void setTotaleNettoNumber(Object totaleNettoNumber) {
		this.totaleNettoNumber = totaleNettoNumber;
	}

	public Totali withTotaleNettoNumber(Object totaleNettoNumber) {
		this.totaleNettoNumber = totaleNettoNumber;
		return this;
	}

}
