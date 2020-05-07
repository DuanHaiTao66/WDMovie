package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-05-05
 *@Time:13:58
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.RecommendContract;
import com.bw.movie.model.RecommendModelImpl;

public class RecommendPresenterImpl extends BasePresenter<RecommendContract.View>implements RecommendContract.Presenter {

    private RecommendModelImpl model;

    @Override
    protected void initModel() {
        model = new RecommendModelImpl();
    }

    @Override
    public void recommend(int userId, String sessionId, int page, int count) {
        model.recommend(userId, sessionId, page, count, new RecommendContract.Model.DataCallBack() {
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
