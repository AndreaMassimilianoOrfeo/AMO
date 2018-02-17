package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu;

import java.util.LinkedHashMap;

public class DepconCudWrapper {

	private CudPrimaPagina cudPrimaPagina;
	private LinkedHashMap<Integer, CudSecondaPaginaWrapper> mappaCuSecondaPagina;
	private CudFooter cudFooter;

	public DepconCudWrapper(){}
	
	public DepconCudWrapper(CudPrimaPagina cudPrimaPagina , LinkedHashMap<Integer, CudSecondaPaginaWrapper> mappaCuSecondaPagina){
		this.cudPrimaPagina = cudPrimaPagina ;
		this.mappaCuSecondaPagina = mappaCuSecondaPagina;
	}
	
	public CudPrimaPagina getCudPrimaPagina() {
		return cudPrimaPagina;
	}
	public void setCudPrimaPagina(CudPrimaPagina cudPrimaPagina) {
		this.cudPrimaPagina = cudPrimaPagina;
	}
	public LinkedHashMap<Integer, CudSecondaPaginaWrapper> getMappaCuSecondaPaginaWrapper() {
		return mappaCuSecondaPagina;
	}
	public void setMappaCuSecondaPaginaWrapper(LinkedHashMap<Integer, CudSecondaPaginaWrapper> mappaCuSecondaPagina) {
		this.mappaCuSecondaPagina = mappaCuSecondaPagina;
	}

	public CudFooter getCudFooter() {
		return cudFooter;
	}

	public void setCudFooter(CudFooter cudFooter) {
		this.cudFooter = cudFooter;
	}
}
