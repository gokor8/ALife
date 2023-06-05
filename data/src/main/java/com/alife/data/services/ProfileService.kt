package com.alife.data.services

import com.alife.data.repository.main.profile.ResponseProfileInfoModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileService {

    @GET("/profile")
    suspend fun getUserInfo(): ResponseProfileInfoModel

    @GET("/post-profile")
    suspend fun getPostProfile(@Query("username") username: String): ResponseProfileInfoModel
}