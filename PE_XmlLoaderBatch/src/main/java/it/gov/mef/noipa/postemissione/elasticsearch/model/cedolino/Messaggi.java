package it.gov.mef.noipa.postemissione.elasticsearch.model.cedolino;

import java.util.ArrayList;
import java.util.List;

public class Messaggi {

	private List<String> messaggi = new ArrayList<>();

	public List<String> getMessaggi() {
		return messaggi;
	}

	public void setMessaggi(List<String> messaggi) {
		this.messaggi = messaggi;
	}

}
