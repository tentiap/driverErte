package com.example.drivererte.model.detailTripSopir;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DetailTripSopirData implements Parcelable {

	@SerializedName("kontak_pemesan")
	private String kontakPemesan;

	@SerializedName("no_hp")
	private Object noHp;

	@SerializedName("id_trip")
	private String idTrip;

	@SerializedName("id_pesanan")
	private String idPesanan;

	@SerializedName("detail_tujuan")
	private String detailTujuan;

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

	public DetailTripSopirData(){

	}

	protected DetailTripSopirData(Parcel in) {
		kontakPemesan = in.readString();
		idTrip = in.readString();
		idPesanan = in.readString();
		detailTujuan = in.readString();
		idSeat = in.readString();
		namaPenumpang = in.readString();
		jenisKelamin = in.readString();
		detailAsal = in.readString();
		status = in.readInt();
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

	public void setKontakPemesan(String kontakPemesan){
		this.kontakPemesan = kontakPemesan;
	}

	public String getKontakPemesan(){
		return kontakPemesan;
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

	public void setDetailTujuan(String detailTujuan){
		this.detailTujuan = detailTujuan;
	}

	public String getDetailTujuan(){
		return "To: " +detailTujuan;	}

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
		return "From: " +detailAsal;
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

	public void setStatus(int status){
		this.status = status;
	}

	public String getStatus(){
		if (status == 1){
			return "Status: Booking ";
		}else if (status == 2){
			return "Status: Picked Up";
		}else if (status == 3){
			return "Status: On Going";
		}else if (status == 4){
			return "Status: Arrived";
		}else{
			return "Status: Cancelled";
		}
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(kontakPemesan);
		parcel.writeString(idTrip);
		parcel.writeString(idPesanan);
		parcel.writeString(detailTujuan);
		parcel.writeString(idSeat);
		parcel.writeString(namaPenumpang);
		parcel.writeString(jenisKelamin);
		parcel.writeString(detailAsal);
		parcel.writeInt(status);
	}
}