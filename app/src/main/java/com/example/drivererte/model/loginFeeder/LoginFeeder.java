package com.example.drivererte.model.loginFeeder;

import com.google.gson.annotations.SerializedName;

public class LoginFeeder{

	@SerializedName("data")
	private LoginFeederData loginFeederData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setLoginFeederData(LoginFeederData loginFeederData){
		this.loginFeederData = loginFeederData;
	}

	public LoginFeederData getLoginFeederData(){
		return loginFeederData;
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