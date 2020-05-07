package com.bw.movie.adapter.detailadapter;
/*
 *@auther:段海涛
 *@Date: 2020-04-26
 *@Time:13:14
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.DetailBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuZhaoAdapter extends RecyclerView.Adapter<GuZhaoAdapter.GuZhaoViewHolder> {

    private List<DetailBean.ResultBean.ShortFilmListBean> list;
    private Context context;

    public GuZhaoAdapter(List<DetailBean.ResultBean.ShortFilmListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public GuZhaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_juzhao_layout, parent, false);
        return new GuZhaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuZhaoViewHolder holder, int position) {
        holder.juzhaoSdv.setImageURI(list.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GuZhaoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.juzhao_sdv)
        SimpleDraweeView juzhaoSdv;
        public GuZhaoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
