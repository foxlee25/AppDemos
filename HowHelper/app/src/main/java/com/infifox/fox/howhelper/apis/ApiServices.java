package com.infifox.fox.howhelper.apis;

/**
 * Created by jili on 10/27/16.
 */
import com.infifox.fox.howhelper.bean.CardBackBean;
import com.infifox.fox.howhelper.bean.CardBean;
import com.infifox.fox.howhelper.bean.GithubBean;
import com.infifox.fox.howhelper.bean.StartImg;

import retrofit2.http.GET;
import retrofit2.http.Headers;

import rx.Observable;

public interface ApiServices {

    /**
     * game api will use later , first just use Zhihu API for study
     */

//
//    String HOST = "https://omgvamp-hearthstone-v1.p.mashape.com/";
//
//    String HOST2 = "https://api.github.com/";
//
//    /**
//     * HS card infos
//     */
//    @Headers("X-Mashape-Key: vnyskU48lSmshHOcUpJOe1dFteWxp1t3mvzjsnJVO7QuHLPmEu")
//    @GET("/cards")
//    Observable<CardBean> getCardData();
//
//
////    @GET("/repos/jasonrudolph/keyboard")
////    Observable<GithubBean> getGitData();
//
//    @GET("users/foxlee25")
//    Observable<GithubBean> getGitData();
//
////    @GET("/enUS/{filename}")
////    Observable<CardBackBean> getCardBack(@Path(""));
////    @Headers("X-Mashape-Key: vnyskU48lSmshHOcUpJOe1dFteWxp1t3mvzjsnJVO7QuHLPmEu")
//    @GET("cardbacks")
//    Observable<CardBackBean> getCardBack();

    // slash img for slash page
    //http://news-at.zhihu.com/api/4/start-image/1080*1776
    @GET("start-image/1080*1776")
    Observable<StartImg> getStarImg();


}

