package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:16:11
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.HotContract;
import com.bw.movie.model.HotModelImpl;

public class HotPresenterImpl extends BasePresenter<HotContract.View>implements HotContract.Presenter {

    private HotModelImpl model;

    @Override
    protected void initModel() {
        model = new HotModelImpl();
    }

    @Override
    public void hot(int page, int count) {
        model.hot(page, count, new HotContract.Model.HotListCallBack() {
            @Override
            public void hotSuccess(Object obj) {
                getView().hotSuccess(obj);
            }

            @Override
            public void hotFilter(String msg) {
                getView().hotFilter(msg);
            }
        });
    }
}
