package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-04-21
 *@Time:19:40
 *@Description:${DESCRIPTION}
 **/

public interface LoginContract {
    interface View extends IBaseView{
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void login(String email,String pwd,DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void login(String email,String pwd);
    }
}
