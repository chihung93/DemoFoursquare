package com.henry.foursquare.data.models;//

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class Category{

	@SerializedName("icon")
	private Icon icon;
	@SerializedName("id")
	private String id;
	@SerializedName("name")
	private String name;
	@SerializedName("pluralName")
	private String pluralName;
	@SerializedName("primary")
	private boolean primary;
	@SerializedName("shortName")
	private String shortName;

	public void setIcon(Icon icon){
		this.icon = icon;
	}
	public Icon getIcon(){
		return this.icon;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setPluralName(String pluralName){
		this.pluralName = pluralName;
	}
	public String getPluralName(){
		return this.pluralName;
	}
	public void setPrimary(boolean primary){
		this.primary = primary;
	}
	public boolean isPrimary()
	{
		return this.primary;
	}
	public void setShortName(String shortName){
		this.shortName = shortName;
	}
	public String getShortName(){
		return this.shortName;
	}

}