package com.emerat.emaratproject.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.emerat.emaratproject.EmaratProjectApplication;
import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.FragmentSignInBinding;
import com.emerat.emaratproject.di.ApplicationContainer;
import com.emerat.emaratproject.viewModel.SignInViewModel;

public class SignInFragment extends Fragment {
    private FragmentSignInBinding mBinding;
    private SignInViewModel mViewModel;

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
        ApplicationContainer container= EmaratProjectApplication.getApplicationContainer();
        mViewModel=container.getSignInViewModelFactory().create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding= DataBindingUtil.
                inflate(inflater,R.layout.fragment_sign_in, container, false);
        mBinding.setViewModel(mViewModel);

        if (mViewModel.resultPost())
            Toast.makeText(getContext(),"User Post Successfully",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getContext(),"Post failed",Toast.LENGTH_LONG).show();

        return mBinding.getRoot();
    }
}