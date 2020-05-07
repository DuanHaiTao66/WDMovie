package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-05-05
 *@Time:13:54
 *@Description:${DESCRIPTION}
 **/

public interface RecommendContract {
    interface View extends IBaseView{
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void recommend(int userId,String sessionId,int page,int count,DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void recommend(int userId,String sessionId,int page,int count);
    }
}
