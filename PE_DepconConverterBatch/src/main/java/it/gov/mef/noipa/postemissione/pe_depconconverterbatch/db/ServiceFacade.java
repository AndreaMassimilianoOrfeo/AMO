package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.db;

import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.Constants;
import it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean.OrigineDati;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class ServiceFacade{

	@Autowired
	public void setDataSourcePemonitoraggio(DataSource dataSourcePemonitoraggio) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSourcePemonitoraggio);
	}
	private NamedParameterJdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = Logger.getLogger(ServiceFacade.class);
	
	
	public void updateStatoFile(Map<String, OrigineDati> origineDatiMap, Resource resource) {
		OrigineDati origineDati = origineDatiMap.get(resource.getFilename());
		SqlParameterSource parametersOrigineDati =  new MapSqlParameterSource("id_postemissione", origineDati.getIdPostEmissione())
															.addValue("id_origine_dati", origineDati.getIdOrigineDati())
															.addValue("tot_documenti", origineDati.getTotDoc().intValue())
															.addValue("tot_netto", origineDati.getTotNetto())
															.addValue("id_stato_elaborazione_file", Constants.FLUSSO_DATI_DEPCON_CONVERTITO);
		LOGGER.info("Update record origine dati: id_postemissione "+origineDati.getIdPostEmissione()+" id_origine_dati: "+origineDati.getIdOrigineDati()+" tot_documenti: "+origineDati.getTotDoc().intValue()+" tot_netto: "+origineDati.getTotNetto()+" id_stato_elaborazione_file: "+Constants.FLUSSO_DATI_DEPCON_CONVERTITO );    

		jdbcTemplate.update(Constants.sqlUpdateOrigineDati, parametersOrigineDati);
	}
	
	public void updateOrigineDatiStato(Map<String, OrigineDati> origineDatiMap, Resource resource) {
		OrigineDati origineDati = origineDatiMap.get(resource.getFilename());
		SqlParameterSource parametersOrigineDati =  new MapSqlParameterSource("id_postemissione", origineDati.getIdPostEmissione())
															.addValue("id_origine_dati", origineDati.getIdOrigineDati())
															.addValue("id_stato_elaborazione_file", Constants.KO_FLUSSO_DATI_DEPCON_NON_CONVERTITO);
		jdbcTemplate.update(Constants.sqlUpdateOrigineDati_stato, parametersOrigineDati);
	}
	
	public void updateStatoPostemissione(long idPostEmissione, int statoPostEmissione){

		SqlParameterSource parametersPostEmissione =  new MapSqlParameterSource("id_postemissione", idPostEmissione)
																	.addValue("stato_postemissione", statoPostEmissione);
		jdbcTemplate.update(Constants.sqlUpdatePostEmissione, parametersPostEmissione);
		
	}
	
	public void insertPostemissione(long idPostEmissione, Integer id_documento, String rataEmissione, String progressivoEmissione, int stato){

		SqlParameterSource parametersPostemissione =  new MapSqlParameterSource("id_postemissione", idPostEmissione)
																	.addValue("id_documento", id_documento)
																	.addValue("rata", rataEmissione)
         															.addValue("prog_emissione", progressivoEmissione)
         															.addValue("stato_postemissione", stato);
         jdbcTemplate.update(Constants.sqlInsertPostEmissione, parametersPostemissione);
	}

	public void insertOrigineDati(long idPostEmissione, long idOrigineDati, String nomeFileOutput, int stato) {
		SqlParameterSource parametersOrigineDati =  new MapSqlParameterSource("id_postemissione", idPostEmissione)
		.addValue("id_origine_dati", idOrigineDati)
		.addValue("nome_file_origine", nomeFileOutput)
		.addValue("id_stato_elaborazione_file", stato);

		jdbcTemplate.update(Constants.sqlInsertOrigineDati, parametersOrigineDati);
	}
}
