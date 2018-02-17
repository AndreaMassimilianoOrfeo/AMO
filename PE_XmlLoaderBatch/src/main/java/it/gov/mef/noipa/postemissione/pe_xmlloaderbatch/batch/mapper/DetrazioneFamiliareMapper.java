package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.DetrazioneFamiliareDocument;

import org.springframework.jdbc.core.RowMapper;

public class DetrazioneFamiliareMapper implements RowMapper<DetrazioneFamiliareDocument> {

	//@Override
	public DetrazioneFamiliareDocument mapRow(ResultSet rs, int rowNum) throws SQLException {

		DetrazioneFamiliareDocument dfd = new DetrazioneFamiliareDocument(
				rs.getString("PERS_CODICE_FISCALE"),
				rs.getInt("ID_PROTOCOLLO"),
				rs.getInt("IMPO_REDDITO_COMPLESSIVO"),
				rs.getString("FLAG_DIRITTO_DETRAZIONE"),
				rs.getInt("ANNOMESE_DECORRENZA"),
				rs.getString("CODI_STATO"),
				rs.getDate("DATA_INVIO"),
				rs.getInt("ANNOMESE_APPLICAZIONE"),
				rs.getInt("ID_LOG_INVIO"),
				rs.getString("ESITO_ACQUISIZIONE"),
				rs.getString("DESCRIZIONE_ESITO_ACQUISIZIONE"),
				rs.getInt("ID_ESITO_ELABORAZIONE"),
				rs.getString("ROW_CREATED_USER"),
				rs.getDate("ROW_CREATED_DTTM"),
				rs.getString("ROW_UPDATED_USER"),
				rs.getDate("ROW_UPDATED_DTTM"),
				rs.getDate("DATA_ACQUISIZIONE"),
				rs.getString("ANNO_INVIO"));

		return dfd;

	}

}
