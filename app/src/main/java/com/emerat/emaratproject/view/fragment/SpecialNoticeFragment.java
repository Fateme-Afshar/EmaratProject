package com.emerat.emaratproject.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emerat.emaratproject.EmaratProjectApplication;
import com.emerat.emaratproject.R;
import com.emerat.emaratproject.adapter.DataAdapter;
import com.emerat.emaratproject.databinding.FragmentSpecialNoticeBinding;
import com.emerat.emaratproject.di.ApplicationContainer;

public class SpecialNoticeFragment extends Fragment {
    private FragmentSpecialNoticeBinding mBinding;
    private DataAdapter mAdapter;

    private ApplicationContainer mContainer;

    public SpecialNoticeFragment() {
        // Required empty public constructor
    }

    public static SpecialNoticeFragment newInstance() {
        SpecialNoticeFragment fragment = new SpecialNoticeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContainer = ((EmaratProjectApplication) getActivity().getApplication()).getApplicationContainer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding= DataBindingUtil.
                inflate(inflater,R.layout.fragment_special_notice,container,false);
        setupAdapter();
        return mBinding.getRoot();
    }

    private void setupAdapter() {
        mAdapter=new DataAdapter(getContext(),mContainer.getDataList());

        mBinding.recyclerView.setAdapter(mAdapter);

        mBinding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
    }
}