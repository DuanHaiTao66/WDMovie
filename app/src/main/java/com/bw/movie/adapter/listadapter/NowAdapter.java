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
import com.bw.movie.bean.NowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NowAdapter extends RecyclerView.Adapter<NowAdapter.NowViewHolder> {


    private List<NowBean.ResultBean> list;
    private Context context;

    public NowAdapter(List<NowBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_now_list_layout, parent, false);
        return new NowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NowViewHolder holder, int position) {
        holder.nowSdv.setImageURI(list.get(position).getImageUrl());
        holder.nowMovieName.setText(list.get(position).getName());
        holder.nowMovieDao.setText("导演:"+list.get(position).getDirector());
        holder.nowMovieZhu.setText("主演:"+list.get(position).getStarring());
        holder.nowMoviePing.setText("评分:"+list.get(position).getScore()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NowViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.now_sdv)
        SimpleDraweeView nowSdv;
        @BindView(R.id.now_movie_name)
        TextView nowMovieName;
        @BindView(R.id.now_movie_dao)
        TextView nowMovieDao;
        @BindView(R.id.now_movie_zhu)
        TextView nowMovieZhu;
        @BindView(R.id.now_movie_ping)
        TextView nowMoviePing;
        public NowViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
