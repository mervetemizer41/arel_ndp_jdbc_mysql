package com.mt.arel.jdbc.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

public class DataSourceInsert {


	public static void ekle(Kitap k) {
		DataSource ds = null;		
		Connection con = null;
		PreparedStatement hazirlananIfade = null;

		

	String ekleStr = " insert into kitap (baslik, yazar, isbn, basim_adedi, basim_tarihi)"
    + " values (?, ?, ?, ?, ?)";
		try {
			ds = MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			hazirlananIfade = con.prepareStatement(ekleStr);
			hazirlananIfade.setString (1, k.getBaslik());
			hazirlananIfade.setString (2, k.getYazar());
			hazirlananIfade.setString (3, k.getIsbn());
			hazirlananIfade.setInt (4, k.getBasimAdedi());
			hazirlananIfade.setDate (5, new java.sql.Date(k.getBasimTarihi().getTime()));			
			hazirlananIfade.executeUpdate();
			
			
			if(hazirlananIfade != null) hazirlananIfade.close();
			if(con != null) con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
