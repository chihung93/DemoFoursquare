package com.henry.foursquare.data.models;//

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class LabeledLatLng{

	@SerializedName("label")
	private String label;
	@SerializedName("lat")
	private float lat;
	@SerializedName("lng")
	private float lng;

	public void setLabel(String label){
		this.label = label;
	}
	public String getLabel(){
		return this.label;
	}
	public void setLat(float lat){
		this.lat = lat;
	}
	public float getLat(){
		return this.lat;
	}
	public void setLng(float lng){
		this.lng = lng;
	}
	public float getLng(){
		return this.lng;
	}

}