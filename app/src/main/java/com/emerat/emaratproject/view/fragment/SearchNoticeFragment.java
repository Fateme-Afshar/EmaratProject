package com.emerat.emaratproject.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.emerat.emaratproject.EmaratProjectApplication;
import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.FragmentSearchNoticeBinding;
import com.emerat.emaratproject.di.ApplicationContainer;
import com.emerat.emaratproject.utils.SpinnerUtils;
import com.emerat.emaratproject.viewModel.NetworkViewModel;

public class SearchNoticeFragment extends Fragment {
    private FragmentSearchNoticeBinding mBinding;
    private NetworkViewModel mNetworkViewModel;
    private ApplicationContainer mContainer;
    private String mCountryId="";
    private String mCityId="";

    public SearchNoticeFragment() {
        // Required empty public constructor
    }

    public static SearchNoticeFragment newInstance() {
        SearchNoticeFragment fragment = new SearchNoticeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContainer=((EmaratProjectApplication) getActivity().getApplication()).getApplicationContainer();

        mNetworkViewModel=mContainer.getNetworkViewModelFactory().create();

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding= DataBindingUtil.
                inflate(inflater,R.layout.fragment_search_notice,container,false);
        mBinding.setFragment(this);
        mBinding.setViewModel(mNetworkViewModel);
      return mBinding.getRoot();
    }

    private void setupCountrySpinner() {
        ArrayAdapter<String> countryArrayAdapter=new ArrayAdapter<>(getActivity(),R.layout.custom_text_spinner,mContainer.getCountryNames());

        mBinding.spCountry.setAdapter(countryArrayAdapter);

        mBinding.spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCountryId=SpinnerUtils.getUserSelectedCountryId(parent,position,mContainer.getCountyList());
                mNetworkViewModel.requestServerReceiveCities(mCountryId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setupCitySpinner() {
        ArrayAdapter<String> cityArrayAdapter=new ArrayAdapter<>(getActivity(),R.layout.custom_text_spinner,mContainer.getCityNames());

        mBinding.spCity.setAdapter(cityArrayAdapter);

        mBinding.spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCityId=SpinnerUtils.getUserSelectedCityId(parent,position,mContainer.getCityList());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public String getCountryId() {
        return mCountryId;
    }

    public void setCountryId(String countryId) {
        mCountryId = countryId;
    }

    public String getCityId() {
        return mCityId;
    }

    public void setCityId(String cityId) {
        mCityId = cityId;
    }
}