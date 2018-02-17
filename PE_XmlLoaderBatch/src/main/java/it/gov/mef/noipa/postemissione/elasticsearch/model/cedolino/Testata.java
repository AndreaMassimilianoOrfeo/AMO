package it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino;

public class Testata {

	private String rata;
	private String descrRata;
	private String idCedolino;
	private Anagrafica anagrafica;
	private EnteApp enteApp;
	private String lingua;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Testata() {
	}

	/**
	 *
	 * @param lingua
	 * @param anagrafica
	 * @param rata
	 * @param idCedolino
	 * @param enteApp
	 * @param descrRata
	 */
	public Testata(String idCedolino, String lingua, String descrRata, String rata, EnteApp enteApp, Anagrafica anagrafica) {
		this.idCedolino = idCedolino;
		this.lingua = lingua;
		this.descrRata = descrRata;
		this.rata = rata;
		this.enteApp = enteApp;
		this.anagrafica = anagrafica;
	}

	/**
	 *
	 * @return The idCedolino
	 */
	public String getIdCedolino() {
		return idCedolino;
	}

	/**
	 *
	 * @param idCedolino The idCedolino
	 */
	public void setIdCedolino(String idCedolino) {
		this.idCedolino = idCedolino;
	}

	public Testata withIdCedolino(String idCedolino) {
		this.idCedolino = idCedolino;
		return this;
	}

	/**
	 *
	 * @return The lingua
	 */
	public String getLingua() {
		return lingua;
	}

	/**
	 *
	 * @param lingua The lingua
	 */
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public Testata withLingua(String lingua) {
		this.lingua = lingua;
		return this;
	}

	/**
	 *
	 * @return The descrRata
	 */
	public String getDescrRata() {
		return descrRata;
	}

	/**
	 *
	 * @param descrRata The descrRata
	 */
	public void setDescrRata(String descrRata) {
		this.descrRata = descrRata;
	}

	public Testata withDescrRata(String descrRata) {
		this.descrRata = descrRata;
		return this;
	}

	/**
	 *
	 * @return The rata
	 */
	public String getRata() {
		return rata;
	}

	/**
	 *
	 * @param rata The rata
	 */
	public void setRata(String rata) {
		this.rata = rata;
	}

	public Testata withRata(String rata) {
		this.rata = rata;
		return this;
	}

	/**
	 *
	 * @return The enteApp
	 */
	public EnteApp getEnteApp() {
		return enteApp;
	}

	/**
	 *
	 * @param enteApp The enteApp
	 */
	public void setEnteApp(EnteApp enteApp) {
		this.enteApp = enteApp;
	}

	public Testata withEnteApp(EnteApp enteApp) {
		this.enteApp = enteApp;
		return this;
	}

	/**
	 *
	 * @return The anagrafica
	 */
	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	/**
	 *
	 * @param anagrafica The anagrafica
	 */
	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}

	public Testata withAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
		return this;
	}

}
