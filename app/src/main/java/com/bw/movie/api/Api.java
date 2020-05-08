package com.bw.movie.api;
/*
 *@auther:段海涛
 *@Date: 2020-04-20
 *@Time:19:29
 *@Description:${DESCRIPTION}
 **/

public interface Api {
    String BASEURL = "http://mobile.bwstudent.com/movieApi/";
    String CODEURL = "user/v2/sendOutEmailCode";
    String REGISTER = "user/v2/register";
    String LOGINURL = "user/v2/login";
    /*
     * 正在上映
     * http://mobile.bwstudent.com/movieApi/movie/v2/findReleaseMovieList
     * */
    String NOWURL = "movie/v2/findReleaseMovieList";
    /*
    * 即将上映
    * http://mobile.bwstudent.com/movieApi/movie/v2/findComingSoonMovieList
    * */
    String GGURL = "movie/v2/findComingSoonMovieList";
    /*
    * 热门电影
    * http://mobile.bwstudent.com/movieApi/movie/v2/findHotMovieList
    * */
    String HOTURL = "movie/v2/findHotMovieList";

    /*
    * 电影详情
    * http://mobile.bwstudent.com/movieApi/movie/v2/findMoviesDetail
    * */
    String DETAILPAGEURL = "movie/v2/findMoviesDetail";

    /*
    * 电影评论
    * http://mobile.bwstudent.com/movieApi/movie/v2/findAllMovieComment*/
    String PINGLUNURL = "movie/v2/findAllMovieComment";

    /*
    * 推荐影院
    * http://mobile.bwstudent.com/movieApi/cinema/v1/findRecommendCinemas*/
    String RECOMMEND = "cinema/v1/findRecommendCinemas";

    /*
    * 附近影院
    * http://mobile.bwstudent.com/movieApi/cinema/v1/findNearbyCinemas*/
    String NEARURL  = "cinema/v1/findNearbyCinemas";

/*
    查询区域列表
    http://mobile.bwstudent.com/movieApi/tool/v2/findRegionList
*/
 String LEFTURL = "tool/v2/findRegionList";
    /*
    * 根据区域查询影院
    * http://mobile.bwstudent.com/movieApi/cinema/v2/findCinemaByRegion*/
    String RIGHTURL = "cinema/v2/findCinemaByRegion";

    /*
    * 查询影院详情
    * http://mobile.bwstudent.com/movieApi/cinema/v1/findCinemaInfo*/
    String CINEMADETAIL = "cinema/v1/findCinemaInfo";

    /*
     影院评价
     http://mobile.bwstudent.com/movieApi/cinema/v1/findAllCinemaComment
    * */
    String CINEMAEVALUATE = "cinema/v1/findAllCinemaComment";

}
