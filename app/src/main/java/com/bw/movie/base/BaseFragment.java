package com.bw.movie.base;
/*
 *@auther:段海涛
 *@Date: 2020-04-17
 *@Time:15:06
 *@Description:${DESCRIPTION}
 **/

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.movie.R;
import com.bw.movie.contract.IBaseView;

import butterknife.ButterKnife;

public abstract class BaseFragment<P extends BasePresenter>extends Fragment implements IBaseView {
    protected P presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(initLayout(), null);
        presenter = initPresenter();
        if (presenter!=null) {
            presenter.attach(this);
        }
        ButterKnife.bind(this,inflate);
        initView(inflate);
        return inflate;
    }

    protected abstract P initPresenter();

    protected abstract void initView(View inflate);

    protected abstract int initLayout();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null) {
            presenter.deatch();
        }
    }
}
