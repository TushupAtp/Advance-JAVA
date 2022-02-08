package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("carParts1")
public class CarPartsInventoryImpl1 implements CarPartsInventory {

	public void addNewPart(CarPart carPart) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			stmt = conn.prepareStatement("INSERT INTO tbl_carpart(part_name, car_model, price, quantity) VALUES(?, ?, ?, ?)");
			stmt.setString(1, carPart.getPartName());
			stmt.setString(2, carPart.getCarModel());
			stmt.setDouble(3, carPart.getPrice());
			stmt.setInt(4, carPart.getQuantity());
			stmt.executeUpdate(); //DML
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //rather we should throw some user defined exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	public List<CarPart> getAvailableParts() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			stmt = conn.prepareStatement("SELECT * FROM tbl_carpart");
			rs = stmt.executeQuery();
			
			List<CarPart> list = new ArrayList<>();
			while(rs.next()) {
				CarPart cp = new CarPart();
				cp.setPartNo(rs.getInt("part_no"));
				cp.setPartName(rs.getString("part_name"));
				cp.setCarModel(rs.getString("car_model"));
				cp.setPrice(rs.getDouble("price"));
				cp.setQuantity(rs.getInt("quantity"));
				list.add(cp);
			}
			return list;
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null; //bad -> rather throw exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}

	
}
