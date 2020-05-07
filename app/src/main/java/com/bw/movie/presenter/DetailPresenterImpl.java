package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-04-25
 *@Time:21:23
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.DetailPageContract;
import com.bw.movie.model.DetailModelImpl;

public class DetailPresenterImpl extends BasePresenter<DetailPageContract.View>implements DetailPageContract.Presenter {

    private DetailModelImpl model;

    @Override
    protected void initModel() {
        model = new DetailModelImpl();
    }

    @Override
    public void detail(int userId, String sessionId, int movieId) {
        model.detail(userId, sessionId, movieId, new DetailPageContract.Model.DetailCallBack() {
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
