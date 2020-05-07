package com.bw.movie.adapter;
/*
 *@auther:段海涛
 *@Date: 2020-04-23
 *@Time:15:38
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.DetailPageActivity;
import com.bw.movie.Event;
import com.bw.movie.MovieActivity;
import com.bw.movie.R;
import com.bw.movie.bean.GGBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GGAdapter extends RecyclerView.Adapter<GGAdapter.GGViewHolder> {
    public int OnClickItem = 0;
    private List<GGBean.ResultBean> list;
    private Context context;

    public GGAdapter(List<GGBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public GGViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gg_layout, parent, false);
        return new GGViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GGViewHolder holder, int position) {
        holder.jiSdv.setImageURI(list.get(position).getImageUrl());
        holder.jiMovieName.setText(list.get(position).getName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MMM-dd");
        String format = simpleDateFormat.format(list.get(position).getReleaseTime());
        holder.jiMovieScore.setText(format + "上映");
        holder.jiMovieLook.setText(list.get(position).getWantSeeNum() + "人想看");
        if (position == OnClickItem) {
            holder.btnYuYue.setText("已预约");
            holder.btnYuYue.setTextColor(Color.YELLOW);
        } else {
            holder.btnYuYue.setTextColor(Color.WHITE);
        }
        holder.btnYuYue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               OnClickItem  = position;
               notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GGViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ji_sdv)
        SimpleDraweeView jiSdv;
        @BindView(R.id.ji_movie_name)
        TextView jiMovieName;
        @BindView(R.id.ji_movie_score)
        TextView jiMovieScore;
        @BindView(R.id.ji_movie_look)
        TextView jiMovieLook;
        @BindView(R.id.btn_yu_yue)
        Button btnYuYue;
        public GGViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
