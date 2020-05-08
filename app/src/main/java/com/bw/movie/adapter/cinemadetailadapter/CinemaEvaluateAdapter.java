package com.bw.movie.adapter.cinemadetailadapter;
/*
 *@auther:段海涛
 *@Date: 2020-05-08
 *@Time:20:48
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
import com.bw.movie.bean.CinemaEvaluateBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CinemaEvaluateAdapter extends RecyclerView.Adapter<CinemaEvaluateAdapter.CinemaEvaluateViewHolder> {

    private List<CinemaEvaluateBean.ResultBean> list;
    private Context context;

    public CinemaEvaluateAdapter(List<CinemaEvaluateBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CinemaEvaluateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cinema_evaluate_layout, parent, false);
        return new CinemaEvaluateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaEvaluateViewHolder holder, int position) {
        holder.commentSdv.setImageURI(list.get(position).getCommentHeadPic());
        holder.commentName.setText(list.get(position).getCommentUserName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MMM-dd");
        String format = simpleDateFormat.format(list.get(position).getCommentTime());
        holder.commentTime.setText(format);
        holder.commentNr.setText(list.get(position).getCommentContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CinemaEvaluateViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.comment_sdv)
        SimpleDraweeView commentSdv;
        @BindView(R.id.comment_Name)
        TextView commentName;
        @BindView(R.id.comment_Time)
        TextView commentTime;
        @BindView(R.id.comment_nr)
        TextView commentNr;
        public CinemaEvaluateViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
