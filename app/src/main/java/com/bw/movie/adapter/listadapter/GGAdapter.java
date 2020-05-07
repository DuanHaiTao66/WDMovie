package com.bw.movie.adapter.listadapter;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:15:08
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.DetailPageActivity;
import com.bw.movie.Event;
import com.bw.movie.R;
import com.bw.movie.bean.GGBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GGAdapter extends RecyclerView.Adapter<GGAdapter.GGViewHolder> {
    private List<GGBean.ResultBean> list;
    private Context context;
    public GGAdapter(List<GGBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public GGViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gg_list_layout, parent, false);
        return new GGViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GGViewHolder holder, int position) {
        holder.ggSdv.setImageURI(list.get(position).getImageUrl());
        holder.ggMovieName.setText(list.get(position).getName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MMM-dd");
        String format = simpleDateFormat.format(list.get(position).getReleaseTime());
        holder.ggMovieTime.setText(format+"上映");
        holder.ggMovieLook.setText(list.get(position).getWantSeeNum()+"人想看");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, DetailPageActivity.class);
                        intent.putExtra("movieId",list.get(position).getMovieId());
                        context.startActivity(intent);
                    }
                });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GGViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.gg_sdv)
        SimpleDraweeView ggSdv;
        @BindView(R.id.gg_movie_name)
        TextView ggMovieName;
        @BindView(R.id.gg_movie_time)
        TextView ggMovieTime;
        @BindView(R.id.gg_movie_look)
        TextView ggMovieLook;
        public GGViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
