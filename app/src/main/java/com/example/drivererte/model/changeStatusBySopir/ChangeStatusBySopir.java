package com.example.drivererte.model.changeStatusBySopir;

import com.google.gson.annotations.SerializedName;

public class ChangeStatusBySopir{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}