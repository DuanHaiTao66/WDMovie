package com.bw.movie.model;
/*
 *@auther:段海涛
 *@Date: 2020-05-08
 *@Time:20:31
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.api.ApiService;
import com.bw.movie.bean.CinemaEvaluateBean;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.contract.CinemaEvaluateContract;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class CinemaEvaluateModelImpl implements CinemaEvaluateContract.Model {

    @Override
    public void cinemaEvaluate(int userId, String sessionId, int cinemaId, int page, int count, DataCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<CinemaEvaluateBean> observable = apiService.getCinemaEvaluate(userId, sessionId, cinemaId, page, count);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaEvaluateBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaEvaluateBean cinemaEvaluateBean) {
                        callBack.success(cinemaEvaluateBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.filter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
