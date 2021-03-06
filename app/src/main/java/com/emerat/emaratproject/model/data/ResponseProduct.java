package com.emerat.emaratproject.model.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseProduct{

	@SerializedName("data")
	private List<Notice> data;

	@SerializedName("end")
	private int end;

	public List<Notice> getNoticeList(){
		return data;
	}

	public int getEnd(){
		return end;
	}
}