package com.emerat.emaratproject.model;

import com.google.gson.annotations.SerializedName;

public class PostResponse{

	@SerializedName("_id")
	private String id;

	@SerializedName("userName")
	private String userName;

	@SerializedName("email")
	private String email;

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