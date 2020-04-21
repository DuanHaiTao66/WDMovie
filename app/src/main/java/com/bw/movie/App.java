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

public class App extends Application {
    public static Context context;
    public SharedPreferences sp;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        sp = context.getSharedPreferences("config", MODE_PRIVATE);
    }
}
