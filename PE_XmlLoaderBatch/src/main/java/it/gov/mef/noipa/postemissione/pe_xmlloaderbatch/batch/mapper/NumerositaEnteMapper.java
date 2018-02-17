package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.NumerositaEnteDocument;

import org.springframework.jdbc.core.RowMapper;

public class NumerositaEnteMapper implements RowMapper<NumerositaEnteDocument> {

	//@Override
	public NumerositaEnteDocument mapRow(ResultSet rs, int rowNum) throws SQLException {

		NumerositaEnteDocument ne = new NumerositaEnteDocument(
				rs.getInt("countEnte"),
				rs.getString("CODI_ENTE"));

		return ne;

	}

}
