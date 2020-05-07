package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-05-05
 *@Time:14:41
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.NearContract;
import com.bw.movie.model.NearModelImpl;

public class NearPresenterImpl extends BasePresenter<NearContract.View>implements NearContract.Presenter {

    private NearModelImpl model;

    @Override
    protected void initModel() {
        model = new NearModelImpl();
    }

    @Override
    public void near(int userId, String sessionId, int page, int count) {
        model.near(userId, sessionId, page, count, new NearContract.Model.DataCallBack() {
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
