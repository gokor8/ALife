package com.alife.data.services

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PartMap

interface UploadService {

    @Multipart
    @POST("/upload/photo")
    suspend fun sendPhotos(
        @PartMap photos: Map<String, RequestBody>
    ): Response<Unit>

    @Multipart
    @POST("/upload/video")
    suspend fun sendVideo(@Body video: MultipartBody.Part): Response<Unit>
}