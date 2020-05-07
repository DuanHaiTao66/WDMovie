package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-04-22
 *@Time:14:47
 *@Description:${DESCRIPTION}
 **/

public interface HomeContract {
    interface View extends IBaseView{
        void nowSuccess(Object obj);
        void nowFilter(String msg);

        void ggSuccess(Object obj);
        void ggFilter(String msg);

        void hotSuccess(Object obj);
        void hotFilter(String msg);
    }
    interface Model{
        void now(int page,int count,NowCallBack callBack);
        interface NowCallBack{
            void nowSuccess(Object obj);
            void nowFilter(String msg);
        }
        void gg(int page, int count, GGCallBack callBack);
        interface GGCallBack{
            void ggSuccess(Object obj);
            void ggFilter(String msg);
        }
        void hot(int page, int count, HotCallBack callBack);
        interface HotCallBack{
            void hotSuccess(Object obj);
            void hotFilter(String msg);
        }
    }
    interface Presenter{
        void now(int page,int count);
        void gg(int page,int count);
        void hot(int page,int count);
    }
}
