package com.cdac.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("carParts3")
public class CarPartsInventoryImpl3 implements CarPartsInventory {

	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		jt.update("INSERT INTO tbl_carpart(part_name, car_model, price, quantity) VALUES(?, ?, ?, ?)", 
				carPart.getPartName(), carPart.getCarModel(), carPart.getPrice(), carPart.getQuantity());
	}

	public List<CarPart> getAvailableParts() {
		class CarPartRowMapper implements RowMapper<CarPart> {
			@Override
			public CarPart mapRow(ResultSet rs, int rowNum) throws SQLException {
				CarPart cp = new CarPart();
				cp.setPartNo(rs.getInt("part_no"));
				cp.setPartName(rs.getString("part_name"));
				cp.setCarModel(rs.getString("car_model"));
				cp.setPrice(rs.getDouble("price"));
				cp.setQuantity(rs.getInt("quantity"));
				return cp;
			}
		}

		JdbcTemplate jt = new JdbcTemplate(dataSource);
		List<CarPart> list = jt.query("SELECT * FROM tbl_carpart", new CarPartRowMapper());
		return list;
	}

	
}
