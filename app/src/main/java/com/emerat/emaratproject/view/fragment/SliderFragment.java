package com.emerat.emaratproject.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.FragmentSliderBinding;
import com.emerat.emaratproject.sliderSetting.adapter.SliderShowAdapter;

public class SliderFragment extends Fragment {
    private FragmentSliderBinding mBinding;

    private SliderFragmentCallback mCallback;

    public SliderFragment() {
        // Required empty public constructor
    }

    public static SliderFragment newInstance() {
        SliderFragment fragment = new SliderFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof SliderFragmentCallback)
            mCallback= (SliderFragmentCallback) context;
        else
            throw new ClassCastException("Must implementation SliderFragmentCallback interface");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.
                inflate(inflater,R.layout.fragment_slider,container,false);
        mBinding.setFragment(this);
        setupAdapter();
        return mBinding.getRoot();
    }

    private void setupAdapter() {
        SliderShowAdapter adapter = new SliderShowAdapter(getActivity());
        mBinding.slider.setSliderAdapter(adapter);
    }

    public SliderFragmentCallback getCallback() {
        return mCallback;
    }

    public interface SliderFragmentCallback{
        void onStartBtnClickListener();
    }
}