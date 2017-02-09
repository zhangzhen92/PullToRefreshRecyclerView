package com.example.lzc.pullrefreshrecycleviewdemo.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lzc.pullrefreshrecycleviewdemo.R;

import java.util.List;

/**
 * 类描述：Recycleview适配器
 * 创建人：zz
 * 创建时间： 2017/2/9 17:14
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecycleViewHolder>{
    private List<String> datas;
    private Context context;

    public RecyclerAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }


    public void addAll(List<String> dd){
        datas.addAll(dd);
        notifyDataSetChanged();
    }


    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,null);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        if(!TextUtils.isEmpty(datas.get(position))){
           holder.textView.setText(datas.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }
}

 class RecycleViewHolder extends RecyclerView.ViewHolder{
    public TextView textView;
     public RecycleViewHolder(View itemView) {
        super(itemView);
        textView = ((TextView) itemView.findViewById(R.id.textview_id));
    }
}
