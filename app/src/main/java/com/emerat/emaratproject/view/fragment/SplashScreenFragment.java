package com.emerat.emaratproject.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emerat.emaratproject.EmaratProjectApplication;
import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.FragmentSplashScreenBinding;
import com.emerat.emaratproject.di.ApplicationContainer;
import com.emerat.emaratproject.viewModel.NetworkViewModel;

public class SplashScreenFragment extends Fragment {
    private FragmentSplashScreenBinding mBinding;
    private NetworkViewModel mNetworkViewModel;

    private SplashScreenFragmentCallback mCallback;

    public SplashScreenFragment() {
        // Required empty public constructor
    }

    public static SplashScreenFragment newInstance() {
        SplashScreenFragment fragment = new SplashScreenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof  SplashScreenFragmentCallback)
            mCallback= (SplashScreenFragmentCallback) context;

            //throw new ClassCastException("Must implementation SplashScreenFragmentCallback interface");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationContainer container=((EmaratProjectApplication)getActivity().getApplication()).getApplicationContainer();
        mNetworkViewModel= container.getNetworkViewModelFactory().create();

        setupLoadingCountry();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       mBinding= DataBindingUtil.
               inflate(inflater,R.layout.fragment_splash_screen,container,false);

        return mBinding.getRoot();
    }

    private void setupLoadingCountry() {
        mNetworkViewModel.requestServerReceiveCounties();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCallback.showSliderPage();
            }
        },3000);

        /*mNetworkViewModel.getIsReceiveCountry().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                mCallback.startMainActivity();
            }
        });*/
    }

    public interface SplashScreenFragmentCallback{
        void showSliderPage();
    }
}