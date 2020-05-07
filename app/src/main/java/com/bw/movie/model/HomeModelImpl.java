package com.bw.movie.model;
/*
 *@auther:段海涛
 *@Date: 2020-04-22
 *@Time:14:52
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.App;
import com.bw.movie.api.Api;
import com.bw.movie.api.ApiService;
import com.bw.movie.bean.GGBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.NowBean;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.dao.CacheDao;
import com.bw.movie.greendao.CacheDaoDao;
import com.bw.movie.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class HomeModelImpl implements HomeContract.Model {

    @Override
    public void now(int page, int count, NowCallBack callBack) {
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
                        Gson gson = new Gson();
                        String json = gson.toJson(nowBean);
                        CacheDao cacheDao = new CacheDao(Api.HOTURL,json);
                        CacheDaoDao cacheDaoDao = App.daoSession.getCacheDaoDao();
                        cacheDaoDao.insertOrReplace(cacheDao);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.nowFilter(e.getMessage());
                        CacheDaoDao cacheDaoDao = App.daoSession.getCacheDaoDao();
                        CacheDao cacheDao = cacheDaoDao.load(Api.HOTURL);
                        if (cacheDao!=null){
                            Gson gson = new Gson();
                            NowBean nowBean = gson.fromJson(cacheDao.getJson(), NowBean.class);
                            callBack.nowSuccess(nowBean);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void gg(int page, int count, GGCallBack callBack) {
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
                        Gson gson = new Gson();
                        String json = gson.toJson(ggBean);
                        CacheDao cacheDao = new CacheDao(Api.HOTURL,json);
                        CacheDaoDao cacheDaoDao = App.daoSession.getCacheDaoDao();
                        cacheDaoDao.insertOrReplace(cacheDao);
                    }
                    @Override
                    public void onError(Throwable e) {
                        callBack.ggFilter(e.getMessage());
                        CacheDaoDao cacheDaoDao = App.daoSession.getCacheDaoDao();
                        CacheDao cacheDao = cacheDaoDao.load(Api.HOTURL);
                        if (cacheDao!=null){
                            Gson gson = new Gson();
                            GGBean ggBean = gson.fromJson(cacheDao.getJson(), GGBean.class);
                            callBack.ggSuccess(ggBean);
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void hot(int page, int count, HotCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<HotBean> observable = apiService.getHot(page, count);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        callBack.hotSuccess(hotBean);
                        Gson gson = new Gson();
                        String json = gson.toJson(hotBean);
                        CacheDao cacheDao = new CacheDao(Api.HOTURL,json);
                        CacheDaoDao cacheDaoDao = App.daoSession.getCacheDaoDao();
                        cacheDaoDao.insertOrReplace(cacheDao);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.hotFilter(e.getMessage());
                        CacheDaoDao cacheDaoDao = App.daoSession.getCacheDaoDao();
                        CacheDao cacheDao = cacheDaoDao.load(Api.HOTURL);
                        Gson gson = new Gson();
                        HotBean hotBean = gson.fromJson(cacheDao.getJson(), HotBean.class);
                        callBack.hotSuccess(hotBean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
