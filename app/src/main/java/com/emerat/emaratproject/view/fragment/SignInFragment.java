package com.emerat.emaratproject.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.emerat.emaratproject.EmaratProjectApplication;
import com.emerat.emaratproject.R;

import com.emerat.emaratproject.databinding.FragmentSignInBinding;
import com.emerat.emaratproject.di.ApplicationContainer;
import com.emerat.emaratproject.model.City;
import com.emerat.emaratproject.model.Country;
import com.emerat.emaratproject.sharePref.EmaratProjectSharePref;
import com.emerat.emaratproject.utils.ProgramUtils;
import com.emerat.emaratproject.viewModel.NetworkViewModel;
import com.emerat.emaratproject.viewModel.SignInViewModel;

import java.util.ArrayList;
import java.util.List;

public class SignInFragment extends Fragment{
    private FragmentSignInBinding mBinding;
    private SignInViewModel mViewModel;
    private NetworkViewModel mNetworkViewModel;

    public SignInFragment() {
        // Required empty public constructor
    }

    public static SignInFragment newInstance() {
        SignInFragment fragment = new SignInFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationContainer container= ((EmaratProjectApplication) getActivity().getApplication()).getApplicationContainer();
        mViewModel=container.getSignInViewModelFactory().create();
        mNetworkViewModel=container.getNetworkViewModelFactory().create();

        mNetworkViewModel.requestServerReceiveCounties();

        mNetworkViewModel.getIsReceiveCountry().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                setupCountrySpinner();
            }
        });

        mNetworkViewModel.getIsReceiveCity().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                setupCitySpinner();
            }
        });

        mViewModel.getIsPost().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean result) {
                if (result)
                    Log.d(ProgramUtils.TAG, "User post successfully");
                else
                    Log.d(ProgramUtils.TAG,"cannot user post");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding= DataBindingUtil.
                inflate(inflater,R.layout.fragment_sign_in, container, false);
        mBinding.setViewModel(mViewModel);

        return mBinding.getRoot();
    }

    private void setupCountrySpinner() {
        List<String> countryNames=new ArrayList<>();
        for (Country country :
                new ApplicationContainer().getCountyList()) {
            countryNames.add(country.getName());
        }

        ArrayAdapter<String> userArrayAdapter= new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, countryNames);
        mBinding.spCountry.setAdapter(userArrayAdapter);

        mBinding.spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String name=adapterView.getItemAtPosition(position).toString();

                String countyId="";
                for (Country country :
                        new ApplicationContainer().getCountyList()) {
                    if (country.getName().equals(name))
                        countyId=country.getId();
                }
                mViewModel.setCountryCode(countyId);
                mNetworkViewModel.requestServerReceiveCities(countyId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setupCitySpinner() {
        List<String> cityNames=new ArrayList<>();
        for (City city :
                new ApplicationContainer().getCityList()) {
            cityNames.add(city.getTitle());
        }

        ArrayAdapter<String> userArrayAdapter= new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, cityNames);
        mBinding.spCity.setAdapter(userArrayAdapter);

        mBinding.spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String cityName=adapterView.getItemAtPosition(position).toString();

                String cityId="";
                for (City city :
                        new ApplicationContainer().getCityList()) {
                    if (city.getTitle().equals(cityName))
                        cityId=city.getId();
                }
                mViewModel.setCityId(cityId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}