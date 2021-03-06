package com.emerat.emaratproject.viewModel;

import android.text.Editable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.model.data.Notice;
import com.emerat.emaratproject.repository.NoticeRepository;

public class AddNoticeViewModel extends ViewModel {
    private NoticeRepository mNoticeRepository;
    private Notice mNotice=new Notice();

    private MutableLiveData<String> onSelectedBtn =new MutableLiveData<>();

    public AddNoticeViewModel(NoticeRepository noticeRepository) {
        mNoticeRepository = noticeRepository;
    }

    public void afterTextChangeTitle(Editable editable){
        mNotice.setTitle(editable.toString());
    }

    public void afterTextChangeAbout(Editable editable){
        mNotice.setAbout(editable.toString());
    }

    public void afterTextChangeAddress(Editable editable){
        mNotice.setAddress(editable.toString());
    }

    public void afterTextChangeTelephone(Editable editable){
        mNotice.setTelePhone(editable.toString());
    }

    public void afterTextChangeOffer(Editable editable){
        mNotice.setOffer(Integer.parseInt(editable.toString()));
    }

    public void onDatePickerSelected(){
        onSelectedBtn.setValue("date picker");
    }

    public void onLocationSelected(){
        onSelectedBtn.setValue("location");
    }

    public void setCountryName(String countryName){
        mNotice.setCountryText(countryName);
    }

    public void setCountryId(String countryId){
        mNotice.setCountry(countryId);
    }

    public void setCityName(String cityName){
        mNotice.setCityText(cityName);
    }

    public void setCityId(String cityId){
        mNotice.setCity(cityId);
    }

    public void setUserSelectedDate(String dateFormat){
        mNotice.setDateOfEx(dateFormat);
    }

    public LiveData<String> getOnSelectedBtn() {
        return onSelectedBtn;
    }
}
