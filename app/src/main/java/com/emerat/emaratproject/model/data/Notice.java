package com.emerat.emaratproject.model.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Notice {

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

	public Notice(String date,
				  String dateOfEx,
				  List<Object> image,
				  String country,
				  String address,
				  String city,
				  String about,
				  boolean check,
				  String title,
				  UserId userId,
				  boolean isoGld,
				  String telePhone,
				  int offer,
				  String createdAt,
				  int v,
				  String id,
				  String category,
				  String cityText,
				  String countryText,
				  String updatedAt) {
		this.date = date;
		this.dateOfEx = dateOfEx;
		this.image = image;
		this.country = country;
		this.address = address;
		this.city = city;
		this.about = about;
		this.check = check;
		this.title = title;
		this.userId = userId;
		this.isoGld = isoGld;
		this.telePhone = telePhone;
		this.offer = offer;
		this.createdAt = createdAt;
		V = v;
		this.id = id;
		this.category = category;
		this.cityText = cityText;
		this.countryText = countryText;
		this.updatedAt = updatedAt;
	}

	public Notice() {
	}

	public Notice(String dateOfEx,
				  String country,
				  String address,
				  String city,
				  String about,
				  String title,
				  String telePhone,
				  int offer,
				  String category,
				  String cityText,
				  String countryText) {
		this.dateOfEx = dateOfEx;
		this.country = country;
		this.address = address;
		this.city = city;
		this.about = about;
		this.title = title;
		this.telePhone = telePhone;
		this.offer = offer;
		this.category = category;
		this.cityText = cityText;
		this.countryText = countryText;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDateOfEx(String dateOfEx) {
		this.dateOfEx = dateOfEx;
	}

	public void setImage(List<Object> image) {
		this.image = image;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	public void setIsoGld(boolean isoGld) {
		this.isoGld = isoGld;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setV(int v) {
		V = v;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCityText(String cityText) {
		this.cityText = cityText;
	}

	public void setCountryText(String countryText) {
		this.countryText = countryText;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

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