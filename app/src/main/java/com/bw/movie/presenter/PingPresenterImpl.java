package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-04-26
 *@Time:13:40
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.PingContract;
import com.bw.movie.model.PingModelImpl;

public class PingPresenterImpl extends BasePresenter<PingContract.View>implements PingContract.Presenter {

    private PingModelImpl model;

    @Override
    protected void initModel() {
        model = new PingModelImpl();
    }

    @Override
    public void ping(int userId, String sessionId, int movieId, int page, int count) {
        model.ping(userId, sessionId, movieId, page, count, new PingContract.Model.DataCallBack() {
            @Override
            public void success(Object obj) {
                getView().success(obj);
            }

            @Override
            public void filter(String msg) {
                getView().filter(msg);
            }
        });
    }
}
