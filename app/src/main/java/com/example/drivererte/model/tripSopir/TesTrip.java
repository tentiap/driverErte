package com.example.drivererte.model.tripSopir;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TesTrip{

	@SerializedName("data")
	private List<TesTripData> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(List<TesTripData> data){
		this.data = data;
	}

	public List<TesTripData> getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}