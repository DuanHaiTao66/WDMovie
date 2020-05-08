package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-05-08
 *@Time:20:32
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.contract.CinemaEvaluateContract;
import com.bw.movie.model.CinemaEvaluateModelImpl;

public class CinemaEvaluatePresenterImpl extends BasePresenter<CinemaEvaluateContract.View>implements CinemaEvaluateContract.Presenter {


    private CinemaEvaluateModelImpl model;

    @Override
    protected void initModel() {
        model = new CinemaEvaluateModelImpl();
    }

    @Override
    public void cinemaEvaluate(int userId, String sessionId, int cinemaId, int page, int count) {
       model.cinemaEvaluate(userId, sessionId, cinemaId, page, count, new CinemaEvaluateContract.Model.DataCallBack() {
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
