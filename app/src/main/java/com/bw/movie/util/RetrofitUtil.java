package com.bw.movie.util;
/*
 *@auther:段海涛
 *@Date: 2020-04-20
 *@Time:19:44
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.SharedPreferences;

import com.bw.movie.App;
import com.bw.movie.api.Api;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    public OkHttpClient okHttpClient;
    public Retrofit retrofit;
    public static RetrofitUtil instance = null;
    private RetrofitUtil(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(
                        okHttpClient = new OkHttpClient.Builder()
                                .readTimeout(5, TimeUnit.SECONDS)
                                .connectTimeout(5,TimeUnit.SECONDS)
                                .writeTimeout(5,TimeUnit.SECONDS)
                                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                                .addInterceptor(new Interceptor() {
                                    @NotNull
                                    @Override
                                    public Response intercept(@NotNull Chain chain) throws IOException {
                                        Request request = chain.request();
                                        Request.Builder builder = request.newBuilder();
                                        SharedPreferences sp = App.context.getSharedPreferences("config", Context.MODE_PRIVATE);
                                        int userId = sp.getInt("userId", -1);
                                        if (userId!=-1){
                                            builder.addHeader("userId",userId+"");
                                        }
                                        String sessionId = sp.getString("sessionId", null);
                                        if (sessionId!=null){
                                            builder.addHeader("sessionId",sessionId);
                                        }
                                        Request build = builder.build();
                                        return chain.proceed(build);
                                    }
                                })
                                .build()
                )
                .build();
    }
    public static synchronized RetrofitUtil getInstance(){
        if (instance==null){
            instance = new RetrofitUtil();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
