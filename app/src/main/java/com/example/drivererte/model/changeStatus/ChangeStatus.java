package com.example.drivererte.model.changeStatus;

import com.google.gson.annotations.SerializedName;

public class ChangeStatus{

	@SerializedName("data")
	private ChangeStatusData data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(ChangeStatusData data){
		this.data = data;
	}

	public ChangeStatusData getData(){
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