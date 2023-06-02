package com.alife.data.services

import com.alife.data.repository.main.home.child.model.CreatePostYetResponse
import com.alife.data.repository.main.home.child.model.PostsRequest
import com.alife.data.repository.main.home.child.model.PostsResponse
import retrofit2.Response
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

    @GET("/checkAlLifePost")
    fun getIsHavePostToday(): Response<Unit>

    @GET("/oleg-pedic")
    fun createPostYet(): CreatePostYetResponse
}