package com.bw.movie.api;
/*
 *@auther:段海涛
 *@Date: 2020-04-20
 *@Time:19:36
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.DetailBean;
import com.bw.movie.bean.GGBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.LeftBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.NearBean;
import com.bw.movie.bean.NowBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.RightBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
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


    @GET(Api.NOWURL)
    Observable<NowBean>getNow(@Query("page")int page,@Query("count")int count);

    @GET(Api.GGURL)
    Observable<GGBean>getGG(@Query("page")int page, @Query("count")int count);

    @GET(Api.HOTURL)
    Observable<HotBean>getHot(@Query("page")int page, @Query("count")int count);

    @GET(Api.DETAILPAGEURL)
    Observable<DetailBean>getDetail(@Header("userId") int userId,
                                    @Header("sessionId") String sessionId,
                                    @Query("movieId") int movieId);

    @GET(Api.PINGLUNURL)
    Observable<PingBean>getPing(@Header("userId") int userId,
                                @Header("sessionId") String sessionId,
                                @Query("movieId") int movieId,
                                @Query("page") int page,
                                @Query("count")int count);

    @GET(Api.RECOMMEND)
    Observable<RecommendBean>getRecommend(@Header("userId")int userId,
                                          @Header("sessionId")String sessionId,
                                          @Query("page") int page,
                                          @Query("count") int count );
    @GET(Api.NEARURL)
    Observable<NearBean>getNear(@Header("userId")int userId,
                                @Header("sessionId")String sessionId,
                                @Query("page") int page,
                                @Query("count") int count );
    @GET(Api.LEFTURL)
    Observable<LeftBean>getLeft();

    @GET(Api.RIGHTURL)
    Observable<RightBean>getRight(@Query("regionId") int regionId);
}
