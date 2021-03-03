package com.emerat.emaratproject.utils;

import java.util.HashMap;
import java.util.Map;

public class NetworkUtils {
    public static final String BASE_URL = "http://192.168.1.181:2581/api/";

    public static Map<String,String> createMap(String countryId,String cityId){
        Map<String,String> queryMap=new HashMap<>();
        queryMap.put("country",countryId);
        queryMap.put("city",cityId);
        queryMap.put("page","1");
        queryMap.put("limit","10");

        return queryMap;
    }
}
