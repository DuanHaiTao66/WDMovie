package com.bw.movie.adapter.cinemaadapter;
/*
 *@auther:段海涛
 *@Date: 2020-05-05
 *@Time:14:03
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
import com.bw.movie.bean.RecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder> {

    private List<RecommendBean.ResultBean> list;
    private Context context;

    public RecommendAdapter(List<RecommendBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_layout, parent, false);
        return new RecommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendViewHolder holder, int position) {
        holder.recommendSdv.setImageURI(list.get(position).getLogo());
        holder.recommendName.setText(list.get(position).getName());
        holder.recommendAddress.setText(list.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recommend_sdv)
        SimpleDraweeView recommendSdv;
        @BindView(R.id.recommend_name)
        TextView recommendName;
        @BindView(R.id.recommend_address)
        TextView recommendAddress;
        public RecommendViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
