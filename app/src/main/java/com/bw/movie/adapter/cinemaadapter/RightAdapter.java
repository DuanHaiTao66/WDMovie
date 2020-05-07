package com.bw.movie.adapter.cinemaadapter;
/*
 *@auther:段海涛
 *@Date: 2020-05-05
 *@Time:15:18
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
import com.bw.movie.bean.RightBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {


    private List<RightBean.ResultBean> list;
    private Context context;

    public RightAdapter(List<RightBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_right_layout, parent, false);
        return new RightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder, int position) {
        holder.rightName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RightViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.right_Name)
        TextView rightName;
        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
