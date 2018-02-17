package it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino;

public class Ced {

	private String _id;
	private Boolean visibile;
	private Boolean archiviato;
	private Object idPostemissione;
	private String nomeFile;
	private String codTipologiaEmissione;
	private String descTipologiaEmissione;
	private Document document;
	private String dataProduzione;
	private String sistemaProvenienza;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Ced() {
	}

	/**
	 *
	 * @param id
	 * @param visibile
	 * @param nomeFile
	 * @param document
	 * @param archiviato
	 * @param descTipologiaEmissione
	 * @param codTipologiaEmissione
	 * @param idPostemissione
	 */
	public Ced(String id, Boolean archiviato, String codTipologiaEmissione, String nomeFile, Boolean visibile, Document document, Object idPostemissione, String descTipologiaEmissione, String dataProduzione, String sistemaProvenienza) {
		this._id = id;
		this.archiviato = archiviato;
		this.codTipologiaEmissione = codTipologiaEmissione;
		this.nomeFile = nomeFile;
		this.visibile = visibile;
		this.document = document;
		this.idPostemissione = idPostemissione;
		this.descTipologiaEmissione = descTipologiaEmissione;
		this.dataProduzione = dataProduzione;
		this.sistemaProvenienza = sistemaProvenienza;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	/**
	 *
	 * @return The archiviato
	 */
	public Boolean getArchiviato() {
		return archiviato;
	}

	/**
	 *
	 * @param archiviato The archiviato
	 */
	public void setArchiviato(Boolean archiviato) {
		this.archiviato = archiviato;
	}

	public Ced withArchiviato(Boolean archiviato) {
		this.archiviato = archiviato;
		return this;
	}

	/**
	 *
	 * @return The codTipologiaEmissione
	 */
	public String getCodTipologiaEmissione() {
		return codTipologiaEmissione;
	}

	/**
	 *
	 * @param codTipologiaEmissione The codTipologiaEmissione
	 */
	public void setCodTipologiaEmissione(String codTipologiaEmissione) {
		this.codTipologiaEmissione = codTipologiaEmissione;
	}

	public Ced withCodTipologiaEmissione(String codTipologiaEmissione) {
		this.codTipologiaEmissione = codTipologiaEmissione;
		return this;
	}

	/**
	 *
	 * @return The nomeFile
	 */
	public String getNomeFile() {
		return nomeFile;
	}

	/**
	 *
	 * @param nomeFile The nomeFile
	 */
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public Ced withNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
		return this;
	}

	/**
	 *
	 * @return The visibile
	 */
	public Boolean getVisibile() {
		return visibile;
	}

	/**
	 *
	 * @param visibile The visibile
	 */
	public void setVisibile(Boolean visibile) {
		this.visibile = visibile;
	}

	public Ced withVisibile(Boolean visibile) {
		this.visibile = visibile;
		return this;
	}

	/**
	 *
	 * @return The document
	 */
	public Document getDocument() {
		return document;
	}

	/**
	 *
	 * @param document The document
	 */
	public void setDocument(Document document) {
		this.document = document;
	}

	public Ced withDocument(Document document) {
		this.document = document;
		return this;
	}

	/**
	 *
	 * @return The idPostemissione
	 */
	public Object getIdPostemissione() {
		return idPostemissione;
	}

	/**
	 *
	 * @param idPostemissione The idPostemissione
	 */
	public void setIdPostemissione(Object idPostemissione) {
		this.idPostemissione = idPostemissione;
	}

	public Ced withIdPostemissione(Object idPostemissione) {
		this.idPostemissione = idPostemissione;
		return this;
	}

	/**
	 *
	 * @return The descTipologiaEmissione
	 */
	public String getDescTipologiaEmissione() {
		return descTipologiaEmissione;
	}

	/**
	 *
	 * @param descTipologiaEmissione The descTipologiaEmissione
	 */
	public void setDescTipologiaEmissione(String descTipologiaEmissione) {
		this.descTipologiaEmissione = descTipologiaEmissione;
	}

	public Ced withDescTipologiaEmissione(String descTipologiaEmissione) {
		this.descTipologiaEmissione = descTipologiaEmissione;
		return this;
	}

	public String getDataProduzione() {
		return dataProduzione;
	}

	public void setDataProduzione(String dataProduzione) {
		this.dataProduzione = dataProduzione;
	}

	public String getSistemaProvenienza() {
		return sistemaProvenienza;
	}

	public void setSistemaProvenienza(String sistemaProvenienza) {
		this.sistemaProvenienza = sistemaProvenienza;
	}

}
