package com.mt.arel.jdbc.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import java.util.Date;


public class DataSourceSelect {


	public static void sec() {
		DataSource ds = null;
		Connection con = null;
		PreparedStatement stmt = null;

	String secStr = " SELECT * FROM kitap ";
		try {
			ds = MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			stmt = con.prepareStatement(secStr);
			ResultSet rs = stmt.executeQuery(secStr);
			while (rs.next()) {
				int id = rs.getInt("id");
				String baslik = rs.getString("baslik");
				String yazar = rs.getString("yazar");
				String isbn = rs.getString("isbn");
				int basimAdedi = rs.getInt("basim_adedi");
				Date basimTarihi = KitapUtil.tarihCevir(rs.getString("basim_tarihi"));
				Kitap k = new Kitap(id, baslik, yazar, isbn, basimAdedi, basimTarihi);
				System.out.println(k);
			}

		
			if(stmt != null) stmt.close();
			if(con != null) con.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
public static Kitap sec(String secmeBaslik) {
		DataSource ds = null;
		Connection con = null;
		PreparedStatement stmt = null;
		Kitap secilenKitap = null;

	String secStr = " SELECT * FROM kitap WHERE baslik = ?";
		try {
			ds = MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			stmt = con.prepareStatement(secStr);
			stmt.setString(1, secmeBaslik);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String baslik = rs.getString("baslik");
				String yazar = rs.getString("yazar");
				String isbn = rs.getString("isbn");
				int basimAdedi = rs.getInt("basim_adedi");
				Date basimTarihi = KitapUtil.tarihCevir(rs.getString("basim_tarihi"));
				secilenKitap  = new Kitap(id, baslik, yazar, isbn, basimAdedi, basimTarihi);
				System.out.println(secilenKitap);
			}

		
			if(stmt != null) stmt.close();
			if(con != null) con.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return secilenKitap;
	}


}
