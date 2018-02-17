package it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino;

public class Anagrafica {

	private String cognome;
	private String nome;
	private String dataNascita;
	private Matricola matricola;
	private String codFiscaleAmministrato;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Anagrafica() {
	}

	/**
	 *
	 * @param matricola
	 * @param codFiscaleAmministrato
	 * @param dataNascita
	 * @param nome
	 * @param cognome
	 */
	public Anagrafica(String dataNascita, String cognome, String nome, String codFiscaleAmministrato, Matricola matricola) {
		this.dataNascita = dataNascita;
		this.cognome = cognome;
		this.nome = nome;
		this.codFiscaleAmministrato = codFiscaleAmministrato;
		this.matricola = matricola;
	}

	/**
	 *
	 * @return The dataNascita
	 */
	public String getDataNascita() {
		return dataNascita;
	}

	/**
	 *
	 * @param dataNascita The dataNascita
	 */
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Anagrafica withDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
		return this;
	}

	/**
	 *
	 * @return The cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 *
	 * @param cognome The cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Anagrafica withCognome(String cognome) {
		this.cognome = cognome;
		return this;
	}

	/**
	 *
	 * @return The nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 *
	 * @param nome The nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Anagrafica withNome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 *
	 * @return The codFiscaleAmministrato
	 */
	public String getCodFiscaleAmministrato() {
		return codFiscaleAmministrato;
	}

	/**
	 *
	 * @param codFiscaleAmministrato The codFiscaleAmministrato
	 */
	public void setCodFiscaleAmministrato(String codFiscaleAmministrato) {
		this.codFiscaleAmministrato = codFiscaleAmministrato;
	}

	public Anagrafica withCodFiscaleAmministrato(String codFiscaleAmministrato) {
		this.codFiscaleAmministrato = codFiscaleAmministrato;
		return this;
	}

	/**
	 *
	 * @return The matricola
	 */
	public Matricola getMatricola() {
		return matricola;
	}

	/**
	 *
	 * @param matricola The matricola
	 */
	public void setMatricola(Matricola matricola) {
		this.matricola = matricola;
	}

	public Anagrafica withMatricola(Matricola matricola) {
		this.matricola = matricola;
		return this;
	}

}
