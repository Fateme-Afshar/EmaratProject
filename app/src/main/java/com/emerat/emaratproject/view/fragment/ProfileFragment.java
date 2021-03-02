package com.emerat.emaratproject.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.emerat.emaratproject.EmaratProjectApplication;
import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.FragmentProfileBinding;
import com.emerat.emaratproject.di.ApplicationContainer;
import com.emerat.emaratproject.utils.UiUtils;
import com.emerat.emaratproject.viewModel.ProfileViewModel;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding mBinding;
    private ProfileViewModel mViewModel;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationContainer container=((EmaratProjectApplication) getActivity().getApplication()).getApplicationContainer();
        mViewModel=new ProfileViewModel(getActivity().getApplication(),container.getUserRepository());

        mViewModel.getIsEditUser().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isEdit) {
                if (isEdit)
                    UiUtils.createToast(getContext(),"Edit user successfully");
                else
                    UiUtils.createToast(getContext(),"cannot edit user");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.
                inflate(inflater,R.layout.fragment_profile, container, false);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }
}