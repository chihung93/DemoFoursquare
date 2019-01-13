package com.henry.foursquare.data.models;

import com.google.gson.annotations.SerializedName;


public class VenuePage{

	@SerializedName("id")
	private String id;

	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}

}