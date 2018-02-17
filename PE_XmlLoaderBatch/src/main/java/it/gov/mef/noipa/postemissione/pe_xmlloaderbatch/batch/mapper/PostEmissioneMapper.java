package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.PostEmissioneDocument;

import org.springframework.jdbc.core.RowMapper;

public class PostEmissioneMapper implements RowMapper<PostEmissioneDocument> {

	@Override
	public PostEmissioneDocument mapRow(ResultSet rs, int rowNum) throws SQLException {
		PostEmissioneDocument ped = new PostEmissioneDocument(
				rs.getInt("ID_SOTTOSISTEMA"),
				rs.getString("DESC_SOTTOSISTEMA"),
				rs.getInt("RATA"),
				rs.getInt("PROG_EMISSIONE"),
				rs.getString("COD_EMISSIONE"),
				rs.getDate("DATA_EMISSIONE"),
				false,
				rs.getInt("ID_DOCUMENTO"));
		return ped;
	}

}
