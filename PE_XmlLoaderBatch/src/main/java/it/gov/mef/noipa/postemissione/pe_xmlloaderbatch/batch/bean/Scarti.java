package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean;

public class Scarti {

	private Integer erroreScarto;
	private String descErroreScarto;
	private String pdf;

	public Integer getErroreScarto() {
		return erroreScarto;
	}

	public void setErroreScarto(Integer erroreScarto) {
		this.erroreScarto = erroreScarto;
	}

	public String getDescErroreScarto() {
		return descErroreScarto;
	}

	public void setDescErroreScarto(String descErroreScarto) {
		this.descErroreScarto = descErroreScarto;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

}
