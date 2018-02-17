package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu;

import java.util.LinkedHashMap;

/**
 * contiene tutti i dati necessari delle annotazioni da togliere dal mapping della seconda pagina cud
 * @author a.orfeo
 */
public class AnnotazioniCuWrapper {
	private LinkedHashMap<Integer, CudAnnotazione> 			mappaAnnotazioniCud = new LinkedHashMap<Integer, CudAnnotazione>();
	private LinkedHashMap<Integer, CudAnnotatzionePosition> mappaPosizioniAnnotazioniCud = new LinkedHashMap<Integer, CudAnnotatzionePosition>();
	private String cudSecondaPaginaCleared;
	
	public LinkedHashMap<Integer, CudAnnotazione> getMappaAnnotazioniCud() {
		return mappaAnnotazioniCud;
	}
	public void setMappaAnnotazioniCud(LinkedHashMap<Integer, CudAnnotazione> mappaAnnotazioniCud) {
		this.mappaAnnotazioniCud = mappaAnnotazioniCud;
	}
	public LinkedHashMap<Integer, CudAnnotatzionePosition> getMappaPosizioniAnnotazioniCud() {
		return mappaPosizioniAnnotazioniCud;
	}
	public void setMappaPosizioniAnnotazioniCud(
			LinkedHashMap<Integer, CudAnnotatzionePosition> mappaPosizioniAnnotazioniCud) {
		this.mappaPosizioniAnnotazioniCud = mappaPosizioniAnnotazioniCud;
	}
	public String getCudSecondaPaginaCleared() {
		return cudSecondaPaginaCleared;
	}
	public void setCudSecondaPaginaCleared(String cudSecondaPaginaCleared) {
		this.cudSecondaPaginaCleared = cudSecondaPaginaCleared;
	}
	
	
}
