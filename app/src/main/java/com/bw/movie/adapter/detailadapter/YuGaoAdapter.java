package com.bw.movie.adapter.detailadapter;
/*
 *@auther:段海涛
 *@Date: 2020-04-26
 *@Time:12:59
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.DetailBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class YuGaoAdapter extends RecyclerView.Adapter<YuGaoAdapter.YuGaoViewHolder> {

    private List<DetailBean.ResultBean.ShortFilmListBean> list;
    private Context context;

    public YuGaoAdapter(List<DetailBean.ResultBean.ShortFilmListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public YuGaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_yugao_layout, parent, false);
        return new YuGaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YuGaoViewHolder holder, int position) {
        holder.jcvMv.setUp(list.get(position).getVideoUrl(),"预告"+"("+(position+1)+")");
        Glide.with(context).load(list.get(position).getVideoUrl()).into(holder.jcvMv.ivThumb);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class YuGaoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.jcv_mv)
        JCVideoPlayer jcvMv;
        public YuGaoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
