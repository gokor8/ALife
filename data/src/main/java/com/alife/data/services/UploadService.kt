package com.alife.data.services

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface UploadService {

    @Multipart
    @POST("/upload/photo")
    suspend fun sendPhotos(
        @PartMap photos: @JvmSuppressWildcards Map<@JvmSuppressWildcards String, RequestBody>
    ): Response<Unit>

    @Multipart
    @Headers("Content-Type: multipart/form-data")
    @POST("/upload/video")
    suspend fun sendVideo(@Part video: MultipartBody.Part): Response<Unit>
}