package it.gov.mef.noipa.postemissione.pe_depconconverterbatch.bean;

public class Constants {
	
	public static final int FLUSSO_DATI_DEPCON_PRESO_IN_CARICO = 10;
	public static final int FLUSSO_DATI_DEPCON_CONVERTITO = 11;
	public static final int KO_FLUSSO_DATI_DEPCON_NON_CONVERTITO = 911;

	public static final String sqlInsertPostEmissione = "INSERT INTO POSTEMISSIONE (ID_POSTEMISSIONE, ID_SOTTOSISTEMA, RATA, ID_DOCUMENTO, PROG_EMISSIONE, DATA_EMISSIONE, STATO_POSTEMISSIONE, DATA_INSERIMENTO, UTENTE_INSERIMENTO) VALUES (:id_postemissione, 1, :rata, :id_documento, :prog_emissione, SYSDATE, :stato_postemissione, SYSDATE, 'BATCH_DEPCON_CONVERTER')";
	public static final String sqlInsertOrigineDati = "INSERT INTO ORIGINE_DATI (ID_POSTEMISSIONE, ID_ORIGINE_DATI, NOME_FILE_ORIGINE, ID_STATO_ELABORAZIONE_FILE, TOT_DOCUMENTI, TOT_NETTO, DATA_INSERIMENTO, DATA_AGGIORNAMENTO, UTENTE_INSERIMENTO, UTENTE_AGGIORNAMENTO) VALUES (:id_postemissione, :id_origine_dati, :nome_file_origine, :id_stato_elaborazione_file, 0, 0, SYSDATE, SYSDATE, 'BATCH_DEPCON_CONVERTER', 'BATCH_DEPCON_CONVERTER')";
	public static final String sqlUpdateOrigineDati = "UPDATE ORIGINE_DATI SET TOT_DOCUMENTI = :tot_documenti, TOT_NETTO = :tot_netto, ID_STATO_ELABORAZIONE_FILE = :id_stato_elaborazione_file, DATA_AGGIORNAMENTO = sysdate, UTENTE_AGGIORNAMENTO = 'BATCH_DEPCON_CONVERTER' WHERE ID_POSTEMISSIONE = :id_postemissione AND  ID_ORIGINE_DATI = :id_origine_dati";
	public static final String sqlUpdatePostEmissione = "UPDATE POSTEMISSIONE SET STATO_POSTEMISSIONE = :stato_postemissione, DATA_AGGIORNAMENTO = sysdate, UTENTE_AGGIORNAMENTO = 'BATCH_DEPCON_CONVERTER' WHERE ID_POSTEMISSIONE = :id_postemissione";
	public static final String sqlUpdateOrigineDati_stato = "UPDATE ORIGINE_DATI SET ID_STATO_ELABORAZIONE_FILE = :id_stato_elaborazione_file, DATA_AGGIORNAMENTO = sysdate, UTENTE_AGGIORNAMENTO = 'BATCH_DEPCON_CONVERTER' WHERE ID_POSTEMISSIONE = :id_postemissione AND  ID_ORIGINE_DATI = :id_origine_dati";
}
