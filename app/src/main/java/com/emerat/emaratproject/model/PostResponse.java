package com.emerat.emaratproject.model;

import com.google.gson.annotations.SerializedName;

public class PostResponse{

	@SerializedName("name")
	private String name;

	@SerializedName("token")
	private String token;

	public String getName(){
		return name;
	}

	public String getToken(){
		return token;
	}
}