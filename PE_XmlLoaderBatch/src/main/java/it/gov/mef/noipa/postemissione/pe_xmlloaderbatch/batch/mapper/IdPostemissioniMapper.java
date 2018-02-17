package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IdPostemissioniMapper implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getString("ID_POSTEMISSIONE");
	}

}
