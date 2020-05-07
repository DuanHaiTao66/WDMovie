package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:14:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.contract.NowContract;
import com.bw.movie.model.NowModelImpl;

public class NowPresenterImpl extends BasePresenter<NowContract.View>implements NowContract.Presenter {

    private NowModelImpl model;

    @Override
    protected void initModel() {
        model = new NowModelImpl();
    }

    @Override
    public void now(int page, int count) {
        model.now(page, count, new NowContract.Model.NowListCallBack() {
            @Override
            public void nowSuccess(Object obj) {
                getView().nowSuccess(obj);
            }

            @Override
            public void nowFilter(String msg) {
                getView().nowFilter(msg);
            }
        });
    }
}
