package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean;

import java.math.BigInteger;

public class OrigineDati {
	
	private String nomeFile;
	private long idPostEmissione;
	private long idOrigineDati;
	private BigInteger totDoc;
	private Double totNetto;
	
	
	public String getNomeFile() {
		return nomeFile;
	}
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	public BigInteger getTotDoc() {
		return totDoc;
	}
	public void setTotDoc(BigInteger totDoc) {
		this.totDoc = totDoc;
	}
	public Double getTotNetto() {
		return totNetto;
	}
	public void setTotNetto(Double totNetto) {
		this.totNetto = totNetto;
	}
	public long getIdPostEmissione() {
		return idPostEmissione;
	}
	public void setIdPostEmissione(long idPostEmissione) {
		this.idPostEmissione = idPostEmissione;
	}
	public long getIdOrigineDati() {
		return idOrigineDati;
	}
	public void setIdOrigineDati(long idOrigineDati) {
		this.idOrigineDati = idOrigineDati;
	}
	

}
