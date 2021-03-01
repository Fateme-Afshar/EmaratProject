package com.emerat.emaratproject.retrofit.gsonDeserializer;

import com.emerat.emaratproject.model.City;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CityListDeserializer implements JsonDeserializer<List<City>> {

    @Override
    public List<City> deserialize(JsonElement jsonElement,
                                  Type typeOfT,
                                  JsonDeserializationContext context) throws JsonParseException {
        List<City> cityList=new ArrayList<>();

        JsonArray jsonArray=jsonElement.getAsJsonArray();

        for (JsonElement element: jsonArray) {
            JsonObject jsonObject=element.getAsJsonObject();

            String id=jsonObject.get("_id").getAsString();
            String title=jsonObject.get("title").getAsString();

            String countryId=jsonObject.get("countryId").getAsJsonObject().get("_id").getAsString();
            City city=new City(id,title,countryId);

            cityList.add(city);
        }

        return cityList;
    }
}
