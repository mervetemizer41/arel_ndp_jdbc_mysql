package com.mt.arel.jdbc.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DsMain {


	public static void main(String[] args){
		Kitap k = new Kitap( "Huzur", "Ahmet Hamdi Tanpınar", "888111999", 5500, KitapUtil.tarihCevir("1960-01-01"));

		DataSourceCreate.tabloYap();
		DataSourceInsert.ekle(k);
		Kitap kayitliKitap = DataSourceSelect.sec("Huzur");
		DataSourceUpdate.duzenleBaslik(kayitliKitap.getId(),"Beş Şehir");
		DataSourceUpdate.duzenleYazar(kayitliKitap.getId(),"A. H. Tanpınar");
		DataSourceSelect.sec();		
		DataSourceDelete.sil(k.getId());
	}

}
