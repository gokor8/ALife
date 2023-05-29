package com.alife.data.services

import com.alife.data.repository.main.home.child.model.CreatePostYetResponse
import com.alife.data.repository.main.home.child.model.PostsRequest
import com.alife.data.repository.main.home.child.model.PostsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MainService {

    @GET("/feed")
    suspend fun getPosts(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): PostsResponse

    @POST("/oleg-baran")
    fun getPosts1(@Body request: PostsRequest): PostsResponse

    @GET("/oleg-pedic")
    fun createPostYet(): CreatePostYetResponse
}