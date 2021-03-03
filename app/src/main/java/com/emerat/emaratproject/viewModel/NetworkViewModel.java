package com.emerat.emaratproject.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.repository.CityRepository;
import com.emerat.emaratproject.repository.CountryRepository;
import com.emerat.emaratproject.repository.DataRepository;

public class NetworkViewModel extends ViewModel {
    private CountryRepository mCountryRepository;
    private CityRepository mCityRepository;
    private DataRepository mDataRepository;
    private LiveData<Boolean> mIsReceiveCountry;
    private LiveData<Boolean> mIsReceiveCity;
    private LiveData<Boolean> mIsReceiveProducts;

    public NetworkViewModel(CountryRepository countryRepository, CityRepository cityRepository, DataRepository dataRepository) {
        mCountryRepository = countryRepository;
        mCityRepository=cityRepository;
        mDataRepository = dataRepository;

        mIsReceiveCountry=countryRepository.getIsReceive();
        mIsReceiveCity=cityRepository.getIsReceiveCity();
        mIsReceiveProducts= dataRepository.getIsReceiveProduct();
    }

    public void requestServerReceiveCounties(){
        mCountryRepository.requestToReceiveCountries();
    }

    public void requestServerReceiveCities(String countryId){
        mCityRepository.requestServerReceiveCities(countryId);
    }

    public void requestServerReceiveProducts(String countryId,String cityId){
        mDataRepository.requestServerReceiveProducts(countryId,cityId);
    }

    public LiveData<Boolean> getIsReceiveCountry() {
        return mIsReceiveCountry;
    }

    public LiveData<Boolean> getIsReceiveCity() {
        return mIsReceiveCity;
    }

    public LiveData<Boolean> getIsReceiveData() {
        return mIsReceiveProducts;
    }
}
