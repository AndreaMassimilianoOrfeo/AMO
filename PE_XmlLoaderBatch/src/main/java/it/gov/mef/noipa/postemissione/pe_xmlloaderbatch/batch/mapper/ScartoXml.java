package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.Scarti;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeJDBCCedLoader;

import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ScartoXml {

	public static List<Scarti> listScarti = Collections.synchronizedList(new ArrayList<Scarti>());

	private static final Logger LOG = Logger.getLogger(ScartoXml.class);
	private String errorMessage = "Errore durante l'elaborazione dello scarto - XML: ";
	String strResult;

	@Autowired
	public ServiceFacadeJDBCCedLoader serviceFacadeJDBCCedLoader;

	public String creaXml(ServiceFacadeJDBCCedLoader JDBCCedLoader, int idOrigineDati, String nomeFile, Date dtProcesso) throws FileNotFoundException {

		LOG.info(">>> Classe ScartoXml");

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;

		try {
			docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			// root elements
			Element rootElement = doc.createElement("FILE_XML");
			Element idProcesso;
			Element dtProcessoXml;

			doc.appendChild(rootElement);

			// ID_PROCESSO element
			idProcesso = doc.createElement("ID_PROCESSO");
			idProcesso.appendChild(doc.createTextNode(nomeFile));
			rootElement.appendChild(idProcesso);

			// DT_PROCESSO element
			dtProcessoXml = doc.createElement("DT_PROCESSO");
			dtProcessoXml.appendChild(doc.createTextNode(dtProcesso.toString()));
			rootElement.appendChild(dtProcessoXml);

			Element errore = doc.createElement("ERRORE");
			rootElement.appendChild(errore);

			Element codErrore = doc.createElement("COD_ERRORE");
			codErrore.appendChild(doc.createTextNode(listScarti.get(0).getErroreScarto().toString()));
			errore.appendChild(codErrore);

			Element descErrore = doc.createElement("DESC_ERRORE");
			descErrore.appendChild(doc.createTextNode(listScarti.get(0).getDescErroreScarto()));
			errore.appendChild(descErrore);

			Element nomeFileXml = doc.createElement("NOME_FILE_PDF");
			nomeFileXml.appendChild(doc.createTextNode(listScarti.get(0).getPdf()));
			errore.appendChild(nomeFileXml);

			listScarti.clear();

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			try {

				TransformerFactory tFact = TransformerFactory.newInstance();
				Transformer trans = tFact.newTransformer();

				StringWriter writer = new StringWriter();
				StreamResult result = new StreamResult(writer);
				DOMSource source = new DOMSource(doc);

				try {

					trans.transform(source, result);
					strResult = writer.toString();

				} catch (TransformerException e) {
					LOG.error(errorMessage + nomeFile, e);
				}

			} catch (TransformerConfigurationException e) {
				LOG.error(errorMessage + nomeFile, e);
			}

		} catch (ParserConfigurationException e) {
			LOG.error(errorMessage + nomeFile, e);
		}
		return strResult;
	}

	public void inserimentoScarto(ServiceFacadeJDBCCedLoader JDBCCedLoader, String fileName, String pdf, int codErrore, String errore, int idOrigineDati) throws FileNotFoundException, UnsupportedEncodingException {

		Scarti scarto = new Scarti();
		scarto.setPdf(pdf);
		scarto.setDescErroreScarto(errore);
		scarto.setErroreScarto(codErrore);
		LOG.info("pdf: " + scarto.getPdf());
		LOG.info("errore: " + scarto.getDescErroreScarto());
		LOG.info("codErrore: " + scarto.getErroreScarto());
		listScarti.add(scarto);
	}
}
