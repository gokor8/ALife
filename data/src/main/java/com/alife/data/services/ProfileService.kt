package com.alife.data.services

import com.alife.data.repository.main.profile.model.RequestProfileSaveData
import com.alife.data.repository.main.profile.model.ResponseProfileInfoModel
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfileService {

    @GET("/profile")
    suspend fun getUserInfo(): ResponseProfileInfoModel

    @GET("/profile/{username}")
    suspend fun getPostProfile(@Path("username") username: String): ResponseProfileInfoModel

    @PUT("/profile")
    suspend fun saveUserData(
        @Body requestProfileSaveData: RequestProfileSaveData
    ): Response<Unit>

    @Multipart
    @POST("/profile/avatar_upload")
    suspend fun saveAvatar(
        @Part avatar: MultipartBody.Part
    ): Response<Unit>
}