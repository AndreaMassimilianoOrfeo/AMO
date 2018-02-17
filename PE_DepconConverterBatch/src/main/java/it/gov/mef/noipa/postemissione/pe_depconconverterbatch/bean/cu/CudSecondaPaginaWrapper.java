package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu;

import java.util.LinkedHashMap;

/**
 * Contiene la una sola istanza di seconda pagina parsata dal depcon + le relative annotazioni  
 * @author a.orfeo
 *
 */
public class CudSecondaPaginaWrapper {

	private CudSecondaPagina  cudSecondaPagina 							= null;
	private LinkedHashMap<Integer, CudAnnotazione> mappaAnnotazioniCud	= null;

	public CudSecondaPaginaWrapper (CudSecondaPagina  cudSecondaPagina ,   LinkedHashMap<Integer, CudAnnotazione> mappaAnnotazioniCud){
		this.cudSecondaPagina = cudSecondaPagina;
		this.mappaAnnotazioniCud = mappaAnnotazioniCud;
	}
	
	public CudSecondaPagina getCudSecondaPagina() {
		return cudSecondaPagina;
	}
	public void setCudSecondaPagina(CudSecondaPagina cudSecondaPagina) {
		this.cudSecondaPagina = cudSecondaPagina;
	}
	public LinkedHashMap<Integer, CudAnnotazione> getMappaAnnotazioniCud() {
		return mappaAnnotazioniCud;
	}
	public void setMappaAnnotazioniCud(LinkedHashMap<Integer, CudAnnotazione> mappaAnnotazioniCud) {
		this.mappaAnnotazioniCud = mappaAnnotazioniCud;
	}
	
	

}
