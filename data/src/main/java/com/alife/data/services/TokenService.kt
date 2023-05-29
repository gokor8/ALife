package com.alife.data.services

import com.alife.data.interceptor.model.RequestRefreshModel
import com.alife.data.interceptor.model.TokensModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TokenService {

    @POST("/refresh")
    suspend fun sendRegData(@Body body: RequestRefreshModel): Response<TokensModel>
}