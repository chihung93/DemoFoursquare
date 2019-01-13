package com.henry.foursquare.data.models;//

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class Venue{

	@SerializedName("categories")
	private List<Category> categories;
	@SerializedName("id")
	private String id;
	@SerializedName("location")
	private Location location;
	@SerializedName("name")
	private String name;
	@SerializedName("venuePage")
	private VenuePage venuePage;

	public void setCategories(List<Category> categories){
		this.categories = categories;
	}
	public List<Category> getCategories(){
		return this.categories;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setLocation(Location location){
		this.location = location;
	}
	public Location getLocation(){
		return this.location;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setVenuePage(VenuePage venuePage){
		this.venuePage = venuePage;
	}
	public VenuePage getVenuePage(){
		return this.venuePage;
	}

}