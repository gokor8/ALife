package com.alife.data.services

import com.alife.data.repository.main.home.child.model.PostsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET("/feed")
    suspend fun getPosts(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): PostsResponse

    @GET("/friend-feed")
    suspend fun getFriendPosts(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): PostsResponse

    @GET("/checkAlLifePost")
    suspend fun getIsHavePostToday(): Response<Unit>
}