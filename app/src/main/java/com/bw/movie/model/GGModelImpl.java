package com.bw.movie.model;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:15:41
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.api.ApiService;
import com.bw.movie.bean.GGBean;
import com.bw.movie.contract.GGContract;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class GGModelImpl implements GGContract.Model {

    @Override
    public void gg(int page, int count, GGListCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<GGBean> observable = apiService.getGG(page, count);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GGBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GGBean ggBean) {
                        callBack.ggSuccess(ggBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.ggFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
