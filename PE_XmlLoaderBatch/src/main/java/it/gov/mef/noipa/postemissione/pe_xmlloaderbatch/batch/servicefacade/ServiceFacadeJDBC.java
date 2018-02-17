package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.ComboBean;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.Constants;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.PostEmissioneDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper.ComboBeanMapper;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper.IdPostemissioniMapper;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper.PostEmissioneMapper;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class ServiceFacadeJDBC {

	@Autowired
	public void setDataSourcePemonitoraggio(DataSource dataSourcePemonitoraggio) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(
				dataSourcePemonitoraggio);
	}

	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<ComboBean> getDescTipoEmissioni(int idPostemissione) {
		List<ComboBean> listaCombo = jdbcTemplate.query(
				Constants.sqlGetCodDescTipoEmissioniByPostEmissione,
				new MapSqlParameterSource("id_postemissione", idPostemissione),
				new ComboBeanMapper());
		return listaCombo;
	}

	public PostEmissioneDocument getPostemissione(int idPostemissione) {
		return jdbcTemplate.queryForObject(Constants.sqlGetPostEmissioneById,
				new MapSqlParameterSource("id_postemissione", idPostemissione),
				new PostEmissioneMapper());
	}

	public void insertArtefattiPostEmissione(String nomeFile,
			int idPostemissione, String dataEmissione, String iscrizione,
			String codEnte, String idCedolino, String rata, String codUffServ,
			String codUffResp) {

		SqlParameterSource parameters = new MapSqlParameterSource(
				"id_postemissione", idPostemissione)
				.addValue("id_artefatto", idCedolino)
				.addValue("id_stato_artefatto", 1)
				.addValue("rata", dataEmissione)
				.addValue("rata_effettiva", rata).addValue("cod_emissione", 1)
				.addValue("nome_file", nomeFile)
				.addValue("matricola", iscrizione)
				.addValue("cod_ente", codEnte).addValue("cod_so", codUffServ)
				.addValue("cod_uff", codUffResp);

		jdbcTemplate.update(Constants.sqlInsertArtefattiPostEmissione,
				parameters);
	}

	public void insertCedolini(String nomeFile, int idPostemissione,
			String dataEmissione, String iscrizione, String codEnte,
			String idCedolino, String rata, String codUffServ, String codUffResp) {

		SqlParameterSource parameters = new MapSqlParameterSource(
				"id_postemissione", idPostemissione)
				.addValue("id_artefatto", idCedolino)
				.addValue("id_stato_artefatto", 1)
				.addValue("rata", dataEmissione)
				.addValue("rata_effettiva", rata).addValue("cod_emissione", 1)
				.addValue("nome_file", nomeFile)
				.addValue("matricola", iscrizione)
				.addValue("cod_ente", codEnte).addValue("cod_so", codUffServ)
				.addValue("cod_uff", codUffResp);

		jdbcTemplate.update(Constants.sqlInsertCedolini, parameters);
	}

	public int updateStatoPostemissione(int idPostemissione, int stato,
			List<Integer> listaStatiOrig) {
		SqlParameterSource parametersPostEmissione = new MapSqlParameterSource(
				"id_postemissione", idPostemissione).addValue(
				"stato_postemissione_new", stato).addValue(
						"stato_postemissione_orig", listaStatiOrig);
		return jdbcTemplate.update(Constants.sqlUpdatePostEmissione_stato,
				parametersPostEmissione);
	}

	public int aggiornaStatoOrigineDati(String nomeFile, int stato,
			int idPostemissione) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource(
				"nome_file_origine", nomeFile).addValue(
				"id_stato_elaborazione_file", stato).addValue(
						"id_postemissione", idPostemissione);
		return jdbcTemplate.update(Constants.sqlUpdateOrigineDati,
				parametersOrigineDati);
	}

	public int updateStatoOrigineDati(int idPostemissione, int stato,
			List<Integer> listaStatiOrig, String filename) {

		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource(
				"id_postemissione", idPostemissione)
				.addValue("id_stato_elaborazione_file_new", stato)
				.addValue("id_stato_elaborazione_file_orig", listaStatiOrig)
				.addValue("nome_file_originale", filename);

		return jdbcTemplate.update(Constants.sqlUpdateOrigineDati_stato,
				parametersOrigineDati);

	}

	public int countOrigineDati(int idPostemissione,
			int id_stato_elaborazione_file_new, List<Integer> listaStatiOrig,
			String filename) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource(
				"id_postemissione", idPostemissione).addValue(
				"nome_file_originale", filename);

		return jdbcTemplate.queryForObject(Constants.sqlCountOrigineDati,
				parametersOrigineDati, Integer.class);

	}

	// RECUPERO ID SOTTOSISTEMA DALLA TABELLA SOTTOSISTEMI DI PE_MONITORAGGIO
	public int returnIdSottositema(String descSottosistema) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource(
				"desc_sottosistema", descSottosistema);
		return jdbcTemplate.queryForObject(Constants.sqlReturnIdSottosistema,
				parametersOrigineDati, Integer.class);
	}

	// RECUPERO ID SOTTOSISTEMA DALLA TABELLA SOTTOSISTEMI DI PE_MONITORAGGIO
	public int returnIdDocumento(String tipoDocumento) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource(
				"tipo_documento", tipoDocumento);
		return jdbcTemplate.queryForObject(Constants.sqlReturnIdDocumento,
				parametersOrigineDati, Integer.class);
	}

	// La funzionalit� controlla che il nome del file da elaborare sia presente
	// nella tabella PE_MONITORAGGIO.ORIGINE_DATI
	public int countOrigineDatiCedLoader(int idPostemissione,
			String nomeFileOrigine, int statoPostemissione,
			List<Integer> listaStatiOrig) {

		SqlParameterSource parametersPostEmissione = new MapSqlParameterSource(
				"id_postemissione", idPostemissione)
				.addValue("nome_file_origine", nomeFileOrigine)
				.addValue("stato_postemissione", statoPostemissione)
				.addValue("stato_elaborazione_file", listaStatiOrig);
		return jdbcTemplate.queryForObject(Constants.sqlCountPEMonitoraggio,
				parametersPostEmissione, Integer.class);
	}

	// Recupero id_origine_dati da origine_dati da PE_MONITORAGGIO
	public int returnIdOrigineDati(int idPostemissione, String nomeFileOrigine,
			int idStatoElaborazioneFile) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource(
				"id_postemissione", idPostemissione).addValue(
				"nome_file_origine", nomeFileOrigine).addValue(
						"id_stato_elaborazione_file", idStatoElaborazioneFile);
		return jdbcTemplate.queryForObject(Constants.sqlReturnIdOrigineDati,
				parametersOrigineDati, Integer.class);
	}

	// INSERT CARICAMENTI_PORTALE
	public void insertCaricamentiPortale(int idOrigineDati,
			int idPostemissione, int idStatoElaborazioneFile) {

		SqlParameterSource parameters = new MapSqlParameterSource(
				"id_origine_dati", idOrigineDati).addValue("id_postemissione",
				idPostemissione).addValue("id_stato_elaborazione_file",
						idStatoElaborazioneFile);

		jdbcTemplate.update(Constants.sqlInsertCaricamenti_portale, parameters);

	}

	// UPDATE CARICAMENTI PORTALE PER LA SEZIONE MODULO TERMINA ELABORAZIONE
	public int updateCaricamentiPortale(int idStatoElaborazioneFileNew,
			int idOrigineDati, int idPostemissione, int idStatoElaborazioneFile) {

		SqlParameterSource parameters = new MapSqlParameterSource(
				"id_stato_elaborazione_file_new", idStatoElaborazioneFileNew)
				.addValue("id_origine_dati", idOrigineDati)
				.addValue("id_postemissione", idPostemissione)
				.addValue("id_stato_elaborazione_file", idStatoElaborazioneFile);

		return jdbcTemplate.update(Constants.sqlUpdateCaricamentiPortale,
				parameters);
	}

	// UPDATE CARICAMENTI PORTALE PER LA SEZIONE MODULO TERMINA ELABORAZIONE
	public int updateCaricamentiPortaleScarto(int idStatoElaborazioneFileNew,
			int idOrigineDati, int idPostemissione,
			int idStatoElaborazioneFile, String fileXml) {

		SqlParameterSource parameters = new MapSqlParameterSource(
				"id_stato_elaborazione_file_new", idStatoElaborazioneFileNew)
				.addValue("id_origine_dati", idOrigineDati)
				.addValue("id_postemissione", idPostemissione)
				.addValue("file_scarto", fileXml)
				.addValue("id_stato_elaborazione_file", idStatoElaborazioneFile);

		return jdbcTemplate.update(Constants.sqlUpdateCaricamentiPortaleScarto,
				parameters);
	}

	public List<String> getPostemissioniDisponibili() {
		return jdbcTemplate.query(Constants.sqlGetPostemissioniDisponibili, new MapSqlParameterSource(), new IdPostemissioniMapper());
	}

	public List<String> getPostemissioniElaborate() {
		return jdbcTemplate.query(Constants.sqlGetPostemissioniElaborate, new MapSqlParameterSource(), new IdPostemissioniMapper());
	}

}
