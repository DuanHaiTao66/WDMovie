package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-05-08
 *@Time:20:17
 *@Description:${DESCRIPTION}
 **/

public interface CinemaEvaluateContract {
    interface View extends IBaseView{
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void cinemaEvaluate(int userId,String sessionId,int cinemaId,int page,int count,DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void cinemaEvaluate(int userId,String sessionId,int cinemaId,int page,int count);
    }
}
