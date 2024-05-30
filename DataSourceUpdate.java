package com.mt.arel.jdbc.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

public class DataSourceUpdate {

	
	public static void duzenleBaslik(int id, String baslik) {
		DataSource ds = null;
		Connection con = null;
		PreparedStatement hazirIfade = null;
		String guncelleStr = "UPDATE kitap SET baslik = ? WHERE id = ?;";

		try {
			ds = MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			hazirIfade = con.prepareStatement(guncelleStr);
			hazirIfade.setString (1, baslik);
			hazirIfade.setInt (2, id);
			hazirIfade.executeUpdate();			
			if(hazirIfade != null) hazirIfade.close();
			if(con != null) con.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void duzenleYazar(int id, String yazar) {
		DataSource ds = null;
		Connection con = null;
		PreparedStatement hazirIfade = null;
		String guncelleStr = "UPDATE kitap SET yazar = ? WHERE id = ?;";

		try {
			ds = MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			hazirIfade = con.prepareStatement(guncelleStr);
			hazirIfade.setString (1, yazar);
			hazirIfade.setInt (2, id);
			hazirIfade.executeUpdate();
			if(hazirIfade != null) hazirIfade.close();
			if(con != null) con.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
