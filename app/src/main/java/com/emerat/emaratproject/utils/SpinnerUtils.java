package com.emerat.emaratproject.utils;

import android.widget.AdapterView;

import com.emerat.emaratproject.model.City;
import com.emerat.emaratproject.model.Country;

import java.util.List;

public class SpinnerUtils {

    public static String getUserSelectedCountryId(AdapterView<?> adapterView, int position, List<Country> countryList) {
        String name = adapterView.getItemAtPosition(position).toString();

        String countyId = "";
        for (Country country : countryList) {
            if (country.getName().equals(name))
                countyId = country.getId();
        }
        return countyId;
    }

    public static String getUserSelectedCityId(AdapterView<?> adapterView, int position, List<City> cityList) {
        String cityName = adapterView.getItemAtPosition(position).toString();

        String cityId = "";
        for (City city : cityList) {
            if (city.getTitle().equals(cityName))
                cityId = city.getId();
        }
        return cityId;
    }
}
