package com.example.drivererte.model.tripSopir;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TripSopirData implements Parcelable {
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

	protected TripSopirData(Parcel in) {
		platMobil = in.readString();
		createdAt = in.readString();
		tarifTrip = in.readInt();
		merekMobil = in.readString();
		jadwal = in.readString();
		password = in.readString();
		kontak = in.readString();
		updatedAt = in.readString();
		nama = in.readString();
		idKotaAsal = in.readString();
		idSopir = in.readString();
		idKotaTujuan = in.readString();
		jenisKelamin = in.readString();
		email = in.readString();
		username = in.readString();
	}

	public static final Creator<TripSopirData> CREATOR = new Creator<TripSopirData>() {
		@Override
		public TripSopirData createFromParcel(Parcel in) {
			return new TripSopirData(in);
		}

		@Override
		public TripSopirData[] newArray(int size) {
			return new TripSopirData[size];
		}
	};

	public void setPlatMobil(String platMobil){
		this.platMobil = platMobil;
	}

	public String getPlatMobil(){
		return platMobil;
//		return "BA1111LZ";

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
		String[] tanggal = jadwal.split(" ");
		String time =  tanggal[1];

		String[] jam = time.split(":");
		return jam[0]+":"+jam[1];
	}

	public String getJadwalOriginal(){
		return jadwal;
	}

	public String getTanggal(){
		String[] date = jadwal.split(" ");
		String tgl =  date[0];
		String[] tanggal = tgl.split("-");

		final String[] monthName = {"January", "February",
				"March", "April", "May", "June", "July",
				"August", "September", "October", "November",
				"December"};
		Integer months = Integer.parseInt(tanggal[1]);
		return tanggal[2] +" "+monthName[months - 1]+ " "+tanggal[0];
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
		switch (idKotaAsal){
			case "K1":
				idKotaAsal = "Bukittinggi";
				break;
			case "K2":
				idKotaAsal = "Padang";
				break;
			case "K3":
				idKotaAsal = "Pekanbaru";
				break;
		}
		return idKotaAsal;
//		return "Bukittinggi";

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
		switch (idKotaTujuan){
			case "K1":
				idKotaTujuan = "Bukittinggi";
				break;
			case "K2":
				idKotaTujuan = "Padang";
				break;
			case "K3":
				idKotaTujuan = "Pekanbaru";
				break;
		}
		return idKotaTujuan;
//		return "Padang";

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(platMobil);
		dest.writeString(createdAt);
		dest.writeInt(tarifTrip);
		dest.writeString(merekMobil);
		dest.writeString(jadwal);
		dest.writeString(password);
		dest.writeString(kontak);
		dest.writeString(updatedAt);
		dest.writeString(nama);
		dest.writeString(idKotaAsal);
		dest.writeString(idSopir);
		dest.writeString(idKotaTujuan);
		dest.writeString(jenisKelamin);
		dest.writeString(email);
		dest.writeString(username);
	}
}
