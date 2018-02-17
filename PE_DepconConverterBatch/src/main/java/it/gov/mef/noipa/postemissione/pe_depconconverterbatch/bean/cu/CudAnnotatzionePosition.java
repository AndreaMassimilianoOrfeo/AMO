package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu;

public class CudAnnotatzionePosition {
	
	private Integer inzioAnnotazione ;
	private Integer fineAnnotazione ;
	private String  annotazione;
	
	public CudAnnotatzionePosition (Integer inzioAnnotazione , Integer fineAnnotazione , String  annotazione) {
		this.inzioAnnotazione=inzioAnnotazione;
		this.fineAnnotazione=fineAnnotazione;
		this.annotazione=annotazione;
	}
	
	public Integer getInzioAnnotazione() {
		return inzioAnnotazione;
	}
	public void setInzioAnnotazione(Integer inzioAnnotazione) {
		this.inzioAnnotazione = inzioAnnotazione;
	}
	public Integer getFineAnnotazione() {
		return fineAnnotazione;
	}
	public void setFineAnnotazione(Integer fineAnnotazione) {
		this.fineAnnotazione = fineAnnotazione;
	}
	public String getAnnotazione() {
		return annotazione;
	}
	public void setAnnotazione(String annotazione) {
		this.annotazione = annotazione;
	} 

}
