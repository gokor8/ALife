package com.alife.data.services

import com.alife.data.repository.main.map.model.MapPostsDataModel
import retrofit2.http.GET

interface MapService {

    @GET("/allPostMap")
    suspend fun getMapPosts(): MapPostsDataModel
}