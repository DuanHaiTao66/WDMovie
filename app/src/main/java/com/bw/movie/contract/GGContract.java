package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:15:39
 *@Description:${DESCRIPTION}
 **/

public interface GGContract {
    interface View extends IBaseView{
        void ggSuccess(Object obj);
        void ggFilter(String msg);
    }
    interface Model{
        void gg(int page, int count,GGListCallBack callBack );
        interface GGListCallBack{
            void ggSuccess(Object obj);
            void ggFilter(String msg);
        }
    }
    interface Presenter{
        void gg(int page,int count);
    }
}
