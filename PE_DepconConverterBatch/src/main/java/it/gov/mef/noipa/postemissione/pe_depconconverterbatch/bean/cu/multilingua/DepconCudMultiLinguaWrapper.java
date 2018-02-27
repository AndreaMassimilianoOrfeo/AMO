package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.multilingua;

import java.util.HashMap;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu.CudFooter;

/**
 * 
 * @author a.orfeo
 *
 */
public class DepconCudMultiLinguaWrapper {
	
	public static final String ITALIANO = "i";
	public static final String TEDESCO = "t";
	
	/**
	 * Contiene una mappa di DepconCudMultilingua
	 * la chiave può assumere i valorei ITALIANO o TEDESCO
	 */

	private HashMap<String, DepconCudMultilingua> mappaCu ;
	private CudFooter cudFooter;
	
	public HashMap<String, DepconCudMultilingua> getMappaCu() {
		return mappaCu;
	}
	public void setMappaCu(HashMap<String, DepconCudMultilingua> mappaCu) {
		this.mappaCu = mappaCu;
	}
	public CudFooter getCudFooter() {
		return cudFooter;
	}
	public void setCudFooter(CudFooter cudFooter) {
		this.cudFooter = cudFooter;
	}
	
}
