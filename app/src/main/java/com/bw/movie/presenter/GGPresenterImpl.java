package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:15:42
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.GGContract;
import com.bw.movie.model.GGModelImpl;

public class GGPresenterImpl extends BasePresenter<GGContract.View>implements GGContract.Presenter {

    private GGModelImpl model;

    @Override
    protected void initModel() {
        model = new GGModelImpl();
    }

    @Override
    public void gg(int page, int count) {
        model.gg(page, count, new GGContract.Model.GGListCallBack() {
            @Override
            public void ggSuccess(Object obj) {
                getView().ggSuccess(obj);
            }

            @Override
            public void ggFilter(String msg) {
                getView().ggFilter(msg);
            }
        });
    }
}
