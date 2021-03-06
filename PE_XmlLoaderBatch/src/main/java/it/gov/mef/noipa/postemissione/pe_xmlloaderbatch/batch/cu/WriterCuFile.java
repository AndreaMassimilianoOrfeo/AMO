package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.cu;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import it.gov.mef.noipa.postemissione.parser.autogenerated.cu.cu.Cedolini;
import it.gov.mef.noipa.postemissione.parser.autogenerated.cu.cu.Cedolini.Cu;
import it.gov.mef.noipa.postemissione.parser.autogenerated.cud.CudType;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.CudDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.PostEmissioneDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeElasticFactory;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade.ServiceFacadeJDBC;

public class WriterCuFile implements ItemWriter<it.gov.mef.noipa.postemissione.parser.autogenerated.cu.cu.Cedolini.Cu> {

	private static final Logger LOG = Logger.getLogger(WriterCuFile.class);

	private String nomeFile_origine;
	private String anno;
	private Map<String, String> mappaTipoEmissioni;
	private int idPostemissione;
	private boolean caricaArtefattiOracle;
	private String tipoPostemissione;
	private PostEmissioneDocument postEmissioneDocument;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM", Locale.ITALIAN);

	
	@Autowired
	private ServiceFacadeJDBC serviceFacadeJDBC;
	//@Autowired
	//private ServiceFacadeElasticSearch serviceFacadeElasticSearch;
	//@Autowired
	//private ServiceFacadeElasticSearchStorico serviceFacadeElasticSearchStorico;
	
	@Autowired
	ServiceFacadeElasticFactory serviceFacadeElasticFactory;
	
	@Autowired
	CudTypeBuilder cudTypeBuilder;

	public void write(List<? extends it.gov.mef.noipa.postemissione.parser.autogenerated.cu.cu.Cedolini.Cu> items) throws Exception {

		LOG.info(">>> WriterCuFile - start");
		LOG.info(">>>>> idPostEmissione: " + idPostemissione);
		LOG.info(">>>>> elaborazione file: " + nomeFile_origine);
				
		postEmissioneDocument = serviceFacadeJDBC.getPostemissione(idPostemissione);
		Assert.notNull(postEmissioneDocument, "Nessuna post emissione con id:" + idPostemissione);
		anno = getAnnoRata("" + postEmissioneDocument.getRata());
		
		Cedolini cudWrapper = new Cedolini();
		cudWrapper.getCu().addAll(items);
		mapCud(cudWrapper);
	}

	
	private void mapCud(it.gov.mef.noipa.postemissione.parser.autogenerated.cu.cu.Cedolini cudWrapper) throws Exception {
		int i = 1;

		try {
			
			List <Cu> listaCud = cudWrapper.getCu() ;

			Map<String, CudDocument> mappaCudDocument = new HashMap<String, CudDocument>();

			CudDocument cudDocument;
			String idIndexCedolino;
			for (Cu cu : listaCud) {

				CudType cud = cudTypeBuilder.buildCudType(cu);
				
				// UPPER CASE Codice Fiscale , Cognome e Nome
				cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().setCodFiscaleAmministrato(cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().getCodFiscaleAmministrato().toUpperCase());
				cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().setCognome(cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().getCognome().toUpperCase());
				cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().setNome(cud.getDatiGenerali().getAnagraficaDipendente().getAnagrafica().getNome().toUpperCase());

				/**
				 * insert dati oracle
				 */
				if (caricaArtefattiOracle) {
					LOG.info("Scrittura righe oracle");
					serviceFacadeJDBC.insertArtefattiPostEmissione(
							nomeFile_origine,
							idPostemissione,
							sdf.format(postEmissioneDocument.getDataEmissione()),
							cud.getDatiGenerali().getIscrizione().getIscrizione(),
							cud.getDatiGenerali().getBarcode().split(" ")[1],
							cud.getDatiGenerali().getIscrizione().getIscrizione(),
							cud.getDatiPrevidenziali().getINPDAP().getAnnoRif(),
							cud.getDatiGenerali().getUfficioServizio(),
							cud.getDatiGenerali().getDpt()
					);
					serviceFacadeJDBC.insertCedolini(
							nomeFile_origine,
							idPostemissione,
							sdf.format(postEmissioneDocument.getDataEmissione()),
							cud.getDatiGenerali().getIscrizione().getIscrizione(),
							cud.getDatiGenerali().getBarcode().split(" ")[1],
							cud.getDatiGenerali().getIscrizione().getIscrizione(),
							cud.getDatiPrevidenziali().getINPDAP().getAnnoRif(),
							cud.getDatiGenerali().getUfficioServizio(),
							cud.getDatiGenerali().getDpt()
					);
				}

				/**
				 * insert dati elastic search
				 */
				cudDocument = new CudDocument(true, false, idPostemissione, "", nomeFile_origine, cud);
				cudDocument.setDataProduzione(CudTypeBuilder.getRata());
				cudDocument.setSistemaProvenienza("SPT");
				cudDocument.setProgressivo(cu.getVERSIONE());
				
				idIndexCedolino = cud.getTestata().getIDCedolino();
				
				LOG.debug("Elastic search: cedolino - ced -" + idIndexCedolino);

				mappaCudDocument.put(idIndexCedolino, cudDocument);

				if (i % 250 == 0 || i == listaCud.size()) {
					serviceFacadeElasticFactory.getServiceFacadeElasticInstance().insertCud(anno, mappaCudDocument, idIndexCedolino);
					serviceFacadeElasticFactory.getServiceFacadeElasticStoricoInstance().insertCud(anno, mappaCudDocument, nomeFile_origine);
				}

				i++;
			}

		} catch (Exception e) {
			LOG.error("ERRORE ", e);
			LOG.error("delete su elastic search cud - cud - nomeFile: " + nomeFile_origine);
			serviceFacadeElasticFactory.getServiceFacadeElasticStoricoInstance().deleteCu(anno, nomeFile_origine, idPostemissione);
			throw e;
		} finally {
			LOG.info("finally chiusura di searchClientService");
		}
	}

	
	private String getAnnoRata(String rata) {
		return rata.substring(0, 4);
	}

	public void setResource(Resource resource) {
		this.nomeFile_origine = resource.getFilename();
	}

	public void setIdPostemissione(int idPostemissione) {
		this.idPostemissione = idPostemissione;
	}

	public void setCaricaArtefattiOracle(boolean caricaArtefattiOracle) {
		this.caricaArtefattiOracle = caricaArtefattiOracle;
	}

	public void setMappaTipoEmissioni(Map<String, String> mappaTipoEmissioni) {
		this.mappaTipoEmissioni = mappaTipoEmissioni;
	}

	public void setTipoPostemissione(String tipoPostemissione) {
		this.tipoPostemissione = tipoPostemissione;
	}
}
