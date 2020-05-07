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

import com.bw.movie.Event;
import com.bw.movie.R;
import com.bw.movie.bean.LeftBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHolder> {

    private List<LeftBean.ResultBean> list;
    private Context context;

    public LeftAdapter(List<LeftBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_left_layout, parent, false);
        return new LeftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolder holder, int position) {
        holder.leftName.setText(list.get(position).getRegionName());
        holder.leftName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int regionId = list.get(position).getRegionId();
                Event event = new Event();
                event.id = regionId;
                EventBus.getDefault().post(event);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LeftViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.left_Name)
        TextView leftName;
        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
