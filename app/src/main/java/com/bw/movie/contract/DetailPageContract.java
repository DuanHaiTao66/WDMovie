package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-04-25
 *@Time:21:19
 *@Description:${DESCRIPTION}
 **/

public interface DetailPageContract {
    interface View extends IBaseView{
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void detail(int userId,String sessionId, int movieId,DetailCallBack callBack);
        interface DetailCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void detail(int userId,String sessionId,int movieId);
    }
}
