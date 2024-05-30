package com.mt.arel.jdbc.mysql;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class KitapUtil{

	public static java.sql.Date tarihCevir(String tarihStr){

		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date tarih = null;
		java.sql.Date sqlTarih = null;
		try{
		tarih = formatter.parse(tarihStr);
		sqlTarih = new java.sql.Date(tarih.getTime());
		
		}catch(ParseException pe){
			pe.printStackTrace();
		}		

		return sqlTarih;

	}
}
