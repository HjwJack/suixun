package com.suixun.hsh.api;

import com.suixun.hsh.base.ResultResponse;
import com.suixun.hsh.bean.News;
import com.suixun.hsh.bean.NewsDetail;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Love—Sun on 2017/6/29.
 */

public interface APINews {
    //baseUrl
//    String API_SERVER_URL = "http://192.168.0.116:88/";
    String HOST = "http://www.toutiao.com/";
    String API_SERVER_URL = HOST + "api/";

    String URL_ARTICLE_FEED = "api/article/recent/";
    String URL_COMMENT_LIST = "comment/list/";
    String HOST_VIDEO = "http://i.snssdk.com";
    String URL_VIDEO = "/video/urls/v/1/toutiao/mp4/%s?r=%s";


    /**
     * 获取新闻数据列表
     */
    @GET(URL_ARTICLE_FEED + "?source=2&as=A1C528E25E76FB8&cp=582EC64FEBD84E1")
    Observable<News> getNews(@Query("category") String category);

    /**
     * 获取评论数据
     *
     * @param group_id
     * @param item_id
     * @param offset
     * @param count
     * @return
     */
//    @GET(URL_COMMENT_LIST)
//    Observable<ResultResponse<CommentList>> getComment(@Query("group_id") String group_id, @Query("item_id") String item_id, @Query("offset") String offset, @Query("count") String count);

    /**
     * 获取新闻详情
     */
    @GET
    Observable<NewsDetail> getNewsDetail(@Url String url);


}
