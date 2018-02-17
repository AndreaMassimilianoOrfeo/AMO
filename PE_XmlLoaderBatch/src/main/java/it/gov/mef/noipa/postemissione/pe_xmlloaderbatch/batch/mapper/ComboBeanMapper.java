package it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.gov.mef.noipa.postemissione.pe_xmlloaderbatch.batch.bean.ComboBean;

import org.springframework.jdbc.core.RowMapper;

public class ComboBeanMapper implements RowMapper<ComboBean> {

	@Override
	public ComboBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ComboBean(
				rs.getString("CODICE"),
				rs.getString("DESCRIZIONE"));
	}

}
