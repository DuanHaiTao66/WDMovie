package com.bw.movie.adapter.detailadapter;
/*
 *@auther:段海涛
 *@Date: 2020-04-26
 *@Time:9:46
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
import com.bw.movie.bean.DetailBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GieShaoAdapter extends RecyclerView.Adapter<GieShaoAdapter.GieShaoViewHolder> {

    private List<DetailBean.ResultBean.MovieDirectorBean> list;
    private Context context;

    public GieShaoAdapter(List<DetailBean.ResultBean.MovieDirectorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public GieShaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_moviedirector_layout, parent, false);
        return new GieShaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GieShaoViewHolder holder, int position) {
        holder.daoSdv.setImageURI(list.get(position).getPhoto());
        holder.daoName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GieShaoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.dao_sdv)
        SimpleDraweeView daoSdv;
        @BindView(R.id.dao_name)
        TextView daoName;
        public GieShaoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
