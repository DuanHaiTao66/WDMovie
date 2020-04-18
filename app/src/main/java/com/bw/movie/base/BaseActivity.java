package com.bw.movie.base;
/*
 *@auther:段海涛
 *@Date: 2020-04-17
 *@Time:19:20
 *@Description:${DESCRIPTION}
 **/

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.movie.contract.IBaseView;

public abstract class BaseActivity <P extends BasePresenter>extends AppCompatActivity implements IBaseView {
    private P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        presenter = initPresenter();
        if (presenter!=null) {
            presenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null) {
            presenter.deatch();
        }
    }
}
