package com.example.drivererte.model.loginSopir;

import com.google.gson.annotations.SerializedName;

public class LoginSopir{

	@SerializedName("data")
	private LoginSopirData loginSopirData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setLoginSopirData(LoginSopirData loginSopirData){
		this.loginSopirData = loginSopirData;
	}

	public LoginSopirData getLoginSopirData(){
		return loginSopirData;
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