package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-05-08
 *@Time:14:51
 *@Description:${DESCRIPTION}
 **/

public interface CinemaDetailContract {
    interface View extends IBaseView{
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void cinemaDetail(int userId,String sessionId,int cinemaId,DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void cinemaDetail(int userId,String sessionId,int cinemaId);
    }
}
