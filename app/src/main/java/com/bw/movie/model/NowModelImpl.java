package com.bw.movie.model;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:14:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.api.ApiService;
import com.bw.movie.bean.NowBean;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.contract.NowContract;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class NowModelImpl implements NowContract.Model {
    @Override
    public void now(int page, int count, NowListCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<NowBean> observable = apiService.getNow(page, count);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NowBean nowBean) {
                        callBack.nowSuccess(nowBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.nowFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
