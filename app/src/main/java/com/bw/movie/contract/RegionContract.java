package com.bw.movie.contract;
/*
 *@auther:段海涛
 *@Date: 2020-05-05
 *@Time:15:03
 *@Description:${DESCRIPTION}
 **/

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public interface RegionContract {
    interface View extends IBaseView{
        void leftSuccess(Object obj);
        void leftFilter(String msg);

        void rightSuccess(Object obj);
        void rightFilter(String msg);
    }
    interface Model{
        void left(LeftCallBack callBack);
        interface LeftCallBack{
            void leftSuccess(Object obj);
            void leftFilter(String msg);
        }
        void right(int regionId,RightCallBack callBack);
        interface RightCallBack{
            void rightSuccess(Object obj);
            void rightFilter(String msg);
        }
    }
    interface Presenter{
        void left();
        void right(int regionId);
    }
}
