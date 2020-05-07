package com.bw.movie.adapter.detailadapter;
/*
 *@auther:段海涛
 *@Date: 2020-04-26
 *@Time:10:11
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

public class YanYuanAdapter extends RecyclerView.Adapter<YanYuanAdapter.YanYuanViewHolder> {

    private List<DetailBean.ResultBean.MovieActorBean> list;
    private Context context;

    public YanYuanAdapter(List<DetailBean.ResultBean.MovieActorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public YanYuanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_yanyuan_layout, parent, false);
        return new YanYuanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YanYuanViewHolder holder, int position) {
        holder.yanyuanSdv.setImageURI(list.get(position).getPhoto());
        holder.yanyuanName.setText(list.get(position).getName());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class YanYuanViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.yanyuan_sdv)
        SimpleDraweeView yanyuanSdv;
        @BindView(R.id.yanyuan_name)
        TextView yanyuanName;
        public YanYuanViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
