package com.bw.movie.fragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-17
 *@Time:15:14
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.LoginActivity;
import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;

import butterknife.BindView;

public class MyFragment extends BaseFragment {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_head)
    ImageView ivHead;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView(View inflate) {
        String head = getActivity().getIntent().getStringExtra("head");
        Glide.with(getActivity()).load(head).into(ivHead);
        initListener();
    }

    private void initListener() {
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.my_fragment;
    }

    @Override
    protected void initData() {

    }
}
