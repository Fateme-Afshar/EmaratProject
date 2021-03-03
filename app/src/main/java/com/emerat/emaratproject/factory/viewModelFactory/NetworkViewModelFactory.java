package com.emerat.emaratproject.factory.viewModelFactory;

import com.emerat.emaratproject.factory.Factory;
import com.emerat.emaratproject.repository.CityRepository;
import com.emerat.emaratproject.repository.CountryRepository;
import com.emerat.emaratproject.repository.DataRepository;
import com.emerat.emaratproject.viewModel.NetworkViewModel;

public class NetworkViewModelFactory implements Factory<NetworkViewModel> {
    private CountryRepository mCountryRepository;
    private CityRepository mCityRepository;
    private DataRepository mDataRepository;

    public NetworkViewModelFactory(CountryRepository countryRepository, CityRepository cityRepository, DataRepository dataRepository) {
        mCountryRepository = countryRepository;
        mCityRepository = cityRepository;
        mDataRepository = dataRepository;
    }

    @Override
    public NetworkViewModel create() {
        return new NetworkViewModel(mCountryRepository,mCityRepository, mDataRepository);
    }
}
