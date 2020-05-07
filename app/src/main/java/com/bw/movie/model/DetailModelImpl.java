package com.bw.movie.model;
/*
 *@auther:段海涛
 *@Date: 2020-04-25
 *@Time:21:22
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.App;
import com.bw.movie.api.Api;
import com.bw.movie.api.ApiService;
import com.bw.movie.bean.DetailBean;
import com.bw.movie.contract.DetailPageContract;
import com.bw.movie.dao.CacheDao;
import com.bw.movie.greendao.CacheDaoDao;
import com.bw.movie.util.RetrofitUtil;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class DetailModelImpl implements DetailPageContract.Model {
    @Override
    public void detail(int userId, String sessionId, int movieId, DetailCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<DetailBean> observable = apiService.getDetail(userId, sessionId, movieId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetailBean detailBean) {
                        callBack.success(detailBean);
                        Gson gson = new Gson();
                        String json = gson.toJson(detailBean);
                        CacheDao cacheDao = new CacheDao(Api.DETAILPAGEURL,json);
                        CacheDaoDao cacheDaoDao = App.daoSession.getCacheDaoDao();
                        cacheDaoDao.insertOrReplace(cacheDao);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.filter(e.getMessage());
                        CacheDaoDao cacheDaoDao = App.daoSession.getCacheDaoDao();
                        CacheDao cacheDao = cacheDaoDao.load(Api.DETAILPAGEURL);
                        if (cacheDao!=null){
                            Gson gson = new Gson();
                            DetailBean detailBean = gson.fromJson(cacheDao.getJson(), DetailBean.class);
                            callBack.success(detailBean);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
