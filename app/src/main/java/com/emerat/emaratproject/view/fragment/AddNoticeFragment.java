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
import com.emerat.emaratproject.databinding.FragmentAddNoticeBinding;
import com.emerat.emaratproject.di.ApplicationContainer;
import com.emerat.emaratproject.utils.SpinnerUtils;
import com.emerat.emaratproject.viewModel.AddNoticeViewModel;
import com.emerat.emaratproject.viewModel.NetworkViewModel;


public class AddNoticeFragment extends Fragment {
    private FragmentAddNoticeBinding mBinding;
    private NetworkViewModel mNetworkViewModel;
    private AddNoticeViewModel mAddNoticeViewModel;
    private ApplicationContainer mContainer;

    public AddNoticeFragment() {
        // Required empty public constructor
    }
    
    public static AddNoticeFragment newInstance() {
        AddNoticeFragment fragment = new AddNoticeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContainer=((EmaratProjectApplication)getActivity().getApplication()).getApplicationContainer();
        mNetworkViewModel=mContainer.getNetworkViewModelFactory().create();
        mAddNoticeViewModel=mContainer.getAddNoticeViewModelFactory().create();

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
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.
                inflate(inflater,R.layout.fragment_add_notice,container,false);
        return mBinding.getRoot();
    }

    private void setupCountrySpinner() {
        ArrayAdapter<String> userArrayAdapter= new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, mContainer.getCountryNames());
        mBinding.spCountry.setAdapter(userArrayAdapter);

        mBinding.spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String countryName=adapterView.getItemAtPosition(position).toString();
                String countryId=SpinnerUtils.getUserSelectedCountryId(adapterView,position,mContainer.getCountyList());

                mAddNoticeViewModel.setCountryName(countryName);
                mAddNoticeViewModel.setCountryId(countryId);

                mNetworkViewModel.requestServerReceiveCities(countryId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setupCitySpinner() {
        ArrayAdapter<String> userArrayAdapter=new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,mContainer.getCityNames());
        mBinding.spCity.setAdapter(userArrayAdapter);

        mBinding.spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cityName=parent.getItemAtPosition(position).toString();
                String cityId=SpinnerUtils.getUserSelectedCityId(parent,position,mContainer.getCityList());

                mAddNoticeViewModel.setCityName(cityName);
                mAddNoticeViewModel.setCityId(cityId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}