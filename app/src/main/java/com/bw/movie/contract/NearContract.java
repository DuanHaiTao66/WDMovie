package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-05-05
 *@Time:14:36
 *@Description:${DESCRIPTION}
 **/

public interface NearContract {
    interface View extends IBaseView{
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void near(int userId,String sessionId,int page,int count,DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void near(int userId,String sessionId,int page,int count);
    }
}
