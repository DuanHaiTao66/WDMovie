package com.bw.movie.model;
/*
 *@auther:段海涛
 *@Date: 2020-04-21
 *@Time:19:42
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.api.ApiService;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.contract.LoginContract;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class LoginModelImpl implements LoginContract.Model {
    @Override
    public void login(String email, String pwd, DataCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<LoginBean> observable = apiService.getLogin(email, pwd);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.success(loginBean);
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
