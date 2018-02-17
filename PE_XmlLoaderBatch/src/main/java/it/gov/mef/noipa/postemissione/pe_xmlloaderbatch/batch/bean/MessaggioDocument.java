package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean;

import java.util.List;

public class MessaggioDocument {

	private int idPostemissione;
	private String nomeFile;
	private String idCedolino;
	private List<String> contenutoMessaggio;
	private String titolo;

	public MessaggioDocument(int idPostemissione, String nomeFile,
			String idCedolino, List<String> contenutoMessaggio, String titolo) {
		super();
		this.idPostemissione = idPostemissione;
		this.nomeFile = nomeFile;
		this.idCedolino = idCedolino;
		this.titolo = titolo;
		this.contenutoMessaggio = contenutoMessaggio;
	}

	public String getIdCedolino() {
		return idCedolino;
	}

	public void setIdCedolino(String idCedolino) {
		this.idCedolino = idCedolino;
	}

	public int getIdPostemissione() {
		return idPostemissione;
	}

	public void setIdPostemissione(int idPostemissione) {
		this.idPostemissione = idPostemissione;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public List<String> getContenutoMessaggio() {
		return contenutoMessaggio;
	}

	public void setContenutoMessaggio(List<String> contenutoMessaggio) {
		this.contenutoMessaggio = contenutoMessaggio;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

}
