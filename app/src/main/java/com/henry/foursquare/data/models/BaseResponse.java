package com.henry.foursquare.data.models;//

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class BaseResponse {

	@SerializedName("meta")
	private Meta meta;
	@SerializedName("response")
	private Response response;

	public void setMeta(Meta meta){
		this.meta = meta;
	}
	public Meta getMeta(){
		return this.meta;
	}
	public void setResponse(Response response){
		this.response = response;
	}
	public Response getResponse(){
		return this.response;
	}

}