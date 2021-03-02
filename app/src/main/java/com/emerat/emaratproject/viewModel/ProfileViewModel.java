package com.emerat.emaratproject.viewModel;

import android.app.Application;
import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.emerat.emaratproject.model.User;
import com.emerat.emaratproject.repository.UserRepository;
import com.emerat.emaratproject.sharePref.EmaratProjectSharePref;

public class ProfileViewModel extends AndroidViewModel {
    private UserRepository mUserRepository;
    private User mUser;

    private String name="";
    private String address="";
    private String phone;
    private String telephone="";
    private String cityId;
    private String countryId;

    private LiveData<Boolean> mIsEditUser;

    public ProfileViewModel(@NonNull Application application, UserRepository userRepository) {
        super(application);
        mUserRepository = userRepository;
        mIsEditUser = userRepository.resultEdit();
        mUser = EmaratProjectSharePref.getUser(getApplication());
    }

    public void afterTextChangeName(Editable editable) {
            name = editable.toString();
    }

    public void afterTextChangeTelephone(Editable editable) {
            telephone = editable.toString();
    }

    public void setCountryCode(String countryCode) {
        mUser.setCountryId(countryCode);
    }

    public void setCityId(String cityId) {
        mUser.setCityId(cityId);
    }

    public void afterTextChangeAddress(Editable editable) {
            address = editable.toString();
    }

    public void onEditBtnClickListener() {
        User user = new User(name.equals("") ? name=mUser.getName() : name,
                mUser.getPhone(),telephone.equals("") ? name=mUser.getTelephone() : telephone,
                address.equals("") ? address=mUser.getAddress() : address,mUser.getCountryId(),mUser.getCityId());
        mUserRepository.editUser(mUser.getToken(), user);
    }

    public void onExitBtnClickListener() {
        mUserRepository.loginUser(mUser.getToken(), mUser);
    }

    public LiveData<Boolean> getIsEditUser() {
        return mUserRepository.resultEdit();
    }

    public User getUser() {
        return mUser;
    }
}
