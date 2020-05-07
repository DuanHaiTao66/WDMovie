package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:16:04
 *@Description:${DESCRIPTION}
 **/

public interface HotContract {
    interface View extends IBaseView{
        void hotSuccess(Object obj);
        void hotFilter(String msg);
    }
    interface Model{
        void hot(int page, int count, HotListCallBack callBack);
        interface HotListCallBack{
            void hotSuccess(Object obj);
            void hotFilter(String msg);
        }
    }
    interface Presenter{
        void hot(int page,int count);
    }
}
