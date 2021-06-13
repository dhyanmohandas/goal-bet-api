package com.app.goalbet.models;

import java.util.Arrays;

public class ApiResponse {
	String status;
	Object[] Data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object[] getData() {
		return Data;
	}
	public void setData(Object[] data) {
		Data = data;
	}
	@Override
	public String toString() {
		return "ApiResponse [status=" + status + ", Data=" + Arrays.toString(Data) + "]";
	}


	

}
