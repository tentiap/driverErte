package com.example.drivererte.model.changeStatusError;

import com.google.gson.annotations.SerializedName;

public class ChangeStatusError {

	@SerializedName("data")
	private ChangeStatusDataError data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(ChangeStatusDataError data){
		this.data = data;
	}

	public ChangeStatusDataError getData(){
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