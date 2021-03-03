package com.emerat.emaratproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.ItemDataViewBinding;
import com.emerat.emaratproject.model.data.DataItem;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Holder> {
    private Context mContext;
    private List<DataItem> mDataItemList;

    public DataAdapter(Context context, List<DataItem> dataItemList) {
        mContext = context;
        mDataItemList = dataItemList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDataViewBinding binding=
                DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_data_view,parent,false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding(mDataItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataItemList.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private ItemDataViewBinding mBinding;

        public Holder(@NonNull ItemDataViewBinding binding) {
            super(binding.getRoot());
            mBinding=binding;
        }

        public void binding(DataItem dataItem){
                mBinding.setDataItem(dataItem);
        }
    }
}
