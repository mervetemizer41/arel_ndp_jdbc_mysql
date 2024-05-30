package com.mt.arel.jdbc.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

public class DataSourceDelete {





	public static void sil(int id) {
		DataSource ds = null;
		Connection con = null;
		PreparedStatement hazirIfade = null;

		String silStr = "DELETE FROM kitap where id=?";
        
		try {
			ds = MyDataSourceFactory.getMySQLDataSource();			
			con = ds.getConnection();
			hazirIfade = con.prepareStatement(silStr);
			hazirIfade.setInt(1, id);	
			int silSatirSayisi = hazirIfade.executeUpdate();
			if (silSatirSayisi > 0) {
    				System.out.println(id + ", ID'li kitap başarılı şekilde silindi!");
			}
			if(hazirIfade != null) hazirIfade.close();
			if(con != null) con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
