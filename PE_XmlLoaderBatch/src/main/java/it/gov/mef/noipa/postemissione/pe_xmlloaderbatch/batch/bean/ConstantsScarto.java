package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean;

public class ConstantsScarto {

	public static final int ERRORE_FILE_GENERICO = 812;
	public static final String ERRORE_FILE_GENERICO_DESC = "Attenzione: Il file non � stato elaborato a causa di un errore generico. ";

	public static final int ERRORE_FILE_XML_INESISTENTE = 100;
	public static final String ERRORE_FILE_XML_INESISTENTE_DESC = "Attenzione: Il file non esiste ";

	public static final int ERRORE_FILE_XML_EMPTY = 103;
	public static final String ERRORE_FILE_XML_EMPTY_DESC = "Attenzione: Il file XML � vuoto ";

	public static final int ERRORE_FILE_PDF_INESISTENTE = 204;
	public static final String ERRORE_FILE_PDF_INESISTENTE_DESC = "Attenzione: Il file PDF non esiste ";

	public static final int ERRORE_FILE_XML_ELABORATO = 207;
	public static final String ERRORE_FILE_XML_ELABORATO_DESC = "Attenzione: Il file risulta gi� elaborato oppure ufficio di servizio non presente";

	public static final int ERRORE_CODICE_ENTE_NON_PRESENTE = 400;
	public static final String ERRORE_CODICE_ENTE_NON_PRESENTE_DESC = "Attenzione: L''associazione codice ente, dpt e codice ufficio di servizio non risulta essere presente nell''anagrafica degli enti.";

	public static final int ERRORE_TIPO_NON_VALIDO = 401;
	public static final String ERRORE_TIPO_NON_VALIDO_DESC = "Attenzione: Il Tipo  Modello Stipendiale non � valido ";

	public static final int ERRORE_TIPO_EMISSIONE_NON_VALIDO = 402;
	public static final String ERRORE_TIPO_EMISSIONE_NON_VALIDO_DESC = "Attenzione: Il tipoEmissione deve essere compreso fra i valori F,A,S,C,7 ";

	public static final int ERRORE_RATA_EMISSIONE_NON_VALIDA = 403;
	public static final String ERRORE_RATA_EMISSIONE_NON_VALIDA_DESC = "Attenzione: La rataEmissione non � valida ";

	public static final int ERRORE_DATA_PUBBLICAZIONE_NON_VALIDA = 404;
	public static final String ERRORE_DATA_PUBBLICAZIONE_NON_VALIDA_DESC = "Attenzione: La data pubblicazione non � valida ";

	public static final int ERRORE_NUM_X_ENTE_VALORE_NON_CONSENTITO = 405;
	public static final String ERRORE_NUM_X_ENTE_VALORE_NON_CONSENTITO_DESC = "Attenzione: NumXEnte non � valido percH� non pu� assumere un valore inferiore a 0. ";

	public static final int ERRORE_PROVINCIA_NON_PRESENTE = 406;
	public static final String ERRORE_PROVINCIA_NON_PRESENTE_DESC = "Attenzione: Il codProv non risulta presente nell' anagrafica delle province. ";

	public static final int ERRORE_CARICAMENTI_TOTALE = 407;
	public static final String ERRORE_CARICAMENTI_TOTALE_DESC = "Attenzione: si � verificato un errore nel caricamento dei totali. ";

	public static final int ERRORE_FILE_XML_NON_ELABORATO = 500;
	public static final String ERRORE_FILE_XML_NON_ELABORATO_DESC = "Attenzione: Il file non � stato elaborato.";

	public static final int ERRORE_UTENTICICLO_VALORE_NON_CONSENTITO = 605;
	public static final String ERRORE_UTENTICICLO_VALORE_NON_CONSENTITO_DESC = "Attenzione: utentiCiclo non � valido perch� non pu� assumere un valore inferiore a 0 ";

	public static final int ERRORE_COD_ENTE_NON_PRESENTE = 615;
	public static final String ERRORE_COD_ENTE_NON_PRESENTE_DESC = "Attenzione: Il codEntePart non esiste ";

	public static final int ERRORE_COD_UFFRESP_NON_PRESENTE = 616;
	public static final String ERRORE_COD_UFFRESP_NON_PRESENTE_DESC = "Attenzione: Il codUffRespPar non esiste. ";

	public static final int ERRORE_COD_UFFSERV_NON_PRESENTE = 617;
	public static final String ERRORE_COD_UFFSERV_NON_PRESENTE_DESC = "Attenzione: Il codUffServPart non esiste";

	public static final int ERRORE_PRGCUD_ESISTENTE = 626;
	public static final String ERRORE_PRGCUD_ESISTENTE_DESC = "Attenzione: prgCUD risulta gi� presente nella tabella dei CUD. ";

	public static final int ERRORE_PRG730_ESISTENTE = 633;
	public static final String ERRORE_PRG730_ESISTENTE_DESC = "Attenzione: prg730 risulta gi� presente nella tabella dei 730. ";

	public static final int ERRORE_NAMING_CONVENTION = 704;
	public static final String ERRORE_NAMING_CONVETION_DESC = "Attenzione: Il file XML non rispetta la naming convention stabilita per i file XML. ";

	public static final int ERRORE_TIPO_PAG = 705;
	public static final String ERRORE_TIPO_PAG_DESC = "Attenzione: La tipologia di pagamento nel documento non � corretta.";

	public static final int ERRORE_PARTITA_STIPENDIALE = 811;
	public static final String ERRORE_PARTITA_STIPENDIALE_DESC = "Attenzione: Aggiornamento partita non riuscito. ";

	public static final int ERRORE_CF_DOPPIO_CAMBIO = 812;
	public static final String ERRORE_CF_DOPPIO_CAMBIO_DESC = "Attenzione: Il CF � gi� stato modificato; ";

	public static final int ERRORE_COD_DPT = 813;
	public static final String ERRORE_COD_DPT_DESC = "Attenzione: All'interno del file esistono pi� codici uffici responsabili. ";

	public static final int ERRORE_INSERT_D_HISTORY_CF = 814;
	public static final String ERRORE_INSERT_D_HISTORY_CF_DESC = "Attenzione: inserimento in D_HISTORY_CF fallito. ";

	public static final int ERRORE_UPDATE_D_HISTORY_IBAN = 815;
	public static final String ERRORE_UPDATE_D_HISTORY_IBAN_DESC = "Attenzione: aggiornamento su D_HISTORY_IBAN fallito. ";

	public static final int ERRORE_UPDATE_D_EMAIL_UTENTE = 816;
	public static final String ERRORE_UPDATE_D_EMAIL_UTENTE_DESC = "Attenzione: aggiornamento su D_EMAIL_UTENTE fallito. ";

	public static final int ERRORE_UPDATE_D_HISTORY_BONUS_FISCALE = 817;
	public static final String ERRORE_UPDATE_D_HISTORY_BONUS_FISCALE_DESC = "Attenzione: aggiornamento su D_HISTORY_BONUS_FISCALE fallito. ";

	public static final int ERRORE_INSERT_D_DETRAZIONE_FAMILIARE = 818;
	public static final String ERRORE_INSERT_D_DETRAZIONE_FAMILIARE_DESC = "Attenzione: inserimento in D_DETRAZIONE_FAMILIARE fallito. ";

	public static final int ERRORE_DELETE_D_DETRAZIONE_FAMILIARE = 819;
	public static final String ERRORE_DELETE_D_DETRAZIONE_FAMILIARE_DESC = "Attenzione: eliminazione D_DETRAZIONE_FAMILIARE fallita. ";

	public static final int ERRORE_UPDATE_D_PARTITA_STIPENDIALE = 820;
	public static final String ERRORE_UPDATE_D_PARTITA_STIPENDIALE_DESC = "Attenzione: aggiornamento su D_PARTITA_STIPENDIALE fallito. ";

	public static final int ERRORE_UPDATE_D_730_UPLOAD = 821;
	public static final String ERRORE_UPDATE_D_730_UPLOAD_DESC = "Attenzione: aggiornamento su D_730_UPLOAD fallito. ";

	public static final int ERRORE_UPDATE_D_730 = 822;
	public static final String ERRORE_UPDATE_D_730_DESC = "Attenzione: aggiornamento su D_730 fallito. ";

	public static final int ERRORE_UPDATE_D_PPI_ANAGRAFICA_DIPENDENTE = 823;
	public static final String ERRORE_UPDATE_D_PPI_ANAGRAFICA_DIPENDENTE_DESC = "Attenzione: aggiornamento su D_PPI_ANAGRAFICA_DIPENDENTE fallito. ";

	public static final int ERRORE_UPDATE_D_PPI_DATI_PRESTITO_RICHIESTO = 824;
	public static final String ERRORE_UPDATE_D_PPI_DATI_PRESTITO_RICHIESTO_DESC = "Attenzione: aggiornamento su D_PPI_DATI_PRESTITO_RICHIESTO fallito. ";

	public static final int ERRORE_UPDATE_D_PPI_QUINTO_CEDIBILE = 825;
	public static final String ERRORE_UPDATE_D_PPI_QUINTO_CEDIBILE_DESC = "Attenzione: aggiornamento su D_PPI_QUINTO_CEDIBILE fallito. ";

	public static final int ERRORE_UPDATE_D_PPI_STORICO_DATI_PRESTITO = 826;
	public static final String ERRORE_UPDATE_D_PPI_STORICO_DATI_PRESTITO_DESC = "Attenzione: aggiornamento su D_PPI_STORICO_DATI_PRESTITO fallito. ";

	public static final int ERRORE_DELETE_D_UTENTE = 827;
	public static final String ERRORE_DELETE_D_UTENTE_DESC = "Attenzione: eliminazione D_UTENTE fallita. ";

	// query di insert
	public static final String sqlInsertScarto = "INSERT INTO SCARTO "
			+ "(ID_PROCESSO, "
			+ "DT_PROCESSO, "
			+ "NOME_FILE, "
			+ "COD_ERRORE, DESC_ERRORE, ROW_CREATED_DTTM)"
			+ "VALUES (:id_processo,:SYSDATE,:nome_file,:cod_errore:desc_errore,SYSDATE)";
	public static final String sqlInsertScartoFileXml = "INSERT INTO SCARTO "
			+ "(ID_PROCESSO, "
			+ "DT_PROCESSO, "
			+ "COD_ERRORE, DESC_ERRORE, ROW_CREATED_DTTM)"
			+ "VALUES (:id_processo,:SYSDATE,NULL,:cod_errore:desc_errore,SYSDATE)";

	// query di select
	public static final String sqlReturnDtProcesso = "SELECT TO_CHAR(SYSDATE, 'DD-Mon-YY HH24:MI:SS')FROM DUAL";
	public static final String sqlGetDetrazioneFamiliareByCf = "SELECT ID_PROTOCOLLO, IMPO_REDDITO_COMPLESSIVO, FLAG_DIRITTO_DETRAZIONE, "
			+ "ANNOMESE_DECORRENZA, CODI_STATO, DATA_INVIO, ANNOMESE_APPLICAZIONE, ID_LOG_INVIO, ESITO_ACQUISIZIONE, "
			+ "DESCRIZIONE_ESITO_ACQUISIZIONE, ID_ESITO_ELABORAZIONE, ROW_CREATED_USER, ROW_CREATED_DTTM, ROW_UPDATED_USER, "
			+ "ROW_UPDATED_DTTM, DATA_ACQUISIZIONE, ANNO_INVIO "
			+ "FROM D_DETRAZIONE_FAMILIARE T WHERE T.PERS_CODICE_FISCALE = : cf_old";

	// query create
	public static final String sqlCreateTableScarto = "create table SCARTO "
			+ "(ID_PROCESSO  VARCHAR2(100), "
			+ "DT_PROCESSO DATE, "
			+ "NOME_FILE_XML VARCHAR2(100), "
			+ "COD_ERRORE  NUMBER, "
			+ "DESC_ERRORE VARCHAR2(4000), "
			+ "NOME_FILE VARCHAR2(100), "
			+ "ROW_CREATED_DTTM DATE)";

	// query update
	public static final String sqlUpdateDUtente = "update d_utente t"
			+ "set t.pers_cognomenome = :cognome_nome, "
			+ "t.pers_cognome = :cognome, "
			+ "t.pers_nome = :nome, "
			+ "t.ROW_UPDATED_USER = :row_updated_user, "
			+ "t.ROW_UPDATED_DTTM = SYSDATE "
			+ "WHERE T.PERS_CODICE_FISCALE = :codice_fiscale ";

}
