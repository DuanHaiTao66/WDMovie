package com.bw.movie.api;
/*
 *@auther:段海涛
 *@Date: 2020-04-20
 *@Time:19:36
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST(Api.CODEURL)
    Observable<CodeBean>getCode(@Field("email") String email);

    @FormUrlEncoded
    @POST(Api.REGISTER)
    Observable<RegisterBean>getRegister(@Field("nickName")String nickName,
                                        @Field("pwd")String pwd,
                                        @Field("email")String email,
                                        @Field("code")String code);
    @FormUrlEncoded
    @POST(Api.LOGINURL)
    Observable<LoginBean>getLogin(@Field("email")String email,
                                  @Field("pwd")String pwd);


}
