package com.emerat.emaratproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.ItemDataViewBinding;
import com.emerat.emaratproject.model.data.Notice;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Holder> {
    private Context mContext;
    private List<Notice> mNoticeList;

    public DataAdapter(Context context, List<Notice> noticeList) {
        mContext = context;
        mNoticeList = noticeList;
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
        holder.binding(mNoticeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNoticeList.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private ItemDataViewBinding mBinding;

        public Holder(@NonNull ItemDataViewBinding binding) {
            super(binding.getRoot());
            mBinding=binding;
        }

        public void binding(Notice notice){
                mBinding.setNotice(notice);
        }
    }
}
