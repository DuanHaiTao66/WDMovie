package com.bw.movie.adapter.cinemadetailadapter;
/*
 *@auther:段海涛
 *@Date: 2020-05-08
 *@Time:18:50
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.CinemaDetailBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CinemaDetailAdapter extends RecyclerView.Adapter<CinemaDetailAdapter.CinemaViewHolder> {

    private CinemaDetailBean.ResultBean list;
    private Context context;

    public CinemaDetailAdapter(CinemaDetailBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CinemaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cinema_detail_layout, parent, false);
        return new CinemaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaViewHolder holder, int position) {
        holder.cinemaDetailAddress.setText(list.getAddress());
        holder.cinemaDetailPhone.setText(list.getPhone());
        holder.cinemDetailLuxian.setText(list.getVehicleRoute());
    }

    @Override
    public int getItemCount() {
        return list.getId();
    }

    class CinemaViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cinema_detail_address)
        TextView cinemaDetailAddress;
        @BindView(R.id.cinema_detail_phone)
        TextView cinemaDetailPhone;
        @BindView(R.id.cinem_detail_luxian)
        TextView cinemDetailLuxian;
        public CinemaViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
