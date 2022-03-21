package com.example.drivererte.model.loginSopir;

import com.google.gson.annotations.SerializedName;

public class LoginSopirData {

	@SerializedName("plat_mobil")
	private String platMobil;

	@SerializedName("password")
	private String password;

	@SerializedName("kontak")
	private String kontak;

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("id_sopir")
	private String idSopir;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public String getMerekMobil() {
		return merekMobil;
	}

	public void setMerekMobil(String merekMobil) {
		this.merekMobil = merekMobil;
	}

	@SerializedName("merek_mobil")
	private String merekMobil;

	public String getPlatMobil() {
		return platMobil;
	}

	public void setPlatMobil(String platMobil) {
		this.platMobil = platMobil;
	}

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

	public void setIdSopir(String idSopir){
		this.idSopir = idSopir;
	}

	public String getIdSopir(){
		return idSopir;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
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