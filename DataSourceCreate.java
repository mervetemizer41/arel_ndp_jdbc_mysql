package com.mt.arel.jdbc.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DataSourceCreate {

	public static void tabloYap() {
		DataSource ds = null;
		
		ds = MyDataSourceFactory.getMySQLDataSource();
		
		
		Connection con = null;
		Statement stmt = null;

	String genStr = "CREATE TABLE kitap " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " baslik VARCHAR(255), " + 
                   " yazar VARCHAR(255), " + 
                   " isbn VARCHAR(255), " +
		   " basim_adedi INTEGER, " +
		   " basim_tarihi DATE, " +  
                   " PRIMARY KEY ( id ) )";
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(genStr);
			
			if(stmt != null) stmt.close();
			if(con != null) con.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
