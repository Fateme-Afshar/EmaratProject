package com.emerat.emaratproject.model;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("_id")
    private String id;
    @SerializedName("title")
    private String title;

    private String countryId;

    public City(String id, String title, String countryId) {
        this.id = id;
        this.title = title;
        this.countryId = countryId;
    }

    public City() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
