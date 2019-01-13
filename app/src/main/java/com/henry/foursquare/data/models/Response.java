package com.henry.foursquare.data.models;//

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class Response{

	@SerializedName("venues")
	private List<Venue> venues;

	public void setVenues( List<Venue> venues){
		this.venues = venues;
	}
	public List<Venue> getVenues(){
		return this.venues;
	}

}