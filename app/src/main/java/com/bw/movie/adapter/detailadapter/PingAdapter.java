package com.bw.movie.adapter.detailadapter;
/*
 *@auther:段海涛
 *@Date: 2020-04-26
 *@Time:13:43
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
import com.bw.movie.bean.PingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PingAdapter extends RecyclerView.Adapter<PingAdapter.PingViewHolder> {

    private List<PingBean.ResultBean> list;
    private Context context;

    public PingAdapter(List<PingBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ping_layout, parent, false);
        return new PingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PingViewHolder holder, int position) {
        holder.sdvImage.setImageURI(list.get(position).getCommentHeadPic());
        holder.pingName.setText(list.get(position).getCommentUserName());
        holder.pingScore.setText(list.get(position).getScore()+""+"分");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd hh:mm");
        String format = simpleDateFormat.format(list.get(position).getCommentTime());
        holder.pingData.setText(format);
        holder.pingNr.setText(list.get(position).getCommentContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PingViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdv_image)
        SimpleDraweeView sdvImage;
        @BindView(R.id.ping_Name)
        TextView pingName;
        @BindView(R.id.ping_score)
        TextView pingScore;
        @BindView(R.id.ping_data)
        TextView pingData;
        @BindView(R.id.ping_nr)
        TextView pingNr;
        public PingViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
