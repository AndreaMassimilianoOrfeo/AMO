package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.multilingua;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudPrimaPagina;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudSecondaPagina;

public class DepconCudMultilingua {
	
	private CudPrimaPagina cudPrimaPagina;
	private CudSecondaPagina cudSecondaPagina;
	private String lingua;
	
	public CudPrimaPagina getCudPrimaPagina() {
		return cudPrimaPagina;
	}
	public void setCudPrimaPagina(CudPrimaPagina cudPrimaPagina) {
		this.cudPrimaPagina = cudPrimaPagina;
	}
	public CudSecondaPagina getCudSecondaPagina() {
		return cudSecondaPagina;
	}
	public void setCudSecondaPagina(CudSecondaPagina cudSecondaPagina) {
		this.cudSecondaPagina = cudSecondaPagina;
	}
	public String getLingua() {
		return lingua;
	}
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
}
