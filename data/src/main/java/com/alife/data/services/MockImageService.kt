package com.alife.data.services

import com.alife.data.repository.main.home.child.model.MockImageResponse
import retrofit2.http.GET

interface MockImageService {

    @GET("https://random-d.uk/api/v2/random")
    suspend fun getImage(): MockImageResponse
}