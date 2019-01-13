package com.henry.foursquare.data.models;//

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class Icon{

	@SerializedName("prefix")
	private String prefix;
	@SerializedName("suffix")
	private String suffix;

	public void setPrefix(String prefix){
		this.prefix = prefix;
	}
	public String getPrefix(){
		return this.prefix;
	}
	public void setSuffix(String suffix){
		this.suffix = suffix;
	}
	public String getSuffix(){
		return this.suffix;
	}

}