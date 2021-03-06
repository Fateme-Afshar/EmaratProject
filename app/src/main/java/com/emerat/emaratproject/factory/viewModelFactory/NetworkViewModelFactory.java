package com.emerat.emaratproject.factory.viewModelFactory;

import com.emerat.emaratproject.factory.Factory;
import com.emerat.emaratproject.repository.CityRepository;
import com.emerat.emaratproject.repository.CountryRepository;
import com.emerat.emaratproject.repository.NoticeRepository;
import com.emerat.emaratproject.viewModel.NetworkViewModel;

public class NetworkViewModelFactory implements Factory<NetworkViewModel> {
    private CountryRepository mCountryRepository;
    private CityRepository mCityRepository;
    private NoticeRepository mNoticeRepository;

    public NetworkViewModelFactory(CountryRepository countryRepository, CityRepository cityRepository, NoticeRepository noticeRepository) {
        mCountryRepository = countryRepository;
        mCityRepository = cityRepository;
        mNoticeRepository = noticeRepository;
    }

    @Override
    public NetworkViewModel create() {
        return new NetworkViewModel(mCountryRepository,mCityRepository, mNoticeRepository);
    }
}
