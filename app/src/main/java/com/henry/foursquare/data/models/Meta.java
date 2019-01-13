package com.henry.foursquare.data.models;//

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class Meta{

	@SerializedName("code")
	private int code;
	@SerializedName("requestId")
	private String requestId;

	public void setCode(int code){
		this.code = code;
	}
	public int getCode(){
		return this.code;
	}
	public void setRequestId(String requestId){
		this.requestId = requestId;
	}
	public String getRequestId(){
		return this.requestId;
	}

}