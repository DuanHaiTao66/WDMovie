package com.bw.movie.model;
/*
 *@auther:段海涛
 *@Date: 2020-04-21
 *@Time:21:20
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.api.ApiService;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.RegisterContract;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RegisterModelImpl implements RegisterContract.Model {
    @Override
    public void code(String email, CodeCallBack codeCallBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<CodeBean> observable = apiService.getCode(email);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeBean codeBean) {
                        codeCallBack.codeSuccess(codeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        codeCallBack.codeFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void register(String nickName, String pwd, String email, String code, RegisterCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<RegisterBean> observable = apiService.getRegister(nickName, pwd, email, code);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        callBack.registerSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.registerFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
