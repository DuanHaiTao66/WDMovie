package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:14:51
 *@Description:${DESCRIPTION}
 **/

public interface NowContract {
    interface View extends IBaseView{
        void nowSuccess(Object obj);
        void nowFilter(String msg);
    }
    interface Model{
        void now(int page, int count, NowListCallBack callBack);
        interface NowListCallBack{
            void nowSuccess(Object obj);
            void nowFilter(String msg);
        }
    }
    interface Presenter{
        void now(int page,int count);
    }
}
