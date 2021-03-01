package com.emerat.emaratproject.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.repository.CityRepository;
import com.emerat.emaratproject.repository.CountryRepository;

public class NetworkViewModel extends ViewModel {
    private CountryRepository mCountryRepository;
    private CityRepository mCityRepository;
    private LiveData<Boolean> mIsReceiveCountry;
    private LiveData<Boolean> mIsReceiveCity;

    public NetworkViewModel(CountryRepository countryRepository,CityRepository cityRepository) {
        mCountryRepository = countryRepository;
        mCityRepository=cityRepository;

        mIsReceiveCountry=countryRepository.getIsReceive();
        mIsReceiveCity=cityRepository.getIsReceiveCity();
    }

    public void requestServerReceiveCounties(){
        mCountryRepository.requestToReceiveCountries();
    }

    public void requestServerReceiveCities(String countryId){
        mCityRepository.requestServerReceiveCities(countryId);
    }

    public LiveData<Boolean> getIsReceiveCountry() {
        return mIsReceiveCountry;
    }

    public LiveData<Boolean> getIsReceiveCity() {
        return mIsReceiveCity;
    }
}
