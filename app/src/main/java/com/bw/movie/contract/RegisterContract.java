package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-04-21
 *@Time:21:14
 *@Description:${DESCRIPTION}
 **/

public interface RegisterContract {
    interface View extends IBaseView{
        void codeSuccess(Object obj);
        void codeFilter(String msg);

        void registerSuccess(Object obj);
        void registerFilter(String msg);
    }
    interface Model{
        void code(String email,CodeCallBack codeCallBack);
        interface CodeCallBack{
            void codeSuccess(Object obj);
            void codeFilter(String msg);
        }
        void register(String nickName,String pwd,String email,String code,RegisterCallBack callBack);
        interface RegisterCallBack{
            void registerSuccess(Object obj);
            void registerFilter(String msg);
        }
    }
    interface Presenter{
        void code(String email);
        void register(String nickName,String pwd,String email,String code);
    }
}
