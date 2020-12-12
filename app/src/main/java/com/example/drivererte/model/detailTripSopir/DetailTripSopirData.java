package com.example.drivererte.model.detailTripSopir;

import com.google.gson.annotations.SerializedName;

public class DetailTripSopirData {

	@SerializedName("kontak_pemesan")
	private String kontakPemesan;

	@SerializedName("no_hp")
	private Object noHp;

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
}