package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean;

import java.util.Date;

public class ScartoDocument {

	private String idProcesso;
	private Date dtProcesso;
	private String nomeFile;
	private int codErrorre;
	private String descErrore;

	public ScartoDocument() {
		super();
	}

	public ScartoDocument(String idProcesso, Date dtProcesso, String nomeFile, int codErrorre, String descErrore) {

		super();

		this.idProcesso = idProcesso;
		this.dtProcesso = dtProcesso;
		this.nomeFile = nomeFile;
		this.codErrorre = codErrorre;
		this.descErrore = descErrore;

	}

	public String getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(String idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Date getDtProcesso() {
		return dtProcesso;
	}

	public void setDtProcesso(Date dtProcesso) {
		this.dtProcesso = dtProcesso;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public int getCodErrore() {
		return codErrorre;
	}

	public void setCodErrore(int codErrorre) {
		this.codErrorre = codErrorre;
	}

	public String getDescErrore() {
		return descErrore;
	}

	public void setDescErrore(String descErrore) {
		this.descErrore = descErrore;
	}

}
