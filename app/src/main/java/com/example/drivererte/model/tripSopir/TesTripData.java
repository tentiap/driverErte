package com.example.drivererte.model.tripSopir;

import com.google.gson.annotations.SerializedName;

public class TesTripData {
	@SerializedName("plat_mobil")
	private String platMobil;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("tarif_trip")
	private int tarifTrip;

	@SerializedName("merek_mobil")
	private String merekMobil;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("password")
	private String password;

	@SerializedName("kontak")
	private String kontak;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_kota_asal")
	private String idKotaAsal;

	@SerializedName("id_sopir")
	private String idSopir;

	@SerializedName("id_kota_tujuan")
	private String idKotaTujuan;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setPlatMobil(String platMobil){
		this.platMobil = platMobil;
	}

	public String getPlatMobil(){
		return platMobil;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setTarifTrip(int tarifTrip){
		this.tarifTrip = tarifTrip;
	}

	public int getTarifTrip(){
		return tarifTrip;
	}

	public void setMerekMobil(String merekMobil){
		this.merekMobil = merekMobil;
	}

	public String getMerekMobil(){
		return merekMobil;
	}

	public void setJadwal(String jadwal){
		this.jadwal = jadwal;
	}

	public String getJadwal(){
		return jadwal;
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

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setIdKotaAsal(String idKotaAsal){
		this.idKotaAsal = idKotaAsal;
	}

	public String getIdKotaAsal(){
		return idKotaAsal;
	}

	public void setIdSopir(String idSopir){
		this.idSopir = idSopir;
	}

	public String getIdSopir(){
		return idSopir;
	}

	public void setIdKotaTujuan(String idKotaTujuan){
		this.idKotaTujuan = idKotaTujuan;
	}

	public String getIdKotaTujuan(){
		return idKotaTujuan;
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