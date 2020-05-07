package com.bw.movie.adapter.listadapter;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:15:08
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_hot_list_layout, parent, false);
        return new HotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotViewHolder holder, int position) {
        holder.reSdv.setImageURI(list.get(position).getImageUrl());
        holder.reMovieName.setText(list.get(position).getName());
        holder.reMovieDao.setText("导演:"+list.get(position).getDirector());
        holder.reMovieZhu.setText("主演:"+list.get(position).getStarring());
        holder.reMoviePing.setText(list.get(position).getScore()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HotViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.re_sdv)
        SimpleDraweeView reSdv;
        @BindView(R.id.re_movie_name)
        TextView reMovieName;
        @BindView(R.id.re_movie_dao)
        TextView reMovieDao;
        @BindView(R.id.re_movie_zhu)
        TextView reMovieZhu;
        @BindView(R.id.re_movie_ping)
        TextView reMoviePing;
        public HotViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
