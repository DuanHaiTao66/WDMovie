package com.bw.movie.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-04-21
 *@Time:21:21
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.RegisterContract;
import com.bw.movie.model.RegisterModelImpl;

public class RegisterPresenterImpl extends BasePresenter<RegisterContract.View>implements RegisterContract.Presenter {

    private RegisterModelImpl model;

    @Override
    protected void initModel() {
        model = new RegisterModelImpl();
    }

    @Override
    public void code(String email) {
        model.code(email, new RegisterContract.Model.CodeCallBack() {
            @Override
            public void codeSuccess(Object obj) {
                getView().codeSuccess(obj);
            }

            @Override
            public void codeFilter(String msg) {
                getView().codeFilter(msg);
            }
        });
    }

    @Override
    public void register(String nickName, String pwd, String email, String code) {
        model.register(nickName, pwd, email, code, new RegisterContract.Model.RegisterCallBack() {
            @Override
            public void registerSuccess(Object obj) {
                getView().registerSuccess(obj);
            }

            @Override
            public void registerFilter(String msg) {
                getView().registerFilter(msg);
            }
        });
    }
}
