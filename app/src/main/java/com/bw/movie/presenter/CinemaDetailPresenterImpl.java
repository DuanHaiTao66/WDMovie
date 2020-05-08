package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-05-08
 *@Time:17:27
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.model.CinemaDetailModelImpl;

public class CinemaDetailPresenterImpl extends BasePresenter<CinemaDetailContract.View>implements CinemaDetailContract.Presenter {

    private CinemaDetailModelImpl model;

    @Override
    protected void initModel() {
        model = new CinemaDetailModelImpl();
    }

    @Override
    public void cinemaDetail(int userId, String sessionId, int cinemaId) {
        model.cinemaDetail(userId, sessionId, cinemaId, new CinemaDetailContract.Model.DataCallBack() {
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
