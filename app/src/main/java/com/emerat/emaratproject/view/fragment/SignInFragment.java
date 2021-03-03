package com.emerat.emaratproject.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.emerat.emaratproject.EmaratProjectApplication;
import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.FragmentSignInBinding;
import com.emerat.emaratproject.di.ApplicationContainer;
import com.emerat.emaratproject.model.PostResponse;
import com.emerat.emaratproject.sharePref.EmaratProjectSharePref;
import com.emerat.emaratproject.utils.ProgramUtils;
import com.emerat.emaratproject.utils.SpinnerUtils;
import com.emerat.emaratproject.viewModel.NetworkViewModel;
import com.emerat.emaratproject.viewModel.SignInViewModel;

import java.util.List;

public class SignInFragment extends Fragment{
    private FragmentSignInBinding mBinding;
    private SignInViewModel mViewModel;
    private NetworkViewModel mNetworkViewModel;
    private ApplicationContainer mContainer;
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
        mContainer =((EmaratProjectApplication) getActivity().getApplication()).getApplicationContainer();
        mViewModel = mContainer.getSignInViewModelFactory().create();
        mNetworkViewModel = mContainer.getNetworkViewModelFactory().create();

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

        mViewModel.getIsPost().observe(this, new Observer<PostResponse>() {
            @Override
            public void onChanged(PostResponse postResponse) {
                if (!postResponse.equals(null)) {
                    Log.d(ProgramUtils.TAG, "User post successfully");
                    mViewModel.getUser().setToken("Bearer "+postResponse.getToken());
                    EmaratProjectSharePref.saveUser(getContext(),mViewModel.getUser());
                }
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

        ArrayAdapter<String> userArrayAdapter= new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, mContainer.getCountryNames());
        mBinding.spCountry.setAdapter(userArrayAdapter);

        mBinding.spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String countyId = SpinnerUtils.getUserSelectedCountryId(adapterView, position,mContainer.getCountyList());
                mViewModel.setCountryCode(countyId);
                mNetworkViewModel.requestServerReceiveCities(countyId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setupCitySpinner() {

        ArrayAdapter<String> userArrayAdapter= new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, mContainer.getCityNames());
        mBinding.spCity.setAdapter(userArrayAdapter);

        mBinding.spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String cityId = SpinnerUtils.getUserSelectedCityId(adapterView, position,mContainer.getCityList());
                mViewModel.setCityId(cityId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}