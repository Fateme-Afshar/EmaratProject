package com.emerat.emaratproject.retrofit.gsonDeserializer;

import com.emerat.emaratproject.model.Country;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CountryListDeserializer implements JsonDeserializer<List<Country>> {
    @Override
    public List<Country> deserialize(JsonElement jsonElement,
                                     Type typeOfT,
                                     JsonDeserializationContext context) throws JsonParseException {
        List<Country> countryList=new ArrayList<>();

        JsonArray jsonArray=jsonElement.getAsJsonArray();

        for (JsonElement element: jsonArray) {
            JsonObject jsonObject=element.getAsJsonObject();

            String id=jsonObject.get("_id").getAsString();
            String name=jsonObject.get("name").getAsString();

            Country country=new Country(id,name);

            countryList.add(country);
        }

        return countryList;
    }
}
