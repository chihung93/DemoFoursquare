package com.henry.foursquare.data.models;//

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Location{

	@SerializedName("address")
	private String address;
	@SerializedName("cc")
	private String cc;
	@SerializedName("city")
	private String city;
	@SerializedName("country")
	private String country;
	@SerializedName("crossStreet")
	private String crossStreet;
	@SerializedName("distance")
	private int distance;
	@SerializedName("formattedAddress")
	private List<String> formattedAddress;
	@SerializedName("labeledLatLngs")
	private List<LabeledLatLng> labeledLatLngs;
	@SerializedName("lat")
	private float lat;
	@SerializedName("lng")
	private float lng;
	@SerializedName("postalCode")
	private String postalCode;
	@SerializedName("state")
	private String state;

	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return this.address;
	}
	public void setCc(String cc){
		this.cc = cc;
	}
	public String getCc(){
		return this.cc;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return this.city;
	}
	public void setCountry(String country){
		this.country = country;
	}
	public String getCountry(){
		return this.country;
	}
	public void setCrossStreet(String crossStreet){
		this.crossStreet = crossStreet;
	}
	public String getCrossStreet(){
		return this.crossStreet;
	}
	public void setDistance(int distance){
		this.distance = distance;
	}
	public int getDistance(){
		return this.distance;
	}
	public void setFormattedAddress(List<String> formattedAddress){
		this.formattedAddress = formattedAddress;
	}
	public List<String> getFormattedAddress(){
		return this.formattedAddress;
	}
	public void setLabeledLatLngs(List<LabeledLatLng> labeledLatLngs){
		this.labeledLatLngs = labeledLatLngs;
	}
	public List<LabeledLatLng> getLabeledLatLngs(){
		return this.labeledLatLngs;
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
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	public String getPostalCode(){
		return this.postalCode;
	}
	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return this.state;
	}

}