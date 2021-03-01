package com.emerat.emaratproject.factory.viewModelFactory;

import com.emerat.emaratproject.factory.Factory;
import com.emerat.emaratproject.repository.CityRepository;
import com.emerat.emaratproject.repository.CountryRepository;
import com.emerat.emaratproject.viewModel.NetworkViewModel;

public class NetworkViewModelFactory implements Factory<NetworkViewModel> {
    private CountryRepository mCountryRepository;
    private CityRepository mCityRepository;

    public NetworkViewModelFactory(CountryRepository countryRepository, CityRepository cityRepository) {
        mCountryRepository = countryRepository;
        mCityRepository = cityRepository;
    }

    @Override
    public NetworkViewModel create() {
        return new NetworkViewModel(mCountryRepository,mCityRepository);
    }
}
