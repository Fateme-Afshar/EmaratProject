package com.emerat.emaratproject.di;

import com.emerat.emaratproject.factory.viewModelFactory.AddNoticeViewModelFactory;
import com.emerat.emaratproject.factory.viewModelFactory.NetworkViewModelFactory;
import com.emerat.emaratproject.factory.viewModelFactory.ProfileViewModelFactory;
import com.emerat.emaratproject.factory.viewModelFactory.SignInViewModelFactory;
import com.emerat.emaratproject.model.City;
import com.emerat.emaratproject.model.Country;
import com.emerat.emaratproject.model.data.Notice;
import com.emerat.emaratproject.repository.CityRepository;
import com.emerat.emaratproject.repository.CountryRepository;
import com.emerat.emaratproject.repository.NoticeRepository;
import com.emerat.emaratproject.repository.UserRepository;
import com.emerat.emaratproject.retrofit.RetrofitInstance;
import com.emerat.emaratproject.retrofit.RetrofitInterface;
import com.emerat.emaratproject.retrofit.gsonDeserializer.CityListDeserializer;
import com.emerat.emaratproject.retrofit.gsonDeserializer.CountryListDeserializer;
import com.emerat.emaratproject.viewModel.AddNoticeViewModel;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ApplicationContainer {

    private RetrofitInterface mRetrofitInterface =
            RetrofitInstance.getInstance().getRetrofit().create(RetrofitInterface.class);

    private UserRepository mUserRepository=UserRepository.getInstance(mRetrofitInterface);

    private CountryRepository mCountryRepository=CountryRepository.
            getInstance(createRetrofitInterface(new Country()));

    private CityRepository mCityRepository=CityRepository.getInstance(createRetrofitInterface(new City()));

    private NoticeRepository mNoticeRepository = NoticeRepository.getInstance(mRetrofitInterface);

    private AddNoticeViewModelFactory mAddNoticeViewModelFactory=
            new AddNoticeViewModelFactory(mNoticeRepository);

    private SignInViewModelFactory mSignInViewModelFactory=
            new SignInViewModelFactory(mUserRepository);

    private NetworkViewModelFactory mNetworkViewModelFactory=
            new NetworkViewModelFactory(mCountryRepository,mCityRepository, mNoticeRepository);

    private ProfileViewModelFactory mProfileViewModelFactory=
            new ProfileViewModelFactory(mUserRepository);

    public SignInViewModelFactory getSignInViewModelFactory() {
        return mSignInViewModelFactory;
    }

    public NetworkViewModelFactory getNetworkViewModelFactory() {
        return mNetworkViewModelFactory;
    }

    public AddNoticeViewModelFactory getAddNoticeViewModelFactory() {
        return mAddNoticeViewModelFactory;
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

    public UserRepository getUserRepository() {
        return mUserRepository;
    }

    public List<City> getCityList(){
        return mCityRepository.getCityList();
    }

    public List<Notice> getDataList(){
        return mNoticeRepository.getNotices();
    }

    @NotNull
    public List<String> getCountryNames() {
        List<String> countryNames=new ArrayList<>();
        for (Country country : getCountyList()) {
            countryNames.add(country.getName());
        }
        return countryNames;
    }

    @NotNull
    public  List<String> getCityNames() {
        List<String> cityNames=new ArrayList<>();
        for (City city :getCityList()) {
            cityNames.add(city.getTitle());
        }
        return cityNames;
    }
}
