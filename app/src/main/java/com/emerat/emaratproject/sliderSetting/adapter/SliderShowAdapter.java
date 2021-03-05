package com.emerat.emaratproject.sliderSetting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.ItemSliderBinding;
import com.emerat.emaratproject.sliderSetting.model.SliderItem;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderShowAdapter extends SliderViewAdapter<SliderShowAdapter.SliderHolder> {
    private Context mContext;
    private List<SliderItem> mSliderItems=new ArrayList<>();

    public SliderShowAdapter(Context context) {
        mContext = context;

        mSliderItems.add(new SliderItem("com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior", R.drawable.slider_img_1));
        mSliderItems.add(new SliderItem("com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior ",R.drawable.slider_img_2));
        mSliderItems.add(new SliderItem("com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior",R.drawable.slider_img_3));
    }

    @Override
    public SliderHolder onCreateViewHolder(ViewGroup parent) {
        ItemSliderBinding binding= DataBindingUtil.
                inflate(LayoutInflater.from(mContext),R.layout.item_slider,parent,false);

        return new SliderHolder(binding);
    }

    @Override
    public void onBindViewHolder(SliderHolder viewHolder, int position) {
            viewHolder.binding(mSliderItems.get(position));
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    class SliderHolder extends SliderViewAdapter.ViewHolder{
        private ItemSliderBinding mBinding;

        public SliderHolder(ItemSliderBinding binding) {
            super(binding.getRoot());
            mBinding=binding;
        }

        private void binding(SliderItem sliderItem){
            mBinding.setSliderItem(sliderItem);
        }
    }
}
