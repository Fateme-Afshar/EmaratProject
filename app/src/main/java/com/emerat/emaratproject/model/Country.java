package com.emerat.emaratproject.model;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("_id")
    private String id;
    @SerializedName("name")
    private String name;

    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
