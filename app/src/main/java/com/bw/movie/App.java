package com.bw.movie;
/*
 *@auther:段海涛
 *@Date: 2020-04-21
 *@Time:20:09
 *@Description:${DESCRIPTION}
 **/

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.bw.movie.greendao.DaoMaster;
import com.bw.movie.greendao.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {
    public static Context context;
    public SharedPreferences sp;
    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        sp = context.getSharedPreferences("config", MODE_PRIVATE);
        Fresco.initialize(this);
        daoSession = DaoMaster.newDevSession(this, "bwmovie");
    }
}
