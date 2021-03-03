package com.emerat.emaratproject.model.data;

import com.google.gson.annotations.SerializedName;

public class UserId{

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("Id")
	private String id;

	@SerializedName("userName")
	private String userName;

	@SerializedName("email")
	private String email;

	public String getPhone(){
		return phone;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getUserName(){
		return userName;
	}

	public String getEmail(){
		return email;
	}
}