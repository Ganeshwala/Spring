package com.SpringJDBC_ORM.PracticesJDBC_ORM.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<ProductEntity> {

	@Override
	public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductEntity pe = new ProductEntity();
		pe.setId(rs.getInt(1));
		pe.setName(rs.getString(2));
		pe.setDescrp(rs.getString(3));
		pe.setPrice(rs.getDouble(4));
		return pe;
	}

}
