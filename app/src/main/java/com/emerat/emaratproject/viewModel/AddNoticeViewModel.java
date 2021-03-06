package com.emerat.emaratproject.viewModel;

import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.model.data.Notice;
import com.emerat.emaratproject.repository.NoticeRepository;

public class AddNoticeViewModel extends ViewModel {
    private NoticeRepository mNoticeRepository;
    private Notice mNotice=new Notice();

    public AddNoticeViewModel(NoticeRepository noticeRepository) {
        mNoticeRepository = noticeRepository;
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
}
