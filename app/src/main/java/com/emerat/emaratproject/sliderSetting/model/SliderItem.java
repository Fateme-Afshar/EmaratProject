package com.emerat.emaratproject.sliderSetting.model;

public class SliderItem {
    private String mSliderTxt;
    private int mSliderImg;

    public SliderItem(String sliderTxt, int sliderImg) {
        mSliderTxt = sliderTxt;
        mSliderImg = sliderImg;
    }

    public String getSliderTxt() {
        return mSliderTxt;
    }

    public void setSliderTxt(String sliderTxt) {
        mSliderTxt = sliderTxt;
    }

    public int getSliderImg() {
        return mSliderImg;
    }

    public void setSliderImg(int sliderImg) {
        mSliderImg = sliderImg;
    }
}
