package com.alife.data.services

import com.alife.data.repository.main.home.child.model.CreatePostYetResponse
import com.alife.data.repository.main.home.child.model.PostsRequest
import com.alife.data.repository.main.home.child.model.PostsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MainService {

    @POST("/oleg-baran")
    fun getPosts(@Body request: PostsRequest): PostsResponse

    @GET("/oleg-pedic")
    fun createPostYet(): CreatePostYetResponse
}