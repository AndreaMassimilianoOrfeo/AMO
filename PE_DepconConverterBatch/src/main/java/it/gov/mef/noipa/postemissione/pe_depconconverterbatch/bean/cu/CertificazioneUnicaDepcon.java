package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.cu;

import java.util.List;

public class CertificazioneUnicaDepcon {

	private List <DepconCudWrapper> listaCu  ;

	public List<DepconCudWrapper> getListaCu() {
		return listaCu;
	}

	public void setListaCu(List<DepconCudWrapper> listaCu) {
		this.listaCu = listaCu;
	}
}
