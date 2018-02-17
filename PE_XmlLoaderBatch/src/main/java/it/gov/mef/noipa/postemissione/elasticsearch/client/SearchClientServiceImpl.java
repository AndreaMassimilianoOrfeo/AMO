package it.gov.mef.noipa.postemissione.elasticsearch.client;

import it.gov.mef.noipa.postemissione.elasticsearch.util.ElasticSearchConfiguration;
import it.gov.mef.noipa.postemissione.elasticsearch.util.ElasticSearchReservedWords;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class SearchClientServiceImpl implements SearchClientService {

	private static final Logger LOGGER = Logger.getLogger(SearchClientServiceImpl.class);

	private ElasticSearchConfiguration conf;

	public SearchClientServiceImpl(ElasticSearchConfiguration conf) {
		this.conf = conf;
		//client = createClient();
	}

	private Client client;

	public Client getClient() {
		return client;
	}

	protected Client createClient() {
		if (client == null) {
			LOGGER.info("Creating client for Search!!!!");

			try {
				Settings settings = ImmutableSettings
						.settingsBuilder()
						.put(ElasticSearchReservedWords.CLUSTER_NAME.getText(),
								conf.getClustername()).build();

				TransportClient transportClient = new TransportClient(settings);

				Iterator<String> ipsIterator = conf.getIpsList().iterator();
				while (ipsIterator.hasNext()) {
					transportClient = transportClient
							.addTransportAddress(new InetSocketTransportAddress(
									ipsIterator.next(),
									conf.getPort()));
				}

				if (transportClient.connectedNodes().size() == 0) {
					LOGGER.error("There are no active nodes available for the transport, it will be automatically added once nodes are live!");
				}
				client = transportClient;
			} catch (Exception ex) {
				LOGGER.error("Error occured while creating search client!", ex);
			}
		}
		return client;
	}

	public void addNewNode(String name) {
		TransportClient transportClient = (TransportClient) client;
		transportClient.addTransportAddress(new InetSocketTransportAddress(
				name, conf.getPort()));
	}

	public void removeNode(String name) {
		TransportClient transportClient = (TransportClient) client;
		transportClient.removeTransportAddress(new InetSocketTransportAddress(
				name, conf.getPort()));
	}

	public void setConf(ElasticSearchConfiguration conf) {
		this.conf = conf;
	}
}
