package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-04-21
 *@Time:19:43
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.LoginContract;
import com.bw.movie.model.LoginModelImpl;

public class LoginPresenterImpl extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private LoginModelImpl model;

    @Override
    protected void initModel() {
        model = new LoginModelImpl();
    }

    @Override
    public void login(String email, String pwd) {
        model.login(email, pwd, new LoginContract.Model.DataCallBack() {
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
