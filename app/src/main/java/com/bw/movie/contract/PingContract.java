package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-04-26
 *@Time:13:36
 *@Description:${DESCRIPTION}
 **/

public interface PingContract {
    interface View extends IBaseView{
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void ping(int userId,String sessionId,int movieId,int page,int count,DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void ping(int userId,String sessionId,int movieId,int page,int count);
    }
}
