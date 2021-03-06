package com.vinpin.common.net

import com.vinpin.common.vo.*
import retrofit2.http.*

/**
 * <pre>
 *     author: vinpin
 *     time  : 2019/11/20 15:50
 *     desc  : Api 接口
 * </pre>
 */
interface ApiService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com/"
    }

    /**
     * 登录
     */
    @POST("user/login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): ApiResponse<UserInfo>


    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): ApiResponse<UserInfo>

    /**
     * 置顶文章
     */
    @GET("article/top/json")
    suspend fun getTopArticleList(): ApiResponse<List<Article>>

    /**
     * 首页文章列表
     * 参数：页码，拼接在连接中，从0开始。
     */
    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int): ApiResponse<ArticleList>

    /**
     * 首页banner
     */
    @GET("banner/json")
    suspend fun getBanner(): ApiResponse<List<BannerInfo>>

    /**
     * 收藏站内文章
     * 方法：POST
     * 参数：文章id，拼接在链接中。
     */
    @POST("lg/collect/{id}/json")
    suspend fun collect(@Path("id") id: Int): ApiResponse<String>

    /**
     * 取消收藏 文章列表
     * 方法：POST
     * 参数：id:拼接在链接上 id传入的是列表中文章的id。
     */
    @POST("lg/uncollect_originId/{id}/json")
    suspend fun uncollect(@Path("id") id: Int): ApiResponse<String>

    /**
     * 体系数据
     */
    @GET("tree/json")
    suspend fun getTreeList(): ApiResponse<List<ChapterInfo>>

    /**
     * 知识体系下的文章
     * 方法：GET
     * 参数：cid 分类的id，上述二级目录的id 页码：拼接在链接上，从0开始。
     */
    @GET("article/list/{page}/json")
    suspend fun getTreeArticleList(
        @Path("page") page: Int,
        @Query("cid") id: Int
    ): ApiResponse<ArticleList>

    /**
     * 获取公众号列表
     * 方法： GET
     */
    @GET("wxarticle/chapters/json")
    suspend fun getWxArticleChapters(): ApiResponse<List<ChapterInfo>>

    /**
     * 查看某个公众号历史数据
     * 方法：GET
     * 参数：公众号 ID：拼接在 url 中，eg:405 公众号页码：拼接在 url 中，eg:1
     */
    @GET("wxarticle/list/{id}/{page}/json")
    suspend fun getWxArticleList(
        @Path("id") id: Int,
        @Path("page") page: Int
    ): ApiResponse<ArticleList>

    /**
     * 项目分类
     * 方法： GET
     */
    @GET("project/tree/json")
    suspend fun getProjectChapters(): ApiResponse<List<ChapterInfo>>

    /**
     * 项目列表数据
     * 方法：GET
     * 参数：cid 分类的id，上面项目分类接口 页码：拼接在链接中，从1开始。
     */
    @GET("project/list/{page}/json")
    suspend fun getProjectArticleList(
        @Path("page") page: Int,
        @Query("cid") id: Int
    ): ApiResponse<ArticleList>
}