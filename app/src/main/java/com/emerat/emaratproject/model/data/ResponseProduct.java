package com.emerat.emaratproject.model.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseProduct{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("end")
	private int end;

	public List<DataItem> getData(){
		return data;
	}

	public int getEnd(){
		return end;
	}
}