package com.example.drivererte.model.tripFeeder;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TripFeederData implements Parcelable {

	@SerializedName("id_trip")
	private String idTrip;

	@SerializedName("id_pesanan")
	private String idPesanan;

	@SerializedName("kontak")
	private String kontak;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("id_seat")
	private String idSeat;

	@SerializedName("nama_penumpang")
	private String namaPenumpang;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("detail_asal")
	private String detailAsal;

	@SerializedName("biaya_tambahan")
	private Object biayaTambahan;

	@SerializedName("status")
	private int status;

	protected TripFeederData(Parcel in) {
		idTrip = in.readString();
		idPesanan = in.readString();
		kontak = in.readString();
		jadwal = in.readString();
		noHp = in.readString();
		idSeat = in.readString();
		namaPenumpang = in.readString();
		jenisKelamin = in.readString();
		detailAsal = in.readString();
		status = in.readInt();
	}

	public TripFeederData(){

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

	public void setKontak(String kontak){
		this.kontak = kontak;
	}

	public String getKontak(){
		return kontak;
	}

	public void setIdPesanan(String idPesanan){
		this.idPesanan = idPesanan;
	}

	public String getIdPesanan(){
		return idPesanan;
	}

	public void setIdTrip(String idTrip){
		this.idTrip = idTrip;
	}

	public String getIdTrip(){
		return idTrip;
	}

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
		return "("+jenisKelamin+")";
	}

	public void setDetailAsal(String detailAsal){
		this.detailAsal = detailAsal;
	}

	public String getDetailAsal(){
		return "Address: " +detailAsal;
	}

	public void setBiayaTambahan(Object biayaTambahan){
		this.biayaTambahan = biayaTambahan;
	}

	public String getBiayaTambahan(){
		if (biayaTambahan == null){
			return "Additional cost(s): - ";
		}else{
			return "Additional cost(s): " +biayaTambahan;
		}
	}

	public void setStatus(int status){
		this.status = status;
	}

	public String getStatus(){
		if (status == 1){
			return "Booking ";
		}else if (status == 2){
			return "Picked Up";
		}else if (status == 3){
			return "On Going";
		}else if (status == 4){
			return "Arrived";
		}else{
			return "Cancelled";
		}
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(idTrip);
		parcel.writeString(idPesanan);
		parcel.writeString(kontak);
		parcel.writeString(jadwal);
		parcel.writeString(noHp);
		parcel.writeString(idSeat);
		parcel.writeString(namaPenumpang);
		parcel.writeString(jenisKelamin);
		parcel.writeString(detailAsal);
		parcel.writeInt(status);
	}
}