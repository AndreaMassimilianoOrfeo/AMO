package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.servicefacade;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.Constants;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.DetrazioneFamiliareDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.NumerositaEnteDocument;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper.DetrazioneFamiliareMapper;
import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper.NumerositaEnteMapper;

import java.util.List;

import javax.sql.DataSource;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ServiceFacadeJDBCCedLoader {

	@Autowired
	public void setDataSourceUcedolino(DataSource dataSourceUcedolino) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceUcedolino);
	}

	private NamedParameterJdbcTemplate jdbcTemplate;

	public int countOrigineDati(int idPostemissione, int id_stato_elaborazione_file_new, List<Integer> listaStatiOrig, String filename) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("id_postemissione", idPostemissione)
				.addValue("nome_file_originale", filename);
		return jdbcTemplate.queryForObject(Constants.sqlCountOrigineDati, parametersOrigineDati, Integer.class);
	}

	// INSERT D_STORICO_BATCH
	public void insertDStoricoBatch(String nomeFile, String tipoElaborazione) throws Exception {
		InetAddress addr = InetAddress.getLocalHost();
		String ipAddress = addr.getHostAddress();
		String opSystem = System.getProperty("os.name").toLowerCase();
		SqlParameterSource parameters = new MapSqlParameterSource("nome_file", nomeFile)
				.addValue("nome_batch", "LOADER")
				.addValue("host", ipAddress)
				.addValue("so", opSystem)
				.addValue("tipo_modello_in_elaborazione", tipoElaborazione)
				.addValue("tipologia_caricamento", "CC");
		jdbcTemplate.update(Constants.sqlInsertDStoricoBatch, parameters);
	}

	// INSERT U_CEDOLINO_COL.D_PROTOCOLLO_CEDOLINO
	public void insertProtocolloCedolino(int sequIdProtocollo, String annoInvio) throws Exception {
		SqlParameterSource parameters = new MapSqlParameterSource("sequ_id_protocollo", sequIdProtocollo)
				.addValue("codi_tipo_richiesta", "PPI")
				.addValue("row_created_user", "PE_XMLLoaderBatch")
				.addValue("anno_invio", annoInvio);
		jdbcTemplate.update(Constants.sqlInsertProtocolloCedolino, parameters);
	}

	// RECUPERO CODI_DPT
	public String returnCodiDpt(String codiDpt) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("codi_dpt", codiDpt);
		return jdbcTemplate.queryForObject(Constants.sqlReturnCodiDpt, parametersOrigineDati, String.class);
	}

	// RECUPERO ID PROCESSO
	public int sequIdProcesso() {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource();
		return jdbcTemplate.queryForObject(Constants.sqlReturnIdProcesso, parametersOrigineDati, Integer.class);
	}

	// RECUPERO DT_PROCESSO
	public Date dtProcesso() {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource();
		return jdbcTemplate.queryForObject(Constants.sqlReturnDtProcesso, parametersOrigineDati, Date.class);
	}

	// RECUPERO ID_PROCESSO
	public int returnIdProcessoHistory(String idProcesso) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("id_processo", idProcesso);
		return jdbcTemplate.queryForObject(Constants.sqlReturnIdProcessoHistory, parametersOrigineDati, Integer.class);
	}

	// RECUPERO DT_PROCESSO per insertProcesso, insertStatoProcesso, insertHistoryProcesso
	public Date returnDtProcessoHistory(int sequIdProcesso) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("sequ_id_processo", sequIdProcesso);
		return jdbcTemplate.queryForObject(Constants.sqlReturnDtProcessoHistory, parametersOrigineDati, Date.class);
	}

	// INSERT PROCESSO
	public void insertProcesso(String idProcesso, int sequIdProcesso, Date dtProcesso) {
		SqlParameterSource parameters = new MapSqlParameterSource("id_processo", idProcesso)
				.addValue("dt_processo", dtProcesso)
				.addValue("sequ_id_processo", sequIdProcesso);
		jdbcTemplate.update(Constants.sqlInsertProcesso, parameters);
	}

	// INSERT STATO PROCESSO
	public void insertStatoProcesso(String idProcesso, Date dtProcesso, String statoProcesso, String esitoProcesso) {
		SqlParameterSource parameters = new MapSqlParameterSource("id_processo", idProcesso)
				.addValue("dt_processo", dtProcesso)
				.addValue("stato", statoProcesso)
				.addValue("esito", esitoProcesso);
		jdbcTemplate.update(Constants.sqlInsertStatoProcesso, parameters);
	}

	// INSERT HISTORY_PROCESSO
	public void insertHistoryProcesso(String idProcesso, Date dtProcesso, String taskName) {
		SqlParameterSource parameters = new MapSqlParameterSource("id_processo", idProcesso)
				.addValue("dt_processo", dtProcesso)
				.addValue("task_name", taskName);
		jdbcTemplate.update(Constants.sqlInsertHistoryProcesso, parameters);
	}

	// RECUPERO ID FILE ELABORATO PER INSERT D_ELABORAZIONE_FILE
	public int sequIdFileElaborato() {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource();
		return jdbcTemplate.queryForObject(Constants.sqlReturnIdFileElaborato, parametersOrigineDati, Integer.class);
	}

	// RECUPERO SEQU_ID_CRDOLINO PER INSERT CEDOLINO
	public int sequIdCedolino() {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource();
		return jdbcTemplate.queryForObject(Constants.sqlReturnSequIdCedolino, parametersOrigineDati, Integer.class);
	}

	// RECUPERO SEQU_ID_CRDOLINO PER INSERT U_DETRAZIONE_FAMILIARE
	public int sequIdProtocollo() {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource();
		return jdbcTemplate.queryForObject(Constants.sqlReturnSequIdProtocollo, parametersOrigineDati, Integer.class);
	}

	// INSERT D_ELABORAZIONE_FILE
	public void insertDElaborazioneFile(int sequIdFileElaborato, String tipoElaborazione, String nomeFile) {
		SqlParameterSource parameters = new MapSqlParameterSource("sequ_id_file_elaborato", sequIdFileElaborato)
				.addValue("esito_elaborazione", 1)
				.addValue("tipo_elaborazione", tipoElaborazione)
				.addValue("nome_file", nomeFile)
				.addValue("row_created_user", "PE_XMLLoaderBatch");
		jdbcTemplate.update(Constants.sqlInsertDElaborazioneFile, parameters);
	}

	// Controlla se xml_totale esiste gi�
	public int countDXmlTotale(String codiTipoEmissione, String codTipoModello, int annoMese) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("codi_tipo_emissione", codiTipoEmissione)
				.addValue("cod_tipo_modello", codTipoModello)
				.addValue("anno_mese", annoMese);
		return jdbcTemplate.queryForObject(Constants.sqlControlXmlTotale, parametersOrigineDati, Integer.class);
	}

	public int countDXmlTotalePubblicazione(int idPubblicazione, int annoMese, String codTipoModello, String codiTipoEmissione) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("codi_tipo_emissione", codiTipoEmissione)
				.addValue("id_pubblicazione", idPubblicazione)
				.addValue("cod_tipo_modello", codTipoModello)
				.addValue("anno_mese", annoMese);
		return jdbcTemplate.queryForObject(Constants.sqlControlXmlTotalePubblicazione, parametersOrigineDati, Integer.class);
	}

	public int countDXmlTotaleProvincia(int idPubblicazione, String codiDpt, int numeNumeroCiclo, int annomeseXml, String codiTipoModello,
			String codiTipoEmissione) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("id_pubblicazione", idPubblicazione)
				.addValue("codi_dpt", codiDpt)
				.addValue("nume_numero_ciclo", numeNumeroCiclo)
				.addValue("annomese", annomeseXml)
				.addValue("cod_tipo_modello", codiTipoModello)
				.addValue("codi_tipo_emissione", codiTipoEmissione);
		return jdbcTemplate.queryForObject(Constants.sqlControlXmlTotaleProvincia, parametersOrigineDati, Integer.class);
	}

	public int countDXmlTotaleXEnte(String codiTipoEmissione, String codTipoModello, int annoMese, String codiEnte) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("codi_tipo_emissione", codiTipoEmissione)
				.addValue("cod_tipo_modello", codTipoModello)
				.addValue("anno_mese", annoMese)
				.addValue("codi_ente", codiEnte);
		return jdbcTemplate.queryForObject(Constants.sqlControlXmlTotaleXEnte, parametersOrigineDati, Integer.class);
	}

	public int countDXmlTotaleProvinciaXEnte(String codiEnte, int idPubblicazione, String codiDpt, int numeNumeroCiclo,
			int annomeseXml, String codiTipoEmissione, String codiTipoModello) {
		SqlParameterSource parameters = new MapSqlParameterSource("codi_ente", codiEnte)
				.addValue("id_pubblicazione", idPubblicazione)
				.addValue("codi_dpt", codiDpt)
				.addValue("nume_numero_ciclo", numeNumeroCiclo)
				.addValue("anno_mese", annomeseXml)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("codi_tipo_modello", codiTipoModello);
		return jdbcTemplate.queryForObject(Constants.sqlControlXmlTotaleProvinciaXEnte, parameters, Integer.class);
	}

	// INSERT D_XMLTOTALE
	public void insertDXmlTotale(int annoMese, String codTipoModello, int numCiclo, int codCodiEmissione, int sequIdFileElaborato, String codiTipoEmissione) {
		SqlParameterSource parameters = new MapSqlParameterSource("anno_mese", annoMese)
				.addValue("cod_tipo_modello", codTipoModello)
				.addValue("cod_codice_emissione", codCodiEmissione)
				.addValue("nume_numero_ciclo", numCiclo)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("sequ_id_file_elaborato", sequIdFileElaborato)
				.addValue("row_created_user", "PE_XMLLoaderBatch");
		jdbcTemplate.update(Constants.sqlInsertDXmlTotale, parameters);
	}

	// Controlla se esiste DPT
	public int countDPT(String codiDpt) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("codi_dpt", codiDpt);
		return jdbcTemplate.queryForObject(Constants.sqlControlDPT, parametersOrigineDati, Integer.class);
	}

	// INSERT D_XMLPROVINCIA
	public void insertDXmlProvincia(String nomeFile, String codiDpt, int annoMese, String codTipoModello, int numCiclo,
			int codCodiEmissione, int sequIdFileElaborato, String codiTipoEmissione) {
		SqlParameterSource parameters = new MapSqlParameterSource("id_file_provincia", nomeFile)
				.addValue("codi_dpt", codiDpt)
				.addValue("anno_mese", annoMese)
				.addValue("cod_tipo_modello", codTipoModello)
				.addValue("nume_numero_ciclo", numCiclo)
				.addValue("codi_emissione", codCodiEmissione)
				.addValue("sequ_id_file_elaborato", sequIdFileElaborato)
				.addValue("row_created_user", "PE_XMLLoaderBatch")
				.addValue("codi_tipo_emissione", codiTipoEmissione);
		jdbcTemplate.update(Constants.sqlInsertDXmlProvincia, parameters);
	}

	// Recupero il cf e il nome_cognome dell'utente TRAMITE il cf
	public String returnCognomeNome(String codiceFiscale) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("codice_fiscale", codiceFiscale);
		return jdbcTemplate.queryForObject(Constants.sqlReturnNomeCognome, parametersOrigineDati, String.class);
	}

	public int countCF(String codiceFiscale) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("codice_fiscale", codiceFiscale);
		return jdbcTemplate.queryForObject(Constants.sqlCountCF, parametersOrigineDati, Integer.class);
	}

	// INSERT D_UTENTE
	public void insertDUtente(String codiceFiscale, String cognomeNome, String cognomeXml, String nomeXml, String dataNascita) {
		SqlParameterSource parameters = new MapSqlParameterSource("codice_fiscale", codiceFiscale)
				.addValue("cognome_nome", cognomeNome)
				.addValue("cognome", cognomeXml).addValue("nome", nomeXml)
				.addValue("data_nascita", dataNascita)
				.addValue("row_created_user", "PE_XMLLoaderBatch")
				.addValue("flag_attivo", "N");
		jdbcTemplate.update(Constants.sqlInsertDUtente, parameters);
	}

	// UPDATE D_UTENTE
	public int updateDUtente(String codiceFiscale, String cognomeNome, String cognomeXml, String nomeXml) {
		SqlParameterSource parameters = new MapSqlParameterSource("codice_fiscale", codiceFiscale)
				.addValue("cognome_nome", cognomeNome)
				.addValue("cognome", cognomeXml).addValue("nome", nomeXml)
				.addValue("row_updated_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateDUtente, parameters);
	}

	// S_CEDOLINO_CHECK_ISCRIZIONE_PARTITA_EXISTS
	public int countIscrizione(String partitaStpendiale) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("partita_stipendiale", partitaStpendiale);
		return jdbcTemplate.queryForObject(Constants.sqlCountIscrizione, parametersOrigineDati, Integer.class);
	}

	// INSERT D_PARTITA_STIPENDIALE
	public void insertDPartitaStipendiale(String idPartitaStipend, String cfUtente, String statoPartita) {
		SqlParameterSource parameters = new MapSqlParameterSource("id_partita_stipend", idPartitaStipend)
				.addValue("cf_utente", cfUtente)
				.addValue("stato_partita", statoPartita)
				.addValue("row_created_user", "PE_XMLLoaderBatch");
		jdbcTemplate.update(Constants.sqlInsertDPartitaStipendiale, parameters);
	}

	// S_CEDOLINO_CHECK_ISCRIZIONE_PARTITA_CF_EXISTS
	public int countIscrizioneCF(String partitaStpendiale, String cfUtente) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("id_partita_stipendiale", partitaStpendiale)
				.addValue("cf_utente", cfUtente);
		return jdbcTemplate.queryForObject(Constants.sqlCountIscrizioneCF, parametersOrigineDati, Integer.class);
	}

	// Query : S_PARTITA_STIPENDIALE_CF_X
	public String returnCfIscrizione(String idPartitaStipendiale) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("id_partita_stipendiale", idPartitaStipendiale);
		return jdbcTemplate.queryForObject(Constants.sqlReturnCF_Iscrizione, parametersOrigineDati, String.class);
	}

	// recupero sEqu_id file_elaborato
	public int returnSequIdFileElaborato(String nomeFile) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("nome_file", nomeFile);
		return jdbcTemplate.queryForObject(Constants.sqlReturnSequIdFileElaborato, parametersOrigineDati, Integer.class);
	}

	// INSERT D_HISTORY_CF
	public void insertDHistoryCf(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew)
				.addValue("row_created_user", "PE_XMLLoaderBatch");
		jdbcTemplate.update(Constants.sqlInsertDHistoryCf, parameters);
	}

	// UPDATE D_HISTORY_IBAN
	public int updateDHistoryIban(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew);
		return jdbcTemplate.update(Constants.sqlUpdateDHistoryIban, parameters);
	}

	// UPDATE D_EMAIL_UTENTE
	public int updateDEmailUtente(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew)
				.addValue("row_updated_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateDEmailUtente, parameters);
	}

	// UPDATE D_HISTORY_BONUS_FISCALE
	public int updateDHistoryBonusFiscale(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew);
		return jdbcTemplate.update(Constants.sqlUpdateDHistoryBonusFiscale, parameters);
	}

	public List<DetrazioneFamiliareDocument> getDetrazioneFamiliare(String cfOld) {
		return jdbcTemplate.query(Constants.sqlGetDetrazioneFamiliareByCf, new MapSqlParameterSource("cf_old", cfOld), new DetrazioneFamiliareMapper());
	}

	// INSERT D_DETRAZIONE_FAMILIARE
	public void insertdDetrazioneFamiliare(String persCf, int idProtocollo, int impoRedditoComplessivo, String flagDirittoDetrazione,
			int annomeseDecorrenza, String codiStato, Date dataInvio, int annomeseApplicazione, String esitoAcquisizione,
			String descrEsitoAcquisizione, Date dataAcquisizione, String annoInvio) {
		SqlParameterSource parameters = new MapSqlParameterSource(
				"pers_codice_fiscale", persCf)
				.addValue("id_protocollo", idProtocollo)
				.addValue("impo_reddito_complessivo", impoRedditoComplessivo)
				.addValue("flag_diritto_detrazione", flagDirittoDetrazione)
				.addValue("annomese_decorrenza", annomeseDecorrenza)
				.addValue("codi_stato", codiStato)
				.addValue("data_invio", dataInvio)
				.addValue("annomese_applicazione", annomeseApplicazione)
				//.addValue("id_log_invio", idLogInvio)
				.addValue("esito_acquisizione", esitoAcquisizione)
				.addValue("descrizione_esito_acquisizione", descrEsitoAcquisizione)
				//.addValue("id_esito_elaborazione", idEsitoElaborazione)
				.addValue("row_created_user", "PE_XmlLoaderBatch")
				//.addValue("row_created_dttm", rowCreatedDttm)
				//.addValue("row_updated_user", rowUpdatedUser)
				//.addValue("row_udpated_dttm", rowUpdatedDttm)
				.addValue("data_acquisizione", dataAcquisizione)
				.addValue("anno_invio", annoInvio);
		jdbcTemplate.update(Constants.sqlInsertDDetrazioneFamiliare, parameters);
	}

	// UPDATE D_FAMILIARE_A_CARICO
	public int updateFamiliareACarico(String cfOld, String cfNew, int idProtocolloNew, int idProtocolloOld, String annoInvio) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew)
				.addValue("id_protocollo", idProtocolloNew)
				.addValue("id_protocollo_old", idProtocolloOld)
				.addValue("anno_invio", annoInvio)
				.addValue("row_updated_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateDFamiliareACarico, parameters);
	}

	// UPDATE D_DETRAZIONE_FAMILIARE
	public int deleteDetrazioneFamiliare(String cfOld) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld);
		return jdbcTemplate.update(Constants.sqlDeleteDetrazioneFamiliare, parameters);
	}

	// UPDATE D_PARTITA_STIPENDIALE
	public int updatePartitaStipendiale(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew)
				.addValue("row_updated_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateDPartitaStipendiale, parameters);
	}

	// UPDATE D_730_UPLOAD
	public int updateD730Upload(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew).addValue("row_updated_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdate730Upload, parameters);
	}

	// UPDATE D_730
	public int updateD730(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew)
				.addValue("row_updated_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateD730, parameters);
	}

	// UPDATE D_PPI_ANAGRAFICA_DIPENDENTE
	public int updateDPpiAnagraficaDipendente(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew)
				.addValue("row_updated_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateDPpiAnagraficaDipendente, parameters);
	}

	// UPDATE D_PPI_DATI_PRESTITO_RICHIESTO
	public int updateDPpiDatiPrestitoRichiesto(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew)
				.addValue("row_updated_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateDPpiDatiPrestitoRichiesto, parameters);
	}

	// UPDATE D_PPI_QUINTO_CEDIBILE
	public int updateDPpiQuintoCedibile(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew)
				.addValue("row_updated_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateDPpiQuintoCedibile, parameters);
	}

	// UPDATE D_PPI_STORICO_DATI_PRESTITO
	public int updateDPpiStoricoDatiPrestito(String cfOld, String cfNew) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld)
				.addValue("cf_new", cfNew)
				.addValue("row_updated_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateDPpiStoricoDatiPrestito, parameters);
	}

	// DELETE D_UTENTE_BY_CF
	public int deleteCfOld(String cfOld) {
		SqlParameterSource parameters = new MapSqlParameterSource("cf_old", cfOld);
		return jdbcTemplate.update(Constants.sqlDeleteCfOld, parameters);
	}

	// UPDATE D_PARTITA_STIPENDIALE - stato partita
	public int updatePartitaStipendialeStato(String statoPartita, String idPartita) {
		SqlParameterSource parameters = new MapSqlParameterSource("stato_partita", statoPartita)
				.addValue("row_updated_user", "PE_XMLLoaderBatch")
				.addValue("id_partita_stipend", idPartita);
		return jdbcTemplate.update(Constants.sqlUpdatePartitaStipendialeStato, parameters);
	}

	// DELETE QUINTO CEDIBILE?
	public int deleteQuintoCedibile(String cfOld) {
		SqlParameterSource parameters = new MapSqlParameterSource("codice_fiscale", cfOld);
		return jdbcTemplate.update(Constants.sqlDeleteQuintoCedibile, parameters);
	}

	public int countQuintoCedibile(String cfOld) {
		SqlParameterSource parameters = new MapSqlParameterSource("codice_fiscale", cfOld);
		return jdbcTemplate.update(Constants.sqlCountQuintoCedibile, parameters);
	}

	// INSERT D_CEDOLINO
	public void insertDCedolino(String annoMese, String codiCodiceCedolino, double importoNetto, String nomeFilePDF,
			String codiUfficioServizio, String codiEmissione, int rataEffettiva, int numeroCiclo, String idPartitaStipend,
			String nomeFileXmlprovincia, String barcodeXml, String codiTipoEmissione, String codiEnte, String codiDpt,
			int sequIdCedolino, double quintoCedibile) {
		SqlParameterSource parameters = new MapSqlParameterSource("anno_mese", annoMese)
				.addValue("codi_codice_cedolino", codiCodiceCedolino)
				.addValue("impo_importo_netto", importoNetto)
				.addValue("nome_file_pdf", nomeFilePDF)
				.addValue("codi_ufficio_servizio", codiUfficioServizio)
				.addValue("codi_emissione", codiEmissione)
				.addValue("rata_effettiva", rataEffettiva)
				.addValue("numero_ciclo", numeroCiclo)
				.addValue("id_partita_stipend", idPartitaStipend)
				.addValue("flag_pubblicazione", "S")
				.addValue("nome_file_xmlprovincia", nomeFileXmlprovincia)
				.addValue("flag_storicizzato", "S")
				.addValue("barcode", barcodeXml)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("codi_ente", codiEnte).addValue("codi_dpt", codiDpt)
				.addValue("row_created_user", "PE_XMLLoaderBatch")
				.addValue("sequ_id_cedolino", sequIdCedolino)
				.addValue("flag_pdf_caricato", "S")
				.addValue("quinto_cedibile", quintoCedibile);
		jdbcTemplate.update(Constants.sqlInsertDCedolino, parameters);
	}

	public void insertDCud(int annoReddito, String nomeFilePDF, String idPartitaStipend, String progCud, String codiEnte,
			String codiDpt, String codiUfficioServizio, String nomeFileXmlProvincia, int numeroCiclo, String codiTipoEmissione) {
		SqlParameterSource parameters = new MapSqlParameterSource("anno_reddito", annoReddito)
				.addValue("nome_file_pdf", nomeFilePDF)
				.addValue("id_partita_stipend", idPartitaStipend)
				.addValue("prog_cud", progCud)
				.addValue("codi_ente", codiEnte)
				.addValue("codi_dpt", codiDpt)
				.addValue("codi_ufficio_servizio", codiUfficioServizio)
				.addValue("flag_pubblicazione", "S")
				.addValue("nome_file_xmlprovincia", nomeFileXmlProvincia)
				.addValue("flag_storicizzato", "S")
				.addValue("numero_ciclo", numeroCiclo)
				.addValue("codi_tipo_emissione", codiTipoEmissione);
		jdbcTemplate.update(Constants.sqlInsertDCud, parameters);
	}

	// Restituisce il numero di oggetti contenuti nel file .xml
	public int countNumeroOggetti(String nomeFile) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("nome_file_xmlprovincia", nomeFile);
		return jdbcTemplate.queryForObject(Constants.sqlReturnNumeroOggetti, parametersOrigineDati, Integer.class);
	}

	public int countNumeroOggettiCud(String nomeFile) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("nome_file_xmlprovincia", nomeFile);
		return jdbcTemplate.queryForObject(Constants.sqlReturnNumeroOggettiCud, parametersOrigineDati, Integer.class);
	}

	// Restituisce il numero di utenti contenuti nel file .xml
	public int countNumeroUtenti(String nomeFile) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("nome_file_xmlprovincia", nomeFile);
		return jdbcTemplate.queryForObject(Constants.sqlReturnNumeroUtenti, parametersOrigineDati, Integer.class);
	}

	public int countNumeroUtentiCud(String nomeFile) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("nome_file_xmlprovincia", nomeFile);
		return jdbcTemplate.queryForObject(Constants.sqlReturnNumeroUtentiCud, parametersOrigineDati, Integer.class);
	}

	public int countNumeroUtentiXEnte(String codiEnte, int rata, String codiTipoEmissione, int numeroCiclo, String codiDpt) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("codi_ente", codiEnte)
				.addValue("rata_effettiva", rata)
				.addValue("cod_tipo_emissione", codiTipoEmissione)
				.addValue("numero_ciclo", numeroCiclo)
				.addValue("codi_dpt", codiDpt);
		return jdbcTemplate.queryForObject(Constants.sqlReturnNumeroUtentiXEnte, parametersOrigineDati, Integer.class);
	}

	// Restituisce la somma degli importi netti dei singoli cedolini contenuti nel file .xml
	public Double countNumTotaleModello(int rata, String codiTipoEmissione, int numeroCiclo) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("rata_effettiva", rata)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("numero_ciclo", numeroCiclo);
		return jdbcTemplate.queryForObject(Constants.sqlReturnNumTotaleModello, parametersOrigineDati, Double.class);
	}

	public Double countNumTotaleModelloCud(int rata, String codiTipoEmissione, int numeroCiclo) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("rata_effettiva", rata)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("numero_ciclo", numeroCiclo);
		return jdbcTemplate.queryForObject(Constants.sqlReturnNumTotaleModelloCud, parametersOrigineDati, Double.class);
	}

	public Double countNumTotaleImporti(int annomese, String codTipoModello, String codiTipoemissione) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("anno_mese", annomese)
				.addValue("cod_tipo_modello", codTipoModello)
				.addValue("codi_tipo_emissione", codiTipoemissione);
		return jdbcTemplate.queryForObject(Constants.sqlReturnNumTotaleImporti, parametersOrigineDati, Double.class);
	}

	// Restituisce la numerosit� degli scarti per ciascun file .xml
	public int countNumRecordScarto(String nomeFile) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("nome_file_xmlprovincia", nomeFile);
		return jdbcTemplate.queryForObject(Constants.sqlReturnNumRecordScarto, parametersOrigineDati, Integer.class);
	}

	// UPDATE D_XMLPROVINCIA
	public int updateDXmlProvincia(int numOggetti, int numUtenti, int numScarti, String nomeFile, String codiDpt) {
		SqlParameterSource parameters = new MapSqlParameterSource(
				"nume_numero_oggetti", numOggetti)
				.addValue("nume_numero_utenti", numUtenti)
				.addValue("num_record_scartati", numScarti)
				.addValue("row_updated_user", "PE_XMLLoaderBatch")
				.addValue("id_file_provincia", nomeFile)
				.addValue("codi_dpt", codiDpt);
		return jdbcTemplate.update(Constants.sqlUpdateDXmlProvincia, parameters);
	}

	// UPDATE D_XMLTOTALE
	public int updateDXmlTotale(Double numTotModello, int annoMese, String codTipoModello, String codTipoEmissione) {
		SqlParameterSource parameters = new MapSqlParameterSource("nume_totale_modello", numTotModello)
				.addValue("row_updated_user", "PE_XMLLoaderBatch")
				.addValue("anno_mese", annoMese)
				.addValue("cod_tipo_modello", codTipoModello)
				.addValue("codi_tipo_emissione", codTipoEmissione);
		return jdbcTemplate.update(Constants.sqlUpdateDXmlTotale, parameters);
	}

	// UPDATE D_XMLTOTALEPROVINCIA
	public int updateDXmlTotaleProvincia(int idPubblicazione, String codiDpt, int numeNumeroCiclo, int numeUtentixciclo, int numeTotalemodello,
			int annomeseXml, String codiTipoEmissione, String codiTipoModello) {
		SqlParameterSource parameters = new MapSqlParameterSource("id_pubblicazione", idPubblicazione)
				.addValue("codi_dpt", codiDpt)
				.addValue("nume_numero_ciclo", numeNumeroCiclo)
				.addValue("annomese", annomeseXml)
				.addValue("cod_tipo_modello", codiTipoModello)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("nume_utentixciclo", numeUtentixciclo)
				.addValue("nume_totalexmodello", numeTotalemodello)
				.addValue("row_updated_user", "PE_XMLLoaderBatch");

		return jdbcTemplate.update(Constants.sqlUpdateDXmlTotaleProvincia, parameters);
	}

	// INSERT D_XMLTOTALEXENTE
	public void insertDXmlTotalexEnte(int numxEnte, String codiEnte, int sequIdFileElaborato, int annomeseXml, String codiTipoEmissione,
			String codiTipoModello) {
		SqlParameterSource parameters = new MapSqlParameterSource("nume_numeroxente", numxEnte)
				.addValue("codi_ente", codiEnte)
				.addValue("seq_id_file_elaborato", sequIdFileElaborato)
				.addValue("annomese", annomeseXml)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("codi_tipo_modello", codiTipoModello)
				.addValue("row_created_user", "PE_XMLLoaderBatch");
		jdbcTemplate.update(Constants.sqlInsertDXmlTotalexEnte, parameters);
	}

	// INSERT D_XMLTOTALEPUBBLICAZIONE
	public void insertDXmlTotalePubblicazione(int idPubblicazione, int sequIdFileElaborato, String codiStato, int annomeseXml,
			String codiTipoEmissione, String codiTipoModello) {
		SqlParameterSource parameters = new MapSqlParameterSource("id_pubblicazione", idPubblicazione)
				.addValue("seq_id_file_elaborato", sequIdFileElaborato)
				.addValue("codi_stato", codiStato)
				.addValue("annomese", annomeseXml)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("codi_tipo_modello", codiTipoModello)
				.addValue("row_created_user", "PE_XMLLoaderBatch");
		jdbcTemplate.update(Constants.sqlInsertDXmlTotalePubblicazione, parameters);
	}

	// INSERT D_XMLTOTALEPROVINCIA
	public void insertDXmlTotaleProvincia(int idPubblicazione, String codiDpt, int numeNumeroCiclo, int numeUtentixciclo, int numeTotalemodello,
			int annomeseXml, int sequIdFileElaborato, String codiTipoEmissione, String codiTipoModello) {
		SqlParameterSource parameters = new MapSqlParameterSource(
				"id_pubblicazione", idPubblicazione)
				.addValue("codi_dpt", codiDpt)
				.addValue("nume_numero_ciclo", numeNumeroCiclo)
				.addValue("nume_utentixciclo", numeUtentixciclo)
				.addValue("nume_totalemodello", numeTotalemodello)
				.addValue("annomese", annomeseXml)
				.addValue("seq_id_file_elaborato", sequIdFileElaborato)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("codi_tipo_modello", codiTipoModello)
				.addValue("row_created_user", "PE_XMLLoaderBatch");
		jdbcTemplate.update(Constants.sqlInsertDXmlTotaleProvincia, parameters);
	}

	// INSERT in D_XMLTOTALEPROVINCIAXENTE
	public void insertDXmlTotaleProvinciaxEnte(String codiEnte, int idPubblicazione, String codiDpt, int numeNumeroCiclo,
			int numeNumxente, int sequIdFileElaborato, int annomeseXml, String codiTipoEmissione, String codiTipoModello) {
		SqlParameterSource parameters = new MapSqlParameterSource("codi_ente", codiEnte)
				.addValue("id_pubblicazione", idPubblicazione)
				.addValue("codi_dpt", codiDpt)
				.addValue("nume_numero_ciclo", numeNumeroCiclo)
				.addValue("nume_numxente", numeNumxente)
				.addValue("seq_id_file_elaborato", sequIdFileElaborato)
				.addValue("annomese", annomeseXml)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("codi_tipo_modello", codiTipoModello)
				.addValue("row_created_user", "PE_XMLLoaderBatch");
		jdbcTemplate.update(Constants.sqlInsertDXmlTotaleProvinciaxEnte, parameters);
	}

	// UPDATE D_STORICO_BATCH
	public int updateDStoricoBatch(String nomeBatch) {
		SqlParameterSource parameters = new MapSqlParameterSource("nome_batch", nomeBatch);
		return jdbcTemplate.update(Constants.sqlUpdateDStoricoBatch, parameters);
	}

	// insert STATO_PROCESSO a fine elaborazione
	public void insertStatoProcessoEnd(String idProcesso, Date dtProcesso, String esitoBatch) {
		SqlParameterSource parameters = new MapSqlParameterSource("id_processo", idProcesso)
				.addValue("dt_processo", dtProcesso)
				.addValue("stato", "END").addValue("esito", esitoBatch);
		jdbcTemplate.update(Constants.sqlInsertStatoProcessoEnd, parameters);
	}

	// UPDATE D_ELABORAZIONE_FILE
	public int updateDElaborazioneFile(int esitoElaborazione, int sequIdFileElaborato) {
		SqlParameterSource parameters = new MapSqlParameterSource("esito_elaborazione", esitoElaborazione)
				.addValue("row_updated_user", "PE_XMLLoaderBatch")
				.addValue("seq_id_file_elaborato", sequIdFileElaborato);
		return jdbcTemplate.update(Constants.sqlUpdateDElaborazioneFile, parameters);
	}

	// UPDATE D_ELABORAZIONE_FILE finale
	public int updateDElaborazioneFileEnd(String dimensioneFile, String fileScarto, int sequIdFileElaborato) {
		SqlParameterSource parameters = new MapSqlParameterSource(
				"text_dimensione_file_xml", dimensioneFile)
				.addValue("file_scarto", fileScarto)
				.addValue("row_updated_dttm", "PE_XMLLoaderBatch")
				.addValue("seq_id_file_elaborato", sequIdFileElaborato);
		return jdbcTemplate.update(Constants.sqlUpdateDElaborazioneFile, parameters);
	}

	public List<NumerositaEnteDocument> getNumerositaXEnte(int rata, String codiTipoEmissione, int numeroCiclo, String codiDpt) {
		return jdbcTemplate.query(Constants.sqlReturnNumeroxEnte, new MapSqlParameterSource("rata_effettiva", rata)
				.addValue("cod_tipo_emissione", codiTipoEmissione)
				.addValue("numero_ciclo", numeroCiclo)
				.addValue("codi_dpt", codiDpt),
				new NumerositaEnteMapper());
	}

	public List<NumerositaEnteDocument> getNumerositaXEnteCud(int rata, String codiTipoEmissione, int numeroCiclo, String codiDpt) {
		return jdbcTemplate.query(Constants.sqlReturnNumeroxEnteCud, new MapSqlParameterSource("rata_effettiva", rata)
				.addValue("cod_tipo_emissione", codiTipoEmissione)
				.addValue("numero_ciclo", numeroCiclo)
				.addValue("codi_dpt", codiDpt),
				new NumerositaEnteMapper());
	}

	// MODULO TERMINA ELABORAZIONE
	/* recupero id_file_elaborato */
	public int returnIdFileElaboratoEnd(String nomeFile) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("nome_file", nomeFile);
		return jdbcTemplate.queryForObject(Constants.sqlReturnIdFileElaboratoEnd, parametersOrigineDati, Integer.class);
	}

	/* recupero id_processo */
	public int returnIdProcessoEnd(String nomeFile) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("nome_file", nomeFile);
		return jdbcTemplate.queryForObject(Constants.sqlReturnIdProcessoEnd, parametersOrigineDati, Integer.class);
	}

	/* recupero dt_processo */
	public Date returnDtProcessoEnd(int sequIdProcesso) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource("sequ_id_processo", sequIdProcesso);
		return jdbcTemplate.queryForObject(Constants.sqlReturnDtProcessoEnd, parametersOrigineDati, Date.class);
	}

	// INSERT HISTORY_PROCESSO END
	public void insertHistoryProcessoEnd(String idProcesso, Date dtProcesso, String taskName) {
		SqlParameterSource parameters = new MapSqlParameterSource(
				"id_processo", idProcesso).addValue("dt_processo", dtProcesso)
				.addValue("task_name", taskName);
		jdbcTemplate.update(Constants.sqlInsertHistoryProcesso, parameters);
	}

	// controllo se esiste in db codDpt, codEnte e codUfficioServizio
	public int countDUfficioServizio(String codiEnte, String codiDpt,
			String codiUfficioServizio) {
		SqlParameterSource parametersOrigineDati = new MapSqlParameterSource(
				"codi_ente", codiEnte).addValue("codi_dpt", codiDpt).addValue(
				"codi_ufficio_servizio", codiUfficioServizio);
		return jdbcTemplate.queryForObject(Constants.sqlCountDUffServizio, parametersOrigineDati, Integer.class);
	}

	// UPDATE stato_processo
	public int updateStatoProcesso(String esitoProcesso, String idProcesso, Date dtProcesso) {
		SqlParameterSource parameters = new MapSqlParameterSource("esito", esitoProcesso)
				.addValue("id_processo", idProcesso)
				.addValue("dt_processo", dtProcesso);
		return jdbcTemplate.update(Constants.sqlUpdateStatoProcesso, parameters);
	}

	// UPDATE stato_processo con scarto
	public int updateStatoProcessoScarto(String esitoProcesso, String idProcesso, Date dtProcesso, String fileScarto) {
		SqlParameterSource parameters = new MapSqlParameterSource("esito", esitoProcesso)
				.addValue("id_processo", idProcesso)
				.addValue("file_scarto", fileScarto)
				.addValue("dt_processo", dtProcesso);
		return jdbcTemplate.update(Constants.sqlUpdateStatoProcessoScarto, parameters);
	}

	// UPDATE DElaborazioneFileScarto
	public int updateDElaborazioneFileScarto(int dimensioneFile, int idFileElaborato) {
		SqlParameterSource parameters = new MapSqlParameterSource("sequ_id_file_elaborato", idFileElaborato)
				.addValue("text_dimensione_file", dimensioneFile);
		return jdbcTemplate.update(Constants.sqlUpdateDElaborazioneFileScarto, parameters);
	}

	// UPDATE DXmlTotaleXEnte
	public int updateDXmlTotaleXEnte(int numxEnte, String codiEnte, int annomeseXml, String codiTipoEmissione,
			String codiTipoModello) {
		SqlParameterSource parameters = new MapSqlParameterSource("nume_numeroxente", numxEnte)
				.addValue("codi_ente", codiEnte)
				.addValue("annomese", annomeseXml)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("codi_tipo_modello", codiTipoModello)
				.addValue("row_created_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateDXmlTotalexEnte, parameters);
	}

	public int updateDXmlTotaleProvinciaXEnte(String codiEnte, int idPubblicazione, String codiDpt, int numeNumeroCiclo,
			int numeNumxente, int annomeseXml, String codiTipoEmissione, String codiTipoModello) {
		SqlParameterSource parameters = new MapSqlParameterSource("codi_ente", codiEnte)
				.addValue("id_pubblicazione", idPubblicazione)
				.addValue("codi_dpt", codiDpt)
				.addValue("nume_numero_ciclo", numeNumeroCiclo)
				.addValue("nume_numxente", numeNumxente)
				.addValue("annomese", annomeseXml)
				.addValue("codi_tipo_emissione", codiTipoEmissione)
				.addValue("codi_tipo_modello", codiTipoModello)
				.addValue("row_created_user", "PE_XMLLoaderBatch");
		return jdbcTemplate.update(Constants.sqlUpdateDXmlTotaleProvinciaxEnte, parameters);
	}

}
