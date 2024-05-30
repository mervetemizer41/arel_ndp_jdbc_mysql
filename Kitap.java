package com.mt.arel.jdbc.mysql;

import java.util.Date;

public class Kitap{

	private int id;

	private String baslik;

	private String yazar;

	private String isbn;

	private int basimAdedi;

	private Date basimTarihi;


	//kaydedilmemiş kitap yapılandırıcısı, id'siz
	public Kitap(String baslik, String yazar, String isbn, int basimAdedi, Date basimTarihi) {
		super();
		this.baslik = baslik;
		this.yazar = yazar;
		this.isbn = isbn;
		this.basimAdedi = basimAdedi;
		this.basimTarihi = basimTarihi;
	}

	//kaydedilmiş kitap yapılandırıcısı, id'li
	public Kitap(int id, String baslik, String yazar, String isbn, int basimAdedi, Date basimTarihi) {
		super();
		this.id = id;
		this.baslik = baslik;
		this.yazar = yazar;
		this.isbn = isbn;
		this.basimAdedi = basimAdedi;
		this.basimTarihi = basimTarihi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getBasimAdedi() {
		return basimAdedi;
	}

	public void setBasimAdedi(int basimAdedi) {
		this.basimAdedi = basimAdedi;
	}

	public Date getBasimTarihi() {
		return basimTarihi;
	}

	public void setBasimTarihi(Date basimTarihi) {
		this.basimTarihi = basimTarihi;
	}

	public String toString(){
		String res = "Kitap detay: \n";
		res += "Başlık: " + this.baslik + "\n"; 
		res += "Yazar: " + this.yazar + "\n";
		res += "Basım adedi:" + String.valueOf(this.basimAdedi);
		return res;	
	}



}
