package com.emerat.emaratproject.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.repository.CountryRepository;

public class NetworkViewModel extends ViewModel {
    private CountryRepository mCountryRepository;
    private LiveData<Boolean> mIsReceiveCountry;

    public NetworkViewModel(CountryRepository countryRepository) {
        mCountryRepository = countryRepository;
        mIsReceiveCountry=countryRepository.getIsReceive();
    }

    public void requestServerReceiveCounties(){
        mCountryRepository.requestToReceiveCountries();
    }

    public void requestServerReceiveCities(String countryId){
        //TODO: REQUEST TO SERVER FOR RECEIVE CITIES EVERY COUNTRY
    }

    public LiveData<Boolean> getIsReceiveCountry() {
        return mIsReceiveCountry;
    }
}
