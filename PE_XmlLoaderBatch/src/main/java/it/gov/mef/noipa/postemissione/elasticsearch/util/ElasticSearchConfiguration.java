package it.gov.mef.noipa.postemissione.elasticsearch.util;

import java.util.Arrays;
import java.util.List;

public class ElasticSearchConfiguration {

	private List<String> ipsList;
	private int port;
	private String clustername;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getClustername() {
		return clustername;
	}

	public void setClustername(String clustername) {
		this.clustername = clustername;
	}

	public List<String> getIpsList() {
		return ipsList;
	}

	public void setIpsList(List<String> ipsList) {
		this.ipsList = ipsList;
	}

	public void setIps(String ips) {
		this.ipsList = Arrays.asList(ips.split(","));
	}

}
