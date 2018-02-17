package it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino;

public class EnteApp {

	private String codEnte;
	private String desEnte;
	private String codFiscEnte;
	private String codUffResp;
	private String desUffResp;
	private String codSedeUffServizio;
	private String desSedeUffServizio;
	private String desUnitaOrganizativa;
	private String codUnitaOrganizativa;


	/**
	 * No args constructor for use in serialization
	 *
	 */
	public EnteApp() {
	}

	/**
	 *
	 * @param codEnte
	 * @param codSedeUffServizio
	 * @param codUffResp
	 * @param desEnte
	 * @param desUffResp
	 * @param codFiscEnte
	 * @param desSedeUffServizio
	 */
	public EnteApp(String codUffResp, String desEnte, String codFiscEnte, String codEnte, String desUffResp, String desSedeUffServizio, String codSedeUffServizio,String codUnitaOrganizativa,String desUnitaOrganizativa) {
		this.codUffResp = codUffResp;
		this.desEnte = desEnte;
		this.codFiscEnte = codFiscEnte;
		this.codEnte = codEnte;
		this.desUffResp = desUffResp;
		this.desSedeUffServizio = desSedeUffServizio;
		this.codSedeUffServizio = codSedeUffServizio;
		
		this.desUnitaOrganizativa=desUnitaOrganizativa;
		this.codUnitaOrganizativa=codUnitaOrganizativa;

	}

	/**
	 *
	 * @return The codUffResp
	 */
	public String getCodUffResp() {
		return codUffResp;
	}

	/**
	 *
	 * @param codUffResp The codUffResp
	 */
	public void setCodUffResp(String codUffResp) {
		this.codUffResp = codUffResp;
	}

	public EnteApp withCodUffResp(String codUffResp) {
		this.codUffResp = codUffResp;
		return this;
	}

	/**
	 *
	 * @return The desEnte
	 */
	public String getDesEnte() {
		return desEnte;
	}

	/**
	 *
	 * @param desEnte The desEnte
	 */
	public void setDesEnte(String desEnte) {
		this.desEnte = desEnte;
	}

	public EnteApp withDesEnte(String desEnte) {
		this.desEnte = desEnte;
		return this;
	}

	/**
	 *
	 * @return The codFiscEnte
	 */
	public String getCodFiscEnte() {
		return codFiscEnte;
	}

	/**
	 *
	 * @param codFiscEnte The codFiscEnte
	 */
	public void setCodFiscEnte(String codFiscEnte) {
		this.codFiscEnte = codFiscEnte;
	}



	/**
	 *
	 * @return The codEnte
	 */
	public String getCodEnte() {
		return codEnte;
	}

	/**
	 *
	 * @param codEnte The codEnte
	 */
	public void setCodEnte(String codEnte) {
		this.codEnte = codEnte;
	}

	public EnteApp withCodEnte(String codEnte) {
		this.codEnte = codEnte;
		return this;
	}

	/**
	 *
	 * @return The desUffResp
	 */
	public String getDesUffResp() {
		return desUffResp;
	}

	/**
	 *
	 * @param desUffResp The desUffResp
	 */
	public void setDesUffResp(String desUffResp) {
		this.desUffResp = desUffResp;
	}

	public EnteApp withDesUffResp(String desUffResp) {
		this.desUffResp = desUffResp;
		return this;
	}

	/**
	 *
	 * @return The desSedeUffServizio
	 */
	public String getDesSedeUffServizio() {
		return desSedeUffServizio;
	}

	/**
	 *
	 * @param desSedeUffServizio The desSedeUffServizio
	 */
	public void setDesSedeUffServizio(String desSedeUffServizio) {
		this.desSedeUffServizio = desSedeUffServizio;
	}

	public EnteApp withDesSedeUffServizio(String desSedeUffServizio) {
		this.desSedeUffServizio = desSedeUffServizio;
		return this;
	}

	/**
	 *
	 * @return The codSedeUffServizio
	 */
	public String getCodSedeUffServizio() {
		return codSedeUffServizio;
	}

	/**
	 *
	 * @param codSedeUffServizio The codSedeUffServizio
	 */
	public void setCodSedeUffServizio(String codSedeUffServizio) {
		this.codSedeUffServizio = codSedeUffServizio;
	}

	public EnteApp withCodSedeUffServizio(String codSedeUffServizio) {
		this.codSedeUffServizio = codSedeUffServizio;
		return this;
	}

	public String getDesUnitaOrganizativa() {
		return desUnitaOrganizativa;
	}

	public void setDesUnitaOrganizativa(String desUnitaOrganizativa) {
		this.desUnitaOrganizativa = desUnitaOrganizativa;
	}

	public String getCodUnitaOrganizativa() {
		return codUnitaOrganizativa;
	}

	public void setCodUnitaOrganizativa(String codUnitaOrganizativa) {
		this.codUnitaOrganizativa = codUnitaOrganizativa;
	}

}
