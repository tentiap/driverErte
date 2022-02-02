package com.example.drivererte.model.tripSopir;

import java.util.List;

public class TripSopir{
	private List<TripSopirData> data;
	private String message;
	private boolean status;

	public void setData(List<TripSopirData> data){
		this.data = data;
	}

	public List<TripSopirData> getData(){
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