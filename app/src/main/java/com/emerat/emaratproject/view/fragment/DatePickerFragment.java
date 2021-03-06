package com.emerat.emaratproject.view.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.FragmentDatePickerBinding;
import com.emerat.emaratproject.viewModel.DatePickerViewModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePickerFragment extends DialogFragment {
    public static final String ARG_CURRENT_DATE = "Current Date";
    public static final String EXTRA_USER_SELECTED_DATE =
            "com.emerat.emaratproject.view.fragment.userSelectedDate";
    private FragmentDatePickerBinding mBinding;

    private DatePickerViewModel mDatePickerViewModel;

    private Date mCurrentDate;
    public DatePickerFragment() {
        // Required empty public constructor
    }

    public static DatePickerFragment newInstance(Date currentDate) {
        DatePickerFragment fragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CURRENT_DATE,currentDate);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments()!=null)
            mCurrentDate= (Date) getArguments().
                    getSerializable(ARG_CURRENT_DATE);

        mDatePickerViewModel=new ViewModelProvider(this).get(DatePickerViewModel.class);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        mBinding= DataBindingUtil.inflate(inflater,
                R.layout.fragment_date_picker,
                null,
                false);
        initDatePicker();
        return  new AlertDialog.Builder(getActivity()).
                setTitle(R.string.date_picker_title).
                setIcon(R.mipmap.ic_launcher).
                setView(mBinding.getRoot()).
                setPositiveButton(android.R.string.ok, (dialogInterface, i) -> {
                    Date datePicked = getSelectedDateFromDatePicker();
                    setResult(datePicked);
                }).
                setNegativeButton(android.R.string.cancel, null).
                create();
    }

    private void initDatePicker() {
        //convert date to calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mCurrentDate);

        int year = calendar.get(Calendar.YEAR);
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        mBinding.datePicker.init(year, monthOfYear, dayOfMonth, null);
    }

    private Date getSelectedDateFromDatePicker() {
        int year = mBinding.datePicker.getYear();
        int monthOfYear = mBinding.datePicker.getMonth();
        int dayOfMonth = mBinding.datePicker.getDayOfMonth();

        GregorianCalendar gregorianCalendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);
        return gregorianCalendar.getTime();
    }

    private void setResult(Date userSelectedDate) {
        Fragment targetFragment = this.getTargetFragment();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_USER_SELECTED_DATE, userSelectedDate);
        targetFragment.onActivityResult(this.getTargetRequestCode(), Activity.RESULT_OK, intent);
    }
}