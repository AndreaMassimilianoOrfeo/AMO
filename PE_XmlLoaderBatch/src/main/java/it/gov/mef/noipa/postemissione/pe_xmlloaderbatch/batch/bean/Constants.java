package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean;

public class Constants {

	public static final int FLUSSO_DATI_DEPCON_CONVERTITO = 11;
	public static final int FLUSSO_DATI_XML_PRESO_IN_CARICO = 20;
	public static final int DOCUMENTI_INOLTRATI_PER_LA_PRODUZIONE_CON_SUCCESSO = 31;
	public static final int ARTEFATTI_PUBBLICATI = 51;
	public static final int DOCUMENTI_PRESI_IN_CARICO = 60;
	public static final int DOCUMENTI_PUBBLICATI_CON_SUCCESSO = 61;
	public static final int KO_DOCUMENTI_INDICIZZATI_NON_INOLTRATI = 903;
	public static final int KO_DOCUMENTI_NON_ARCHIVIATI = 961;

	// QUERY UPDATE POSTEMISSIONE
	public static final String sqlUpdatePostEmissione_stato = "UPDATE POSTEMISSIONE SET STATO_POSTEMISSIONE = :stato_postemissione_new, DATA_AGGIORNAMENTO = sysdate, UTENTE_AGGIORNAMENTO = 'BATCH_XML_LOADER' WHERE ID_POSTEMISSIONE = :id_postemissione AND STATO_POSTEMISSIONE in (:stato_postemissione_orig)";
	public static final String sqlUpdatePostEmissione = "UPDATE POSTEMISSIONE SET STATO_POSTEMISSIONE = :stato_postemissione, DATA_AGGIORNAMENTO = sysdate, UTENTE_AGGIORNAMENTO = 'BATCH_XML_LOADER' WHERE ID_POSTEMISSIONE = :id_postemissione";

	// QUERY UPDATE ORIGINE_DATI
	public static final String sqlUpdateOrigineDati_stato = "UPDATE ORIGINE_DATI SET ID_STATO_ELABORAZIONE_FILE = :id_stato_elaborazione_file_new, DATA_AGGIORNAMENTO = sysdate, UTENTE_AGGIORNAMENTO = 'BATCH_XML_LOADER' WHERE ID_POSTEMISSIONE = :id_postemissione AND NOME_FILE_ORIGINE = :nome_file_originale AND ID_STATO_ELABORAZIONE_FILE in (:id_stato_elaborazione_file_orig)";
	public static final String sqlUpdateOrigineDati = "UPDATE ORIGINE_DATI SET ID_STATO_ELABORAZIONE_FILE = :id_stato_elaborazione_file, DATA_AGGIORNAMENTO = sysdate, UTENTE_AGGIORNAMENTO = 'BATCH_XML_LOADER' WHERE ID_POSTEMISSIONE = :id_postemissione AND NOME_FILE_ORIGINE = :nome_file_origine ";

	// QUERY UPDATE CARICAMENTI_PORTALE
	public static final String sqlUpdateCaricamentiPortale = "update caricamenti_portale  set id_stato_elaborazione_file = :id_stato_elaborazione_file_new,"
			+ " data_aggiornamento = sysdate, "
			+ "utente_aggiornamento = 'PE_XmlLoaderBatch' where  id_origine_dati = :id_origine_dati and id_postemissione = :id_postemissione and"
			+ " id_stato_elaborazione_file = :id_stato_elaborazione_file";
	public static final String sqlUpdateCaricamentiPortaleScarto = "update caricamenti_portale "
			+ "set file_scarto=:file_scarto, "
			+ "id_stato_elaborazione_file=:id_stato_elaborazione_file_new, "
			+ "data_aggiornamento = sysdate, "
			+ "utente_aggiornamento = 'PE_XmlLoaderBatch' "
			+ "where  id_origine_dati = :id_origine_dati "
			+ "and id_postemissione = :id_postemissione "
			+ "and id_stato_elaborazione_file = :id_stato_elaborazione_file";

	// SELECT SU ORIGINE_DATI
	public static final String sqlCountOrigineDati = "SELECT COUNT(*) FROM ORIGINE_DATI WHERE ID_POSTEMISSIONE = :id_postemissione AND NOME_FILE_ORIGINE = :nome_file_originale ";
	public static final String sqlGetPostEmissioneById = "SELECT PP.ID_POSTEMISSIONE, PP.ID_DOCUMENTO, PP.ID_SOTTOSISTEMA, SS.DESC_SOTTOSISTEMA, PP.RATA, PP.PROG_EMISSIONE, PP.COD_EMISSIONE, PP.DATA_EMISSIONE FROM POSTEMISSIONE PP, SOTTOSISTEMI SS WHERE 1=1 AND PP.ID_POSTEMISSIONE = :id_postemissione AND PP.ID_SOTTOSISTEMA = SS.ID_SOTTOSISTEMA";
	public static final String sqlGetCodDescTipoEmissioniByPostEmissione = "select tp.COD_PAGAMENTO AS CODICE, tp.DESC_PAGAMENTO AS DESCRIZIONE from TIPO_PAGAMENTO tp, POSTEMISSIONE pe where tp.ID_SOTTOSISTEMA = pe.ID_SOTTOSISTEMA and pe.ID_POSTEMISSIONE = :id_postemissione";
	public static final String sqlReturnIdSottosistema = "select ID_SOTTOSISTEMA from PE_MONITORAGGIO.sottosistemi where desc_sottosistema=:desc_sottosistema";
	public static final String sqlReturnIdDocumento = "select id_documento from PE_MONITORAGGIO.CATALOGO_DOCUMENTI where UPPER(tipo_documento)=UPPER(:tipo_documento )";
	public static final String sqlReturnIdOrigineDati = "SELECT ID_ORIGINE_DATI FROM ORIGINE_DATI WHERE ID_POSTEMISSIONE = :id_postemissione AND NOME_FILE_ORIGINE = :nome_file_origine AND ID_STATO_ELABORAZIONE_FILE = :id_stato_elaborazione_file";
	public static final String sqlCountIdOrigineDati = "SELECT count(*) FROM ORIGINE_DATI WHERE ID_POSTEMISSIONE = :id_postemissione AND NOME_FILE_ORIGINE = :nome_file_origine AND ID_STATO_ELABORAZIONE_FILE = :id_stato_elaborazione_file";
	public static final String sqlCountPEMonitoraggio = "select count(*) from origine_dati a, postemissione c"
			+ " where"
			+ " a.id_postemissione= c.id_postemissione and"
			+ " a.id_postemissione = :id_postemissione and"
			+ " a.nome_file_origine = :nome_file_origine and"
			+ " c.stato_postemissione = :stato_postemissione and"
			+ " not EXISTS (select 1 from caricamenti_portale b"
			+ " where"
			+ " b.id_origine_dati = a.id_origine_dati and"
			+ " b.id_postemissione = a.id_postemissione and"
			+ " b.id_stato_elaborazione_file in (:stato_elaborazione_file))";
	public static final String sqlGetPostemissioniDisponibili = "SELECT ID_POSTEMISSIONE FROM POSTEMISSIONE WHERE STATO_POSTEMISSIONE = 11 OR STATO_POSTEMISSIONE = 903 ";
	public static final String sqlGetPostemissioniElaborate = "SELECT distinct POSTEMISSIONE.ID_POSTEMISSIONE "
			+ " from "
			+ "   ORIGINE_DATI a, "
			+ "   POSTEMISSIONE "
			+ " WHERE "
			+ "   POSTEMISSIONE.ID_POSTEMISSIONE = a.ID_POSTEMISSIONE AND "
			+ "   POSTEMISSIONE.STATO_POSTEMISSIONE = 51 and "
			+ "   NOT EXISTS ( "
			+ "     SELECT 1  "
			+ "       FROM CARICAMENTI_PORTALE b "
			+ "     WHERE  "
			+ "       b.id_origine_dati = a.id_origine_dati and "
			+ " 			b.id_postemissione = a.id_postemissione and "
			+ " 			b.id_stato_elaborazione_file in (61, 60) "
			+ " 	)";

	// QUERY DI INSERT
	public static final String sqlInsertArtefattiPostEmissione = "INSERT INTO ARTEFATTI_POSTEMISSIONE (ID_POSTEMISSIONE, ID_ARTEFATTO, ID_STATO_ARTEFATTO, RATA, RATA_EFFETTIVA, COD_EMISSIONE, NOME_FILE, DATA_INSERIMENTO, UTENTE_INSERIMENTO) VALUES (:id_postemissione, :id_artefatto, :id_stato_artefatto, :rata, :rata_effettiva, :cod_emissione, :nome_file, SYSDATE, 'PE_XmlLoaderBatch')";
	public static final String sqlInsertCedolini = "INSERT INTO CEDOLINI (ID_POSTEMISSIONE, ID_ARTEFATTO, MATRICOLA, COD_ENTE, COD_SO, COD_UFF) VALUES (:id_postemissione, :id_artefatto, :matricola, :cod_ente, :cod_so, :cod_uff)";
	public static final String sqlInsertDMessaggio = "INSERT INTO D_MESSAGGIO (ID_MESSAGGIO, TITOLO, CATEGORY_TEXT, TYPE, SOURCE, START_DATE, SEQU_MESSAGGIO, ROW_CREATED_USER, ROW_CREATED_DTTM, DESCRIZIONE, CATEGORY_DOMAIN, FLAG_PER_UNO, FLAG_PER_TUTTI, DA_CENTRO, ELIMINATO, MEF, ABILITATO) VALUES (:id_messaggio, :titolo, 'Messaggio', '1', 'PORTALE', TRUNC(SYSDATE), :sequ_messaggio, 'BATCH_XMLLOADER', SYSDATE, :descrizione, 'SPT', 'S', 0, 0, 0, 1, 1)";
	public static final String sqlInsertDMessaggioProfilazione = "INSERT INTO D_MESSAGGIO_PROFILAZIONE (SEQU_MESSAGGIO, NUM_PROFILAZIONE, CF) VALUES (:sequ_messaggio, 0, :cf)";
	public static final String sqlInsertCaricamenti_portale = "Insert into caricamenti_portale (id_caricamenti_portale, id_origine_dati, id_postemissione, id_stato_elaborazione_file, data_inserimento, utente_inserimento) "
			+ "values"
			+ "(SEQ_ID_CARICAMENTI_PORTALE.nextval, :id_origine_dati, :id_postemissione, :id_stato_elaborazione_file, SYSDATE,'BATCH')";

	// SELECT SU U_CEDOLINO
	public static final String sqlCountQuintoCedibile = "select count (*) from D_PPI_QUINTO_CEDIBILE T WHERE T.CODICE_FISCALE_DIPENDENTE = :codice_fiscale ";
	public static final String sqlReturnSequIdFileElaborato = "select nvl(max(sequ_id_file_elaborato),-1) from d_elaborazione_file "
			+ "where"
			+ " nome_file = :nome_file  and"
			+ " esito_elaborazione = 1";
	public static final String sqlReturnCodiDpt = "SELECT A.CODI_DPT FROM D_UFFICIO_RESPONSABILE a WHERE A.COD_DPT_PER=:codi_dpt";
	public static final String sqlReturnDtProcesso = "SELECT SYSTIMESTAMP FROM DUAL";
	public static final String sqlReturnIdProcesso = "SELECT SEQU_ID_PROCESSO.NEXTVAL FROM DUAL";
	public static final String sqlReturnIdFileElaborato = "SELECT SEQU_ID_FILE.NEXTVAL FROM DUAL";
	public static final String sqlReturnSequIdCedolino = "SELECT SEQU_CEDOLINO.nextval FROM DUAL";
	public static final String sqlReturnSequIdProtocollo = "SELECT SEQU_ID_PROTOCOLLO.nextval FROM DUAL";
	public static final String sqlCountStoricoBatch = "SELECT COUNT(*) FROM D_STORICO_BATCH WHERE NOME_BATCH = :nome_batch";
	public static final String sqlReturnIdProcessoHistory = "select max(sequ_id_processo) from processo where id_processo = :id_processo GROUP BY id_processo";
	public static final String sqlReturnDtProcessoHistory = "select dt_processo from processo where sequ_id_processo = :sequ_id_processo";
	public static final String sqlReturnNomeCognome = "SELECT T.PERS_COGNOMENOME from d_utente t WHERE T.PERS_CODICE_FISCALE=:codice_fiscale ";
	public static final String sqlControlXmlTotale = "select count(*) from D_XMLTOTALE where CODI_TIPO_EMISSIONE=:codi_tipo_emissione "
			+ "and COD_TIPO_MODELLO=:cod_tipo_modello "
			+ "and ANNOMESE=:anno_mese ";
	public static final String sqlControlXmlTotaleProvincia = "select count(*) from D_XMLTOTALEXPROVINCIA where CODI_TIPO_EMISSIONE=:codi_tipo_emissione "
			+ "and ID_PUBBLICAZIONE=:id_pubblicazione "
			+ "and CODI_DPT=:codi_dpt "
			+ "and NUME_NUMERO_CICLO=:nume_numero_ciclo "
			+ "and ANNOMESE=:annomese "
			+ "and COD_TIPO_MODELLO=:cod_tipo_modello";
	public static final String sqlControlXmlTotalePubblicazione = "select count(*) from D_XMLTOTALEPUBBLICAZIONE where CODI_TIPO_EMISSIONE=:codi_tipo_emissione "
			+ "and COD_TIPO_MODELLO=:cod_tipo_modello "
			+ "and ID_PUBBLICAZIONE=:id_pubblicazione "
			+ "and ANNOMESE=:anno_mese";
	public static final String sqlControlXmlTotaleXEnte = "select count(*) from D_XMLTOTALEXENTE where CODI_TIPO_EMISSIONE=:codi_tipo_emissione "
			+ "and COD_TIPO_MODELLO=:cod_tipo_modello "
			+ "and ANNOMESE=:anno_mese "
			+ "and codi_ente=:codi_ente";
	public static final String sqlControlXmlTotaleProvinciaXEnte = "select count(*) from D_XMLTOTALEPROVINCIAXENTE where CODI_TIPO_EMISSIONE=:codi_tipo_emissione "
			+ "and COD_TIPO_MODELLO=:codi_tipo_modello "
			+ "and ANNOMESE=:anno_mese "
			+ "and codi_ente=:codi_ente "
			+ "and id_pubblicazione=:id_pubblicazione "
			+ "and NUME_NUMERO_CICLO=:nume_numero_ciclo "
			+ "and CODI_DPT=:codi_dpt";
	public static final String sqlControlDPT = "select count (*) from D_UFFICIO_RESPONSABILE where CODI_DPT=:codi_dpt ";
	public static final String sqlCountCF = "SELECT COUNT (*) FROM D_UTENTE WHERE PERS_CODICE_FISCALE=:codice_fiscale";
	public static final String sqlCountIscrizione = "SELECT COUNT (*) FROM D_PARTITA_STIPENDIALE PART WHERE PART.ID_PARTITA_STIPEND = :partita_stipendiale";
	public static final String sqlCountIscrizioneCF = "SELECT COUNT(*)FROM D_PARTITA_STIPENDIALE PART "
			+ "WHERE PART.ID_PARTITA_STIPEND = :id_partita_stipendiale AND PART.CF_UTENTE = :cf_utente";
	public static final String sqlReturnCF_Iscrizione = "SELECT CF_UTENTE FROM D_PARTITA_STIPENDIALE WHERE ID_PARTITA_STIPEND = :id_partita_stipendiale";
	public static final String sqlGetDetrazioneFamiliareByCf = "SELECT PERS_CODICE_FISCALE, "
			+ "ID_PROTOCOLLO, "
			+ "IMPO_REDDITO_COMPLESSIVO, "
			+ "FLAG_DIRITTO_DETRAZIONE, "
			+ "ANNOMESE_DECORRENZA, "
			+ "CODI_STATO, "
			+ "DATA_INVIO, "
			+ "ANNOMESE_APPLICAZIONE, "
			+ "ID_LOG_INVIO, "
			+ "ESITO_ACQUISIZIONE, "
			+ "DESCRIZIONE_ESITO_ACQUISIZIONE, "
			+ "ID_ESITO_ELABORAZIONE, "
			+ "ROW_CREATED_USER, "
			+ "ROW_CREATED_DTTM, "
			+ "ROW_UPDATED_USER, "
			+ "ROW_UPDATED_DTTM, "
			+ "DATA_ACQUISIZIONE, "
			+ "ANNO_INVIO "
			+ "FROM D_DETRAZIONE_FAMILIARE WHERE PERS_CODICE_FISCALE = :cf_old";
	public static final String sqlReturnNumeroOggetti = "select count(*) from d_cedolino a where a.nome_file_xmlprovincia=:nome_file_xmlprovincia";
	public static final String sqlReturnNumeroOggettiCud = "select count(*) from d_cud a where a.nome_file_xmlprovincia=:nome_file_xmlprovincia";

	public static final String sqlReturnNumeroUtenti = "select count(distinct b.cf_utente) "
			+ "from d_cedolino a, d_partita_stipendiale b"
			+ " where"
			+ " a.id_partita_stipend= b.id_partita_stipend and a.nome_file_xmlprovincia=:nome_file_xmlprovincia";

	public static final String sqlReturnNumeroUtentiCud = "select count(distinct b.cf_utente) "
			+ "from d_cud a, d_partita_stipendiale b"
			+ " where"
			+ " a.id_partita_stipend= b.id_partita_stipend and a.nome_file_xmlprovincia=:nome_file_xmlprovincia";

	public static final String sqlReturnNumeroUtentiXEnte = "select count(distinct b.cf_utente) "
			+ "from d_cedolino a, d_partita_stipendiale b"
			+ " where"
			+ " a.id_partita_stipend= b.id_partita_stipend and rata_effettiva = :rata_effettiva and CODI_DPT = :codi_dpt and CODI_ENTE = :codi_ente AND NUMERO_CICLO=:numero_ciclo AND CODI_TIPO_EMISSIONE=:cod_tipo_emissione";

	public static final String sqlReturnNumTotaleModello = "select count (*) from d_cedolino a"
			+ " where a.rata_effettiva=:rata_effettiva AND a.CODI_TIPO_EMISSIONE=:codi_tipo_emissione AND a.NUMERO_CICLO=:numero_ciclo";

	public static final String sqlReturnNumTotaleModelloCud = "select count (*) from d_cud a"
			+ " where a.ANNO_REDDITO=:rata_effettiva AND a.CODI_TIPO_EMISSIONE=:codi_tipo_emissione AND a.NUMERO_CICLO=:numero_ciclo";

	public static final String sqlReturnNumTotaleImporti = "select sum (a.impo_importo_netto) from d_cedolino a, D_XMLTOTALEXPROVINCIA b, D_ELABORAZIONE_FILE c"
			+ " where a.nome_file_xmlprovincia= c.nome_file and"
			+ " c.sequ_id_file_elaborato = b.seq_id_file_elaborato and"
			+ " b.annomese= :anno_mese and"
			+ " b.cod_tipo_modello = :cod_tipo_modello and"
			+ " b.codi_tipo_emissione = :codi_tipo_emissione";
	public static final String sqlReturnNumRecordScarto = "select count (*) from scarto";

	public static final String sqlReturnNumeroxEnte = "select count(*) as countEnte, a.codi_ente from d_cedolino a"
			+ " where a.rata_effettiva = :rata_effettiva AND a.NUMERO_CICLO=:numero_ciclo AND a.CODI_TIPO_EMISSIONE=:cod_tipo_emissione and CODI_DPT = :codi_dpt GROUP BY a.codi_ente ";

	public static final String sqlReturnNumeroxEnteCud = "select count(*) as countEnte, a.codi_ente from d_cud a"
			+ " where a.anno_reddito = :rata_effettiva AND a.NUMERO_CICLO=:numero_ciclo AND a.CODI_TIPO_EMISSIONE=:cod_tipo_emissione and CODI_DPT = :codi_dpt GROUP BY a.codi_ente GROUP BY a.codi_ente ";

	public static final String sqlReturnIdFileElaboratoEnd = "select nvl(max(sequ_id_file_elaborato),-1) from d_elaborazione_file where"
			+ " nome_file = :nome_file  and esito_elaborazione = 0";
	public static final String sqlReturnIdProcessoEnd = "select max(sequ_id_processo) from processo where id_processo = :nome_file "
			+ "GROUP BY id_processo ";
	public static final String sqlReturnDtProcessoEnd = "select dt_processo from processo where sequ_id_processo = :sequ_id_processo";
	public static final String sqlCountDUffServizio = "select count (*) as count from D_UFFICIO_SERVIZIO where CODI_ENTE=:codi_ente and"
			+ " CODI_DPT=:codi_dpt and CODI_UFFICIO_SERVIZIO= :codi_ufficio_servizio";

	// INSERT SU U_CEDOLINO
	public static final String sqlInsertDStoricoBatch = "INSERT INTO D_STORICO_BATCH (NOME_BATCH, DT_BATCH, HOST, SO, NOME_FILE, TIPO_MODELLO_IN_ELABORAZIONE,  TIPOLOGIA_CARICAMENTO) VALUES(:nome_batch,SYSTIMESTAMP,:host,:so,:nome_file,:tipo_modello_in_elaborazione,:tipologia_caricamento)";
	public static final String sqlInsertProcesso = "INSERT INTO PROCESSO (ID_PROCESSO, ID_PADRE, DT_PROCESSO, DT_PADRE, SEQU_ID_PROCESSO) "
			+ "VALUES (:id_processo,null,:dt_processo,null,:sequ_id_processo)";
	public static final String sqlInsertStatoProcesso = "INSERT INTO STATO_PROCESSO "
			+ "(ID_PROCESSO, DT_INIZIO, DT_FINE, STATO, ESITO, OBJ_STATO, DT_PROCESSO, ERRORE) "
			+ "VALUES (:id_processo,SYSTIMESTAMP,NULL,:stato,:esito,empty_blob(),:dt_processo,empty_clob())";
	public static final String sqlInsertProtocolloCedolino = "INSERT INTO D_PROTOCOLLO_CEDOLINO "
			+ "(SEQU_ID_PROTOCOLLO, CODI_TIPO_RICHIESTA, ROW_CREATED_USER, ROW_CREATED_DTTM, ANNO_INVIO) "
			+ "VALUES (:sequ_id_protocollo,:codi_tipo_richiesta,:row_created_user, sysdate,:anno_invio)";
	public static final String sqlInsertHistoryProcesso = "INSERT INTO HISTORY_PROCESSO "
			+ "(ID_PROCESSO, DT_PROCESSO, TASK_NAME, DT_FINE, DT_INIZIO, DT_TASK, ORDER_EXEC) "
			+ "VALUES (:id_processo,:dt_processo,:task_name, sysdate, sysdate, sysdate, "
			+ "(SELECT NVL(MAX(ORDER_EXEC), 0) + 1 FROM HISTORY_PROCESSO HP WHERE HP.ID_PROCESSO = :id_processo AND HP.DT_PROCESSO = :dt_processo))";
	public static final String sqlInsertHistoryProcessoEnd = "INSERT INTO HISTORY_PROCESSO "
			+ "(ID_PROCESSO, DT_PROCESSO, TASK_NAME, DT_FINE, DT_INIZIO, DT_TASK, ORDER_EXEC) "
			+ "VALUES (:id_processo,:dt_processo,:task_name, sysdate, sysdate, sysdate, "
			+ "(SELECT NVL(MAX(ORDER_EXEC), 0) + 1 FROM HISTORY_PROCESSO HP WHERE HP.ID_PROCESSO = :id_processo AND HP.DT_PROCESSO = :dt_processo))";
	public static final String sqlInsertDElaborazioneFile = "INSERT INTO D_ELABORAZIONE_FILE "
			+ "(SEQU_ID_FILE_ELABORATO, "
			+ "DATA_INZIO_ELABORAZIONE, "
			+ "ESITO_ELABORAZIONE, FILE_SCARTO, DATA_FINE_ELABORAZIONE, TIPO_ELABORAZIONE, ROW_CREATED_DTTM, ROW_UPDATED_DTTM, "
			+ "SEQU_ID_FILE_PADRE, NOME_FILE, TEXT_DIMENSIONE_FILE_XML,ROW_CREATED_USER, ROW_UPDATED_USER)"
			+ "VALUES (:sequ_id_file_elaborato,SYSTIMESTAMP,:esito_elaborazione,empty_blob(),NULL,:tipo_elaborazione,"
			+ "SYSDATE, NULL,NULL,:nome_file,NULL,:row_created_user,NULL)";
	public static final String sqlInsertDXmlTotale = "INSERT INTO D_XMLTOTALE (ANNOMESE, COD_TIPO_MODELLO, NUME_TOTALE_MODELLO, NUME_TOTALE_CICLI, "
			+ "COD_CODICE_EMISSIONE, SEQ_ID_FILE_ELABORATO, ROW_CREATED_USER, ROW_CREATED_DTTM, ROW_UPDATED_DTTM, CODI_TIPO_EMISSIONE)"
			+ "VALUES (:anno_mese, "
			+ ":cod_tipo_modello, "
			+ "0, "
			+ ":nume_numero_ciclo, "
			+ ":cod_codice_emissione, "
			+ ":sequ_id_file_elaborato, "
			+ ":row_created_user, "
			+ "SYSDATE, "
			+ "NULL, "
			+ ":codi_tipo_emissione)";
	public static final String sqlInsertDXmlProvincia = "INSERT INTO D_XMLPROVINCIA (ID_FILE_PROVINCIA, CODI_DPT, ANNOMESE, COD_TIPO_MODELLO, NUME_NUMERO_OGGETTI, "
			+ "NUME_NUMERO_CICLO, CODI_EMISSIONE, NUME_NUMERO_UTENTI, SEQ_ID_FILE_ELABORATO, SEQU_ID_FILE_RICICLO, "
			+ "ROW_CREATED_USER,ROW_CREATED_DTTM, ROW_UPDATED_USER, ROW_UPDATED_DTTM, NUM_RECORD_SCARTATI, CODI_TIPO_EMISSIONE )"
			+ "VALUES (:id_file_provincia, "
			+ ":codi_dpt, "
			+ ":anno_mese, "
			+ ":cod_tipo_modello, "
			+ "0, "
			+ ":nume_numero_ciclo, "
			+ ":codi_emissione, "
			+ "0, "
			+ ":sequ_id_file_elaborato, "
			+ "NULL, "
			+ ":row_created_user, "
			+ "SYSDATE, "
			+ "NULL, "
			+ "NULL, "
			+ "0, "
			+ ":codi_tipo_emissione)";
	public static final String sqlInsertDUtente = "INSERT INTO D_UTENTE ( PERS_CODICE_FISCALE, PERS_COGNOMENOME, PERS_COGNOME,PERS_NOME,"
			+ "DATA_NASCITA, ROW_CREATED_USER, ROW_CREATED_DTTM, FLAG_ATTIVO) "
			+ "VALUES (:codice_fiscale,:cognome_nome,:cognome,:nome,TO_DATE(:data_nascita,'DD/MM/YYYY'),:row_created_user,SYSDATE,:flag_attivo)";
	public static final String sqlInsertDPartitaStipendiale = "INSERT INTO D_PARTITA_STIPENDIALE"
			+ "(ID_PARTITA_STIPEND, "
			+ "CF_UTENTE, "
			+ "STATO_PARTITA, "
			+ "ROW_CREATED_USER, "
			+ "ROW_CREATED_DTTM)"
			+ "VALUES"
			+ "(:id_partita_stipend, "
			+ ":cf_utente, "
			+ ":stato_partita, "
			+ ":row_created_user, "
			+ "SYSDATE)";
	public static final String sqlInsertDHistoryCf = "INSERT INTO D_HISTORY_CF(CF_OLD, CF_NEW, ROW_CREATED_USER, ROW_CREATED_DTTM)"
			+ "VALUES(:cf_old,:cf_new,:row_created_user,SYSDATE)";
	public static final String sqlInsertDCedolino = "INSERT INTO D_CEDOLINO(ANNOMESE,"
			+ "CODI_CODICE_CEDOLINO,"
			+ "IMPO_IMPORTO_NETTO,"
			+ "NOME_FILE_PDF,"
			+ "ROW_CREATED_DTTM,"
			+ "CODI_UFFICIO_SERVIZIO,"
			+ "CODI_EMISSIONE,"
			+ "RATA_EFFETTIVA,"
			+ "NUMERO_CICLO,"
			+ "ID_PARTITA_STIPEND,"
			+ "FLAG_PUBBLICAZIONE,"
			+ "NOME_FILE_XMLPROVINCIA,"
			+ "FLAG_STORICIZZATO,"
			+ "BARCODE,"
			+ "TEXT_DIMENSIONE_FILE,"
			+ "CODI_TIPO_EMISSIONE,"
			+ "CODI_ENTE,"
			+ "CODI_DPT,"
			+ "ROW_CREATED_USER,"
			+ "SEQU_ID_CEDOLINO,"
			+ "FLAG_PDF_CARICATO,"
			+ "IMPORTO_V_CEDIBILE)"
			+ "VALUES(:anno_mese, "
			+ ":codi_codice_cedolino, "
			+ ":impo_importo_netto, "
			+ ":nome_file_pdf, "
			+ "SYSDATE, "
			+ ":codi_ufficio_servizio, "
			+ ":codi_emissione, "
			+ ":rata_effettiva, "
			+ ":numero_ciclo, "
			+ ":id_partita_stipend,"
			+ ":flag_pubblicazione, "
			+ ":nome_file_xmlprovincia,"
			+ ":flag_storicizzato, "
			+ ":barcode, "
			+ "0, "
			+ ":codi_tipo_emissione, "
			+ ":codi_ente, "
			+ ":codi_dpt, "
			+ ":row_created_user, "
			+ ":sequ_id_cedolino, "
			+ ":flag_pdf_caricato, "
			+ ":quinto_cedibile)";
	public static final String sqlInsertDCud = "INSERT INTO D_CUD"
			+ "(ANNO_REDDITO,"
			+ "NOME_FILE_PDF,"
			+ "ROW_CREATED_DTTM,"
			+ "ID_PARTITA_STIPEND,"
			+ "PROG_CUD,"
			+ "CODI_ENTE,"
			+ "CODI_DPT,"
			+ "CODI_UFFICIO_SERVIZIO,"
			+ "FLAG_PUBBLICAZIONE,"
			+ "NOME_FILE_XMLPROVINCIA,"
			+ "FLAG_STORICIZZATO,"
			+ "TEXT_DIMENSIONE_FILE,"
			+ "NUMERO_CICLO,"
			+ "CODI_TIPO_EMISSIONE)"
			+ "VALUES"
			+ "(:anno_reddito, "
			+ ":nome_file_pdf, "
			+ "SYSDATE, "
			+ ":id_partita_stipend, "
			+ ":prog_cud, "
			+ ":codi_ente, "
			+ ":codi_dpt, "
			+ ":codi_ufficio_servizio, "
			+ ":flag_pubblicazione, "
			+ ":nome_file_xmlprovincia, "
			+ ":flag_storicizzato, "
			+ "0 "
			+ ":numero_ciclo "
			+ ":codi_tipo_emissione)";
	public static final String sqlInsertDDetrazioneFamiliare = "INSERT INTO D_DETRAZIONE_FAMILIARE"
			+ "(PERS_CODICE_FISCALE,"
			+ "ID_PROTOCOLLO,"
			+ "IMPO_REDDITO_COMPLESSIVO,"
			+ "FLAG_DIRITTO_DETRAZIONE,"
			+ "ANNOMESE_DECORRENZA,"
			+ "CODI_STATO,"
			+ "DATA_INVIO,"
			+ "ANNOMESE_APPLICAZIONE,"
			+ "ID_LOG_INVIO,"
			+ "ESITO_ACQUISIZIONE,"
			+ "DESCRIZIONE_ESITO_ACQUISIZIONE,"
			+ "ID_ESITO_ELABORAZIONE,"
			+ "ROW_CREATED_USER,"
			+ "ROW_CREATED_DTTM,"
			+ "DATA_ACQUISIZIONE,"
			+ "ANNO_INVIO)"
			+ "VALUES"
			+ "(:pers_codice_fiscale, "
			+ ":id_protocollo, "
			+ ":impo_reddito_complessivo, "
			+ ":flag_diritto_detrazione, "
			+ ":annomese_decorrenza, "
			+ ":codi_stato, "
			+ ":data_invio, "
			+ ":annomese_applicazione, "
			+ "NULL, "
			+ ":esito_acquisizione, "
			+ ":descrizione_esito_acquisizione, "
			+ "NULL, "
			+ ":row_created_user, "
			+ "sysdate, "
			+ ":data_acquisizione, "
			+ ":anno_invio)";
	public static final String sqlInsertDXmlTotalexEnte = "INSERT INTO D_XMLTOTALEXENTE"
			+ "(NUME_NUMEROXENTE,"
			+ "CODI_ENTE,"
			+ "SEQ_ID_FILE_ELABORATO,"
			+ "ANNOMESE,"
			+ "CODI_TIPO_EMISSIONE,"
			+ "COD_TIPO_MODELLO,"
			+ "ROW_CREATED_USER,"
			+ "ROW_CREATED_DTTM)"
			+ "VALUES"
			+ "(:nume_numeroxente, "
			+ ":codi_ente, "
			+ ":seq_id_file_elaborato, "
			+ ":annomese, "
			+ ":codi_tipo_emissione, "
			+ ":codi_tipo_modello, "
			+ ":row_created_user, "
			+ "SYSDATE)";
	public static final String sqlInsertDXmlTotalePubblicazione = "INSERT INTO D_XMLTOTALEPUBBLICAZIONE"
			+ "(ID_PUBBLICAZIONE,"
			+ "DATA_PUBBLICAZIONE,"
			+ "SEQ_ID_FILE_ELABORATO,"
			+ "CODI_STATO,"
			+ "DATA_PUBBLICAZIONE_EFFETTIVA,"
			+ "ANNOMESE,"
			+ "CODI_TIPO_EMISSIONE,"
			+ "COD_TIPO_MODELLO,"
			+ "ROW_CREATED_USER,"
			+ "ROW_CREATED_DTTM)"
			+ "VALUES"
			+ "(:id_pubblicazione, "
			+ "TRUNC(SYSDATE), "
			+ ":seq_id_file_elaborato, "
			+ ":codi_stato, "
			+ "NULL, "
			+ ":annomese, "
			+ ":codi_tipo_emissione, "
			+ ":codi_tipo_modello, "
			+ ":row_created_user, "
			+ "SYSDATE)";
	public static final String sqlInsertDXmlTotaleProvincia = "INSERT INTO D_XMLTOTALEXPROVINCIA"
			+ "(ID_PUBBLICAZIONE,"
			+ "CODI_DPT,"
			+ "NUME_NUMERO_CICLO,"
			+ "NUME_UTENTIXCICLO,"
			+ "NUME_TOTALEXMODELLO,"
			+ "SEQ_ID_FILE_ELABORATO,"
			+ "ANNOMESE,"
			+ "CODI_TIPO_EMISSIONE,"
			+ "COD_TIPO_MODELLO,"
			+ "ROW_CREATED_USER,"
			+ "ROW_CREATED_DTTM)"
			+ "VALUES"
			+ "(:id_pubblicazione, "
			+ ":codi_dpt, "
			+ ":nume_numero_ciclo, "
			+ ":nume_utentixciclo, "
			+ ":nume_totalemodello, "
			+ ":seq_id_file_elaborato, "
			+ ":annomese, "
			+ ":codi_tipo_emissione, "
			+ ":codi_tipo_modello, "
			+ ":row_created_user, "
			+ "SYSDATE)";
	public static final String sqlInsertDXmlTotaleProvinciaxEnte = "INSERT INTO D_XMLTOTALEPROVINCIAXENTE"
			+ "(CODI_ENTE,"
			+ "ID_PUBBLICAZIONE,"
			+ "CODI_DPT,"
			+ "NUME_NUMERO_CICLO,"
			+ "NUME_NUMXENTE,"
			+ "SEQ_ID_FILE_ELABORATO,"
			+ "ANNOMESE,"
			+ "CODI_TIPO_EMISSIONE,"
			+ "COD_TIPO_MODELLO,"
			+ "ROW_CREATED_USER,"
			+ "ROW_CREATED_DTTM)"
			+ "VALUES"
			+ "(:codi_ente, "
			+ ":id_pubblicazione, "
			+ ":codi_dpt, "
			+ ":nume_numero_ciclo, "
			+ ":nume_numxente, "
			+ ":seq_id_file_elaborato, "
			+ ":annomese, "
			+ ":codi_tipo_emissione, "
			+ ":codi_tipo_modello, "
			+ ":row_created_user, "
			+ "SYSDATE)";
	public static final String sqlInsertStatoProcessoEnd = "INSERT INTO STATO_PROCESSO "
			+ "(ID_PROCESSO, DT_PROCESSO, DT_INIZIO, DT_FINE, STATO, ESITO, OBJ_STATO, ERRORE) "
			+ "VALUES (:id_processo,:dt_processo, SYSDATE,NULL,:stato,:esito,empty_blob(),empty_clob())";

	// QUERY DI UPDATE SU U_CEDOLINO
	public static final String sqlUpdateDXmlTotalexEnte = "update D_XMLTOTALEXENTE set "
			+ "NUME_NUMEROXENTE =:nume_numeroxente,"
			+ "ROW_UPDATED_USER =:row_created_user,"
			+ "ROW_UPDATED_DTTM =SYSDATE "
			+ "where "
			+ "CODI_ENTE=:codi_ente and "
			+ "ANNOMESE =:annomese and "
			+ "CODI_TIPO_EMISSIONE=:codi_tipo_emissione and "
			+ "COD_TIPO_MODELLO=:codi_tipo_modello";
	public static final String sqlUpdateDXmlTotaleProvinciaxEnte = "update D_XMLTOTALEPROVINCIAXENTE set "
			+ "NUME_NUMXENTE =:nume_numxente,"
			+ "ROW_UPDATED_USER =:row_created_user,"
			+ "ROW_UPDATED_DTTM =SYSDATE "
			+ "where "
			+ "CODI_ENTE=:codi_ente and "
			+ "ANNOMESE =:annomese and "
			+ "CODI_TIPO_EMISSIONE= :codi_tipo_emissione and "
			+ "COD_TIPO_MODELLO= :codi_tipo_modello and "
			+ "ID_PUBBLICAZIONE=:id_pubblicazione and "
			+ "CODI_DPT =:codi_dpt and "
			+ "NUME_NUMERO_CICLO= :nume_numero_ciclo";
	public static final String sqlUpdateDUtente = "update d_utente t"
			+ " set t.pers_cognomenome = :cognome_nome, "
			+ "t.pers_cognome = :cognome, "
			+ "t.pers_nome = :nome, "
			+ "t.ROW_UPDATED_USER = :row_updated_user, "
			+ "t.ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE T.PERS_CODICE_FISCALE = :codice_fiscale ";
	public static final String sqlUpdateDHistoryIban = "UPDATE D_HISTORY_IBAN SET CODICE_FISCALE_DIPENDENTE = :cf_new WHERE CODICE_FISCALE_DIPENDENTE = :cf_old";
	public static final String sqlUpdateDEmailUtente = "UPDATE D_EMAIL_UTENTE"
			+ " SET PERS_CODICE_FISCALE = :cf_new, "
			+ "ROW_UPDATED_USER = :row_updated_user, "
			+ "ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE PERS_CODICE_FISCALE = :cf_old ";
	public static final String sqlUpdateDHistoryBonusFiscale = "UPDATE D_HISTORY_BONUS_FISCALE SET CODICE_FISCALE_DIPENDENTE = :cf_new WHERE CODICE_FISCALE_DIPENDENTE = :cf_old";
	public static final String sqlUpdateDFamiliareACarico = "UPDATE D_FAMILIARE_A_CARICO T SET T.PERS_CODICE_FISCALE = :cf_new,"
			+ " T.ID_PROTOCOLLO = :id_protocollo, "
			+ " T.ANNO_INVIO = :anno_invio, "
			+ " T.ROW_UPDATED_USER = :row_updated_user, "
			+ "T.ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE T.PERS_CODICE_FISCALE = :cf_old and "
			+ "T.ANNO_INVIO = :anno_invio and "
			+ "T.ID_PROTOCOLLO = :id_protocollo_old";
	public static final String sqlUpdateDPartitaStipendiale = "UPDATE D_PARTITA_STIPENDIALE SET CF_UTENTE = :cf_new, "
			+ "ROW_UPDATED_USER = :row_updated_user, "
			+ "ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE CF_UTENTE = :cf_old ";
	public static final String sqlUpdate730Upload = "UPDATE D_730_UPLOAD SET CF_UTENTE = :cf_new, "
			+ "ROW_UPDATED_USER = :row_updated_user, "
			+ "ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE CF_UTENTE = :cf_old ";
	public static final String sqlUpdateD730 = "UPDATE D_730 SET CF_UTENTE = :cf_new, "
			+ "ROW_UPDATED_USER = :row_updated_user, "
			+ "ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE CF_UTENTE = :cf_old ";
	public static final String sqlUpdateDPpiAnagraficaDipendente = "UPDATE D_PPI_ANAGRAFICA_DIPENDENTE SET CODICE_FISCALE_DIPENDENTE = :cf_new, "
			+ "ROW_UPDATED_USER = :row_updated_user, "
			+ "ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE CODICE_FISCALE_DIPENDENTE = :cf_old ";
	public static final String sqlUpdateDPpiDatiPrestitoRichiesto = "UPDATE D_PPI_DATI_PRESTITO_RICHIESTO SET CF_RICHIEDENTE = :cf_new, "
			+ "ROW_UPDATED_USER = :row_updated_user, "
			+ "ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE CF_RICHIEDENTE = :cf_old ";
	public static final String sqlUpdateDPpiQuintoCedibile = "UPDATE D_PPI_QUINTO_CEDIBILE SET CODICE_FISCALE_DIPENDENTE = :cf_new, "
			+ "ROW_UPDATED_USER = :row_updated_user, "
			+ "ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE CODICE_FISCALE_DIPENDENTE = :cf_old ";
	public static final String sqlUpdateDPpiStoricoDatiPrestito = "UPDATE D_PPI_STORICO_DATI_PRESTITO SET CF_RICHIEDENTE = :cf_new, "
			+ "ROW_UPDATED_USER = :row_updated_user, "
			+ "ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE CF_RICHIEDENTE = :cf_old ";
	public static final String sqlUpdateStatoProcesso = "update STATO_PROCESSO set dt_fine= SYSTIMESTAMP, STATO='END', esito= :esito"
			+ " where id_processo = :id_processo and dt_processo = :dt_processo and dt_fine is null";
	public static final String sqlUpdateStatoProcessoScarto = "update STATO_PROCESSO set dt_fine = SYSTIMESTAMP, STATO = 'END', esito = :esito, errore=:file_scarto "
			+ " where id_processo = :id_processo and dt_processo = :dt_processo and dt_fine is null";
	public static final String sqlUpdatePartitaStipendialeStato = "UPDATE D_PARTITA_STIPENDIALE SET STATO_PARTITA = :stato_partita, ROW_UPDATED_USER = :row_updated_user, ROW_UPDATED_DTTM = SYSDATE WHERE ID_PARTITA_STIPEND = :id_partita_stipend";
	public static final String sqlUpdateDXmlProvincia = "UPDATE D_XMLPROVINCIA set NUME_NUMERO_OGGETTI= :nume_numero_oggetti, NUME_NUMERO_UTENTI = :nume_numero_utenti, NUM_RECORD_SCARTATI = :num_record_scartati, ROW_UPDATED_USER=:row_updated_user, ROW_UPDATED_DTTM=SYSDATE where ID_FILE_PROVINCIA= :id_file_provincia and CODI_DPT =:codi_dpt";
	public static final String sqlUpdateDXmlTotale = "UPDATE D_XMLTOTALE set NUME_TOTALE_MODELLO = :nume_totale_modello, "
			+ "ROW_UPDATED_USER=:row_updated_user, "
			+ "ROW_UPDATED_DTTM=SYSDATE "
			+ "where ANNOMESE = :anno_mese and "
			+ "COD_TIPO_MODELLO = cod_tipo_modello AND "
			+ "CODI_TIPO_EMISSIONE=:codi_tipo_emissione";
	public static final String sqlUpdateDXmlTotaleProvincia = "UPDATE D_XMLTOTALEXPROVINCIA set NUME_TOTALEXMODELLO = :nume_totalexmodello, "
			+ "NUME_UTENTIXCICLO =:nume_utentixciclo, "
			+ "ROW_UPDATED_USER=:row_updated_user, "
			+ "ROW_UPDATED_DTTM=SYSDATE "
			+ "where ANNOMESE =:annomese and "
			+ "CODI_DPT =:codi_dpt AND "
			+ "NUME_NUMERO_CICLO =:nume_numero_ciclo AND "
			+ "ID_PUBBLICAZIONE =:id_pubblicazione AND "
			+ "COD_TIPO_MODELLO =:cod_tipo_modello AND "
			+ "CODI_TIPO_EMISSIONE=:codi_tipo_emissione";
	public static final String sqlUpdateDStoricoBatch = "UPDATE D_STORICO_BATCH BATCH set DT_FINE = SYSTIMESTAMP where BATCH.NOME_FILE = :nome_batch AND BATCH.DT_FINE IS NULL ";
	public static final String sqlUpdateDElaborazioneFile = "UPDATE D_ELABORAZIONE_FILE set ESITO_ELABORAZIONE = :esito_elaborazione, DATA_FINE_ELABORAZIONE = SYSDATE, ROW_UPDATED_DTTM = SYSDATE, ROW_UPDATED_USER = :row_updated_user where SEQU_ID_FILE_ELABORATO = :seq_id_file_elaborato";
	public static final String sqlUpdateDElaborazioneFileScarto = "UPDATE D_ELABORAZIONE_FILE set TEXT_DIMENSIONE_FILE_XML = :text_dimensione_file, ROW_UPDATED_DTTM = 'BATCH', ROW_UPDATED_USER = SYSDATE where SEQU_ID_FILE_ELABORATO = :sequ_id_file_elaborato";

	// QUERY DI CRATE SU U_CEDOLINO
	public static final String sqlCreateTableScarto = "create table :nome_tabella "
			+ "(ID_PROCESSO  VARCHAR2(100), "
			+ "DT_PROCESSO DATE, "
			+ "NOME_FILE_XML VARCHAR2(100), "
			+ "COD_ERRORE  NUMBER, "
			+ "DESC_ERRORE VARCHAR2(4000), "
			+ "NOME_FILE VARCHAR2(100), "
			+ "ROW_CREATED_DTTM DATE)";

	// query di delete
	public static final String sqlDeleteDetrazioneFamiliare = "DELETE FROM D_DETRAZIONE_FAMILIARE T WHERE T.PERS_CODICE_FISCALE = :cf_old";
	public static final String sqlDeleteCfOld = "DELETE FROM D_UTENTE WHERE PERS_CODICE_FISCALE = :cf_old ";
	public static final String sqlDeleteQuintoCedibile = "DELETE D_PPI_QUINTO_CEDIBILE T WHERE T.CODICE_FISCALE_DIPENDENTE = :codice_fiscale ";
	public static final String sqlDeleteScarto = "drop table SCARTO purge";
}
