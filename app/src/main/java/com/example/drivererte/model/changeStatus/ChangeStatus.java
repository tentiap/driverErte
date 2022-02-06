package com.example.drivererte.model.changeStatus;

import com.google.gson.annotations.SerializedName;

public class ChangeStatus{

	@SerializedName("data")
	private ChangeStatusData changeStatusData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setChangeStatusData(ChangeStatusData changeStatusData){
		this.changeStatusData = changeStatusData;
	}

	public ChangeStatusData getChangeStatusData(){
		return changeStatusData;
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

