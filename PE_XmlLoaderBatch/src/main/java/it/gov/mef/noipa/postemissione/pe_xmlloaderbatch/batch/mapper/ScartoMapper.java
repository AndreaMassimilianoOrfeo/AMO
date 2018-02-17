package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.ScartoDocument;

import org.springframework.jdbc.core.RowMapper;

public class ScartoMapper implements RowMapper<ScartoDocument> {

	//@Override
	public ScartoDocument mapRow(ResultSet rs, int rowNum) throws SQLException {

		ScartoDocument sd = new ScartoDocument(
				rs.getString("ID_PROCESSO"),
				rs.getDate("DT_PROCESSO"),
				rs.getString("NOME_FILE"),
				rs.getInt("COD_ERRORE"),
				rs.getString("DESC_ERRORE"));

		return sd;

	}

}
