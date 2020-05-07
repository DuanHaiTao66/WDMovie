package com.bw.movie.adapter;
/*
 *@auther:段海涛
 *@Date: 2020-04-23
 *@Time:15:38
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
import com.bw.movie.bean.HotBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.HotViewHolder> {



    private List<HotBean.ResultBean> list;
    private Context context;

    public HotAdapter(List<HotBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hot_layout, parent, false);
        return new HotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotViewHolder holder, int position) {
        holder.hotSdv.setImageURI(list.get(position).getImageUrl());
        holder.hotmovieName.setText(list.get(position).getName());
        holder.hotmovieScore.setText(list.get(position).getScore()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HotViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hot_sdv)
        SimpleDraweeView hotSdv;
        @BindView(R.id.hotmovie_score)
        TextView hotmovieScore;
        @BindView(R.id.hotmovie_name)
        TextView hotmovieName;
        public HotViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
