package com.emerat.emaratproject.model.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("date")
	private String date;

	@SerializedName("dateOfEx")
	private String dateOfEx;

	@SerializedName("image")
	private List<Object> image;

	@SerializedName("country")
	private String country;

	@SerializedName("address")
	private String address;

	@SerializedName("city")
	private String city;

	@SerializedName("about")
	private String about;

	@SerializedName("check")
	private boolean check;

	@SerializedName("title")
	private String title;

	@SerializedName("userId")
	private UserId userId;

	@SerializedName("isoGld")
	private boolean isoGld;

	@SerializedName("telePhone")
	private String telePhone;

	@SerializedName("offer")
	private int offer;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("__v")
	private int V;

	@SerializedName("_id")
	private String id;

	@SerializedName("category")
	private String category;

	@SerializedName("cityText")
	private String cityText;

	@SerializedName("countryText")
	private String countryText;

	@SerializedName("updatedAt")
	private String updatedAt;

	public String getDate(){
		return date;
	}

	public String getDateOfEx(){
		return dateOfEx;
	}

	public List<Object> getImage(){
		return image;
	}

	public String getCountry(){
		return country;
	}

	public String getAddress(){
		return address;
	}

	public String getCity(){
		return city;
	}

	public String getAbout(){
		return about;
	}

	public boolean isCheck(){
		return check;
	}

	public String getTitle(){
		return title;
	}

	public UserId getUserId(){
		return userId;
	}

	public boolean isIsoGld(){
		return isoGld;
	}

	public String getTelePhone(){
		return telePhone;
	}

	public int getOffer(){
		return offer;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getV(){
		return V;
	}

	public String getId(){
		return id;
	}

	public String getCategory(){
		return category;
	}

	public String getCityText(){
		return cityText;
	}

	public String getCountryText(){
		return countryText;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}
}