//package com.example.drivererte.model.historySopir;
//
//import com.google.gson.annotations.SerializedName;
//
//public class HistorySopirDataOld {
//
//	@SerializedName("jadwal")
//	private String jadwal;
//
//	@SerializedName("updated_at")
//	private String updatedAt;
//
//	@SerializedName("id_kota_asal")
//	private String idKotaAsal;
//
//	@SerializedName("id_users_operator")
//	private String idUsersOperator;
//
//	@SerializedName("id_kota_tujuan")
//	private String idKotaTujuan;
//
//	@SerializedName("created_at")
//	private String createdAt;
//
//	@SerializedName("id_trip")
//	private String idTrip;
//
//	@SerializedName("id_users_sopir")
//	private String idUsersSopir;
//
//	public void setJadwal(String jadwal){
//		this.jadwal = jadwal;
//	}
//
//	public String getJadwal(){
//		String[] tanggal = jadwal.split(" ");
//		String time =  tanggal[1];
//
//		String[] jam = time.split(":");
//		return jam[0]+":"+jam[1];
//	}
//
//	public void setUpdatedAt(String updatedAt){
//		this.updatedAt = updatedAt;
//	}
//
//	public String getUpdatedAt(){
//		return updatedAt;
//	}
//
//	public void setIdKotaAsal(String idKotaAsal){
//		this.idKotaAsal = idKotaAsal;
//	}
//
//	public String getIdKotaAsal(){
//		switch (idKotaAsal){
//			case "K1":
//				idKotaAsal = "Bukittinggi";
//				break;
//			case "K2":
//				idKotaAsal = "Padang";
//				break;
//			case "K3":
//				idKotaAsal = "Pekanbaru";
//				break;
//		}
//		return idKotaAsal;	}
//
//	public void setIdUsersOperator(String idUsersOperator){
//		this.idUsersOperator = idUsersOperator;
//	}
//
//	public String getIdUsersOperator(){
//		return idUsersOperator;
//	}
//
//	public void setIdKotaTujuan(String idKotaTujuan){
//		this.idKotaTujuan = idKotaTujuan;
//	}
//
//	public String getIdKotaTujuan(){
//		switch (idKotaTujuan){
//			case "K1":
//				idKotaTujuan = "Bukittinggi";
//				break;
//			case "K2":
//				idKotaTujuan = "Padang";
//				break;
//			case "K3":
//				idKotaTujuan = "Pekanbaru";
//				break;
//		}
//		return idKotaTujuan;	}
//
//	public void setCreatedAt(String createdAt){
//		this.createdAt = createdAt;
//	}
//
//	public String getCreatedAt(){
//		return createdAt;
//	}
//
//	public void setIdTrip(String idTrip){
//		this.idTrip = idTrip;
//	}
//
//	public String getIdTrip(){
//		return idTrip;
//	}
//
//	public void setIdUsersSopir(String idUsersSopir){
//		this.idUsersSopir = idUsersSopir;
//	}
//
//	public String getIdUsersSopir(){
//		return idUsersSopir;
//	}
//
//    public String getTanggal() {
//		String[] date = jadwal.split(" ");
//		String tgl =  date[0];
//		String[] tanggal = tgl.split("-");
//
//		final String[] monthName = {"January", "February",
//				"March", "April", "May", "June", "July",
//				"August", "September", "October", "November",
//				"December"};
//		Integer months = Integer.parseInt(tanggal[1]);
//		return tanggal[2] +" "+monthName[months - 1]+ " "+tanggal[0];
//    }
//}