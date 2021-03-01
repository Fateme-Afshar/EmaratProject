package com.emerat.emaratproject.di;

import com.emerat.emaratproject.factory.viewModelFactory.NetworkViewModelFactory;
import com.emerat.emaratproject.factory.viewModelFactory.SignInViewModelFactory;
import com.emerat.emaratproject.model.City;
import com.emerat.emaratproject.model.Country;
import com.emerat.emaratproject.repository.CityRepository;
import com.emerat.emaratproject.repository.CountryRepository;
import com.emerat.emaratproject.repository.UserRepository;
import com.emerat.emaratproject.retrofit.RetrofitInstance;
import com.emerat.emaratproject.retrofit.RetrofitInterface;
import com.emerat.emaratproject.retrofit.gsonDeserializer.CityListDeserializer;
import com.emerat.emaratproject.retrofit.gsonDeserializer.CountryListDeserializer;
import com.emerat.emaratproject.viewModel.NetworkViewModel;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class ApplicationContainer {

    private RetrofitInterface mRetrofitInterface =
            RetrofitInstance.getInstance().getRetrofit().create(RetrofitInterface.class);

    private UserRepository mUserRepository=UserRepository.getInstance(mRetrofitInterface);

    private CountryRepository mCountryRepository=CountryRepository.
            getInstance(createRetrofitInterface(new Country()));

    private CityRepository mCityRepository=CityRepository.getInstance(createRetrofitInterface(new City()));

    private SignInViewModelFactory mSignInViewModelFactory=
            new SignInViewModelFactory(mUserRepository);

    private NetworkViewModelFactory mNetworkViewModelFactory=
            new NetworkViewModelFactory(mCountryRepository,mCityRepository);

    public SignInViewModelFactory getSignInViewModelFactory() {
        return mSignInViewModelFactory;
    }

    public NetworkViewModelFactory getNetworkViewModelFactory() {
        return mNetworkViewModelFactory;
    }

    private <T>  RetrofitInterface  createRetrofitInterface(T t){
        if (t instanceof Country)
            return RetrofitInstance.
                    getRetrofit(new TypeToken<List<Country>>(){}.getType(),
                            new CountryListDeserializer()).create(RetrofitInterface.class);
        else if (t instanceof City)
            return RetrofitInstance.
                    getRetrofit(new TypeToken<List<City>>(){}.getType(),
                            new CityListDeserializer()).create(RetrofitInterface.class);
        else
            return null;
    }

    public List<Country> getCountyList(){
        return mCountryRepository.getCountryList();
    }

    public List<City> getCityList(){
        return mCityRepository.getCityList();
    }
}
