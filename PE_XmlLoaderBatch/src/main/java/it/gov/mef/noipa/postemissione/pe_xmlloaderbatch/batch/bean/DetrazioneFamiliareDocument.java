package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean;

import java.util.Date;

public class DetrazioneFamiliareDocument {

	private String codiceFiscale;
	private int idProtocollo;
	private int impoRedditoComplessivo;
	private String flagDirittoDetrazione;
	private int annomeseDecorrenza;
	private String codiStato;
	private Date dataInvio;
	private int annomeseApplicazione;
	private int idLogInvio;
	private String esitoAcquisizione;
	private String descrizioneEsitoAcquisizione;
	private int idEsitoElaborazione;
	private String rowCreatedUser;
	private Date rowCreatedDttm;
	private String rowUpdatedUser;
	private Date rowUpdatedDttm;
	private Date dataAcquisizione;
	private String annoInvio;

	public DetrazioneFamiliareDocument() {
		super();
	}

	public DetrazioneFamiliareDocument(String codiceFiscale, int idProtocollo, int impoRedditoComplessivo, String flagDirittoDetrazione,
			int annomeseDecorrenza, String codiStato, Date dataInvio, int annomeseApplicazione, int idLogInvio, String esitoAcquisizione,
			String descrizioneEsitoAcquisizione, int idEsitoElaborazione, String rowCreatedUser, Date rowCreatedDttm,
			String rowUpdatedUser, Date rowUpdatedDttm, Date dataAcquisizione, String annoInvio) {

		super();

		this.codiceFiscale = codiceFiscale;
		this.idProtocollo = idProtocollo;
		this.impoRedditoComplessivo = impoRedditoComplessivo;
		this.flagDirittoDetrazione = flagDirittoDetrazione;
		this.annomeseDecorrenza = annomeseDecorrenza;
		this.codiStato = codiStato;
		this.dataInvio = dataInvio;
		this.annomeseApplicazione = annomeseApplicazione;
		this.idLogInvio = idLogInvio;
		this.esitoAcquisizione = esitoAcquisizione;
		this.descrizioneEsitoAcquisizione = descrizioneEsitoAcquisizione;
		this.idEsitoElaborazione = idEsitoElaborazione;
		this.rowCreatedUser = rowCreatedUser;
		this.rowCreatedDttm = rowCreatedDttm;
		this.rowUpdatedUser = rowUpdatedUser;
		this.rowUpdatedDttm = rowUpdatedDttm;
		this.dataAcquisizione = dataAcquisizione;
		this.annoInvio = annoInvio;

	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	// idProtocollo - 1
	public int getIdProtocollo() {
		return idProtocollo;
	}

	public void setIdProtocollo(int idProtocollo) {
		this.idProtocollo = idProtocollo;
	}
	// impoRedditoComplessivo - 2

	public int getImpoRedditoComplessivo() {
		return impoRedditoComplessivo;
	}

	public void setImpoRedditoComplessivo(int impoRedditoComplessivo) {
		this.impoRedditoComplessivo = impoRedditoComplessivo;
	}

	// flagDirittoDetrazione - 3
	public String getFlagDirittoDetrazione() {
		return flagDirittoDetrazione;
	}

	public int getAnnomeseDecorrenza() {
		return annomeseDecorrenza;
	}

	public void setAnnomeseDecorrenza(int annomeseDecorrenza) {
		this.annomeseDecorrenza = annomeseDecorrenza;
	}

	public String getCodiStato() {
		return codiStato;
	}

	public void setCodiStato(String codiStato) {
		this.codiStato = codiStato;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	// annomeseApplicazione - 7
	public int getAnnomeseApplicazione() {
		return annomeseApplicazione;
	}

	public void setAnnomeseApplicazione(int annomeseApplicazione) {
		this.annomeseApplicazione = annomeseApplicazione;
	}

	// idLogInvio - 8
	public int getIdLogInvio() {
		return idLogInvio;
	}

	public void setIdLogInvio(int idLogInvio) {
		this.idLogInvio = idLogInvio;
	}

	// esitoAcquisizione - 9
	public String getEsitoAcquisizione() {
		return esitoAcquisizione;
	}

	public void setEsitoAcquisizione(String esitoAcquisizione) {
		this.codiStato = esitoAcquisizione;
	}

	public String getDescrizioneEsitoAcquisizione() {
		return descrizioneEsitoAcquisizione;
	}

	public void setDescrizioneEsitoAcquisizione(String descrizioneEsitoAcquisizione) {
		this.codiStato = descrizioneEsitoAcquisizione;
	}

	// idEsitoElaborazione - 11
	public int getIdEsitoElaborazione() {
		return idEsitoElaborazione;
	}

	public void setIdEsitoElaborazione(int idEsitoElaborazione) {
		this.idEsitoElaborazione = idEsitoElaborazione;
	}

	// rowCreatedUser - 12
	public String getRowCreatedUser() {
		return rowCreatedUser;
	}

	public void setRowCreatedUser(String rowCreatedUser) {
		this.rowCreatedUser = rowCreatedUser;
	}

	// rowCreatedDttm - 13
	public Date getRowCreatedDttm() {
		return rowCreatedDttm;
	}

	public void setRowCreatedDttm(Date rowCreatedDttm) {
		this.rowCreatedDttm = rowCreatedDttm;
	}

	// rowUpatedUser - 14
	public String getRowUpatedUser() {
		return rowUpdatedUser;
	}

	public void setRowUpatedUser(String rowUpatedUser) {
		this.rowUpdatedUser = rowUpatedUser;
	}

	public Date getRowUpdatedDttm() {
		return rowUpdatedDttm;
	}

	public void setRowUpdatedDttm(Date rowUpdatedDttm) {
		this.rowUpdatedDttm = rowUpdatedDttm;
	}

	// dataAcquisizione - 16
	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}

	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}

	// annoInvio - 17
	public String getAnnoInvio() {
		return annoInvio;
	}

	public void setAnnoInvio(String annoInvio) {
		this.annoInvio = annoInvio;
	}

}
