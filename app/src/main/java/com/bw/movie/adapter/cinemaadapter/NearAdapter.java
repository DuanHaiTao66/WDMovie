package com.bw.movie.adapter.cinemaadapter;
/*
 *@auther:段海涛
 *@Date: 2020-05-05
 *@Time:14:44
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.NearBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NearAdapter extends RecyclerView.Adapter<NearAdapter.NearViewHolder> {

    private List<NearBean.ResultBean> list;
    private Context context;

    public NearAdapter(List<NearBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_near_layout, parent, false);
        return new NearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NearViewHolder holder, int position) {
        holder.nearSdv.setImageURI(list.get(position).getLogo());
        holder.nearName.setText(list.get(position).getName());
        holder.nearAddress.setText(list.get(position).getAddress());
        holder.nearKm.setText(list.get(position).getCommentTotal()+"km");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NearViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.near_sdv)
        SimpleDraweeView nearSdv;
        @BindView(R.id.near_name)
        TextView nearName;
        @BindView(R.id.near_address)
        TextView nearAddress;
        @BindView(R.id.near_km)
        TextView nearKm;
        public NearViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
