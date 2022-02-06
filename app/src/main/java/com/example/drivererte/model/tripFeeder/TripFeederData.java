package com.example.drivererte.model.tripFeeder;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TripFeederData implements Parcelable {

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("id_pemesan")
	private String idPemesan;

	@SerializedName("kontak")
	private String kontak;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("plat_mobil")
	private String platMobil;

	@SerializedName("id_seat")
	private String idSeat;

	@SerializedName("nama_penumpang")
	private String namaPenumpang;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("detail_asal")
	private String detailAsal;

	@SerializedName("biaya_tambahan")
	private String biayaTambahan;

	@SerializedName("status")
	private String status;


	@SerializedName("order_number")
	private int order_number;

	protected TripFeederData(Parcel in) {
		jadwal = in.readString();
		idPemesan = in.readString();
		kontak = in.readString();
		platMobil = in.readString();
		idSeat = in.readString();
		namaPenumpang = in.readString();
		jenisKelamin = in.readString();
		detailAsal = in.readString();
		biayaTambahan = in.readString();
		status = in.readString();
		order_number = in.readInt();
	}

	public static final Creator<TripFeederData> CREATOR = new Creator<TripFeederData>() {
		@Override
		public TripFeederData createFromParcel(Parcel in) {
			return new TripFeederData(in);
		}

		@Override
		public TripFeederData[] newArray(int size) {
			return new TripFeederData[size];
		}
	};

	public void setJadwal(String jadwal){
		this.jadwal = jadwal;
	}

	public String getJadwal(){
		String[] date = jadwal.split(" ");
		String tgl =  date[0];
		String[] tanggal = tgl.split("-");

		final String[] monthName = {"January", "February",
				"March", "April", "May", "June", "July",
				"August", "September", "October", "November",
				"December"};
		Integer months = Integer.parseInt(tanggal[1]);

		String[] tanggal1 = jadwal.split(" ");
		String time =  tanggal1[1];

		String[] jam = time.split(":");
		return tanggal[2] +" "+monthName[months - 1]+ " "+tanggal[0] +" - "+ jam[0]+":"+jam[1] ;
	}

	public String getJadwalOriginal(){
		return jadwal;
	}

	public void setIdPemesan(String idPemesan){
		this.idPemesan = idPemesan;
	}

	public String getIdPemesan(){
		return idPemesan;
	}

	public void setKontak(String kontak){
		this.kontak = kontak;
	}

	public String getKontak(){
		return kontak;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		if (noHp == null){
			return kontak;
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

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return "("+jenisKelamin+")";	}

	public void setDetailAsal(String detailAsal){
		this.detailAsal = detailAsal;
	}

	public String getDetailAsal(){
		return "Address: " +detailAsal;
	}

	public void setBiayaTambahan(String biayaTambahan){
		this.biayaTambahan = biayaTambahan;
	}

	public String getBiayaTambahan(){
		if (biayaTambahan == null){
			return "Additional cost(s): - ";
		}else{
			return "Additional cost(s): " +biayaTambahan;
		}
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){

//		if (status == 1){
//			return "Booking ";
//		}else if (status == "2"){
//			return "Picked Up";
//		}else if (status == "3"){
//			return "On Going";
//		}else if (status == "4"){
//			return "Arrived";
//		}else{
//			return "Cancelled";
//		}
////		return  status;
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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(jadwal);
		dest.writeString(idPemesan);
		dest.writeString(kontak);
		dest.writeString(platMobil);
		dest.writeString(idSeat);
		dest.writeString(namaPenumpang);
		dest.writeString(jenisKelamin);
		dest.writeString(detailAsal);
		dest.writeString(biayaTambahan);
		dest.writeString(status);
		dest.writeInt(order_number);
	}
}