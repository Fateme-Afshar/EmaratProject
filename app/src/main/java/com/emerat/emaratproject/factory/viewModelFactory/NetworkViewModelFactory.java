package com.emerat.emaratproject.factory.viewModelFactory;

import com.emerat.emaratproject.factory.Factory;
import com.emerat.emaratproject.repository.CountryRepository;
import com.emerat.emaratproject.viewModel.NetworkViewModel;

public class NetworkViewModelFactory implements Factory<NetworkViewModel> {
    private CountryRepository mRepository;

    public NetworkViewModelFactory(CountryRepository repository) {
        mRepository = repository;
    }

    @Override
    public NetworkViewModel create() {
        return new NetworkViewModel(mRepository);
    }
}
