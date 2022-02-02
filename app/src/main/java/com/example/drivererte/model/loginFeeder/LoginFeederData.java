package com.example.drivererte.model.loginFeeder;

import com.google.gson.annotations.SerializedName;

public class LoginFeederData {

	@SerializedName("password")
	private String password;

	@SerializedName("kontak")
	private String kontak;

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_kota")
	private String idKota;

	@SerializedName("id_feeder")
	private String idFeeder;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setKontak(String kontak){
		this.kontak = kontak;
	}

	public String getKontak(){
		return kontak;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setIdKota(String idKota){
		this.idKota = idKota;
	}

	public String getIdKota(){

		switch (idKota){
			case "K1":
				idKota = "Bukittinggi";
				break;
			case "K2":
				idKota = "Padang";
				break;
			case "K3":
				idKota = "Pekanbaru";
				break;
		}
		return idKota;
	}

	public void setIdFeeder(String idFeeder){
		this.idFeeder = idFeeder;
	}

	public String getIdFeeder(){
		return idFeeder;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}