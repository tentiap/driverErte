package com.example.drivererte.model.detailTripSopir;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DetailTripSopirData implements Parcelable {

	@SerializedName("id_pemesan")
	private String idPemesan;

	@SerializedName("no_hp")
	private Object noHp;

	@SerializedName("plat_mobil")
	private String platMobil;

//	@SerializedName("order_number")
//	private int orderNumber;

	@SerializedName("detail_tujuan")
	private String detailTujuan;

	@SerializedName("id_seat")
	private String idSeat;

	@SerializedName("nama_penumpang")
	private String namaPenumpang;

	@SerializedName("detail_asal")
	private String detailAsal;

	@SerializedName("biaya_tambahan")
	private Object biayaTambahan;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("kontak_pemesan")
	private String kontakPemesan;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("status")
	private String status;

	protected DetailTripSopirData(Parcel in) {
		idPemesan = in.readString();
		platMobil = in.readString();
//		orderNumber = in.readInt();
		detailTujuan = in.readString();
		idSeat = in.readString();
		namaPenumpang = in.readString();
		detailAsal = in.readString();
		jadwal = in.readString();
		kontakPemesan = in.readString();
		jenisKelamin = in.readString();
		status = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(idPemesan);
		dest.writeString(platMobil);
//		dest.writeInt(orderNumber);
		dest.writeString(detailTujuan);
		dest.writeString(idSeat);
		dest.writeString(namaPenumpang);
		dest.writeString(detailAsal);
		dest.writeString(jadwal);
		dest.writeString(kontakPemesan);
		dest.writeString(jenisKelamin);
		dest.writeString(status);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<DetailTripSopirData> CREATOR = new Creator<DetailTripSopirData>() {
		@Override
		public DetailTripSopirData createFromParcel(Parcel in) {
			return new DetailTripSopirData(in);
		}

		@Override
		public DetailTripSopirData[] newArray(int size) {
			return new DetailTripSopirData[size];
		}
	};

	public void setIdPemesan(String idPemesan){
		this.idPemesan = idPemesan;
	}

	public String getIdPemesan(){
		return idPemesan;
	}

	public void setNoHp(Object noHp){
		this.noHp = noHp;
	}

	public Object getNoHp(){
		if (noHp == null){
			return kontakPemesan;
		}else{
			return noHp;
		}
	}

	public void setPlatMobil(String platMobil){
		this.platMobil = platMobil;
	}

	public String getPlatMobil(){
		return platMobil;
	}

//	public void setOrderNumber(int orderNumber){
//		this.orderNumber = orderNumber;
//	}
//
//	public int getOrderNumber(){
//		return orderNumber;
//	}

	public void setDetailTujuan(String detailTujuan){
		this.detailTujuan = detailTujuan;
	}

	public String getDetailTujuan(){
		return "To: " +detailTujuan;
	}

	public void setIdSeat(String idSeat){
		this.idSeat = idSeat;
	}

	public String getIdSeat(){
		return "Seat "+idSeat;
	}

	public void setNamaPenumpang(String namaPenumpang){
		this.namaPenumpang = namaPenumpang;
	}

	public String getNamaPenumpang(){
		return namaPenumpang;
	}

	public void setDetailAsal(String detailAsal){
		this.detailAsal = detailAsal;
	}

	public String getDetailAsal(){
		return "From: "+detailAsal;
	}

	public void setBiayaTambahan(Object biayaTambahan){
		this.biayaTambahan = biayaTambahan;
	}

	public Object getBiayaTambahan(){
		if (biayaTambahan == null){
			return "Additional cost(s): - ";
		}else{
			return "Additional cost(s): " +biayaTambahan;
		}
	}

	public void setJadwal(String jadwal){
		this.jadwal = jadwal;
	}

	public String getJadwal(){
		return jadwal;
	}


	public void setKontakPemesan(String kontakPemesan){
		this.kontakPemesan = kontakPemesan;
	}

	public String getKontakPemesan(){
		return kontakPemesan;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
//		if (status == "1"){
//			return "Booking ";
//		}else if (status == "2"){
//			return "Picked Up";
//		}else if (status == "3"){
//			return "On Going";
//		}else if (status == "4"){
//			return "Arrived";
//		}else if (status == "5"){
//			return "Cancelled";
//		}else{
//			return "Unknown Status";
//		}

		switch (status){
			case "1":
				status = "Booking";
				break;
			case "2":
				status = "Picked Up";
				break;
			case "3":
				status = "On Going";
				break;
			case "4":
				status = "Arrived";
				break;
			case "5":
				status = "Cancelled";
				break;
		}
		return status;
	}
}