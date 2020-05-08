package com.bw.movie.model;
/*
 *@auther:段海涛
 *@Date: 2020-05-08
 *@Time:17:26
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.api.ApiService;
import com.bw.movie.bean.CinemaDetailBean;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class CinemaDetailModelImpl implements CinemaDetailContract.Model {
    @Override
    public void cinemaDetail(int userId, String sessionId, int cinemaId, DataCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<CinemaDetailBean> observable = apiService.getCinemaDetail(userId, sessionId, cinemaId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaDetailBean cinemaDetailBean) {
                        callBack.success(cinemaDetailBean);
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
