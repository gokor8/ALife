package com.alife.data.services

import com.alife.data.interceptor.model.TokensModel
import com.alife.data.repository.registration.net_model.RequestCode
import com.alife.data.repository.registration.net_model.RequestRegistration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationService {

    @POST("/reg-log")
    suspend fun sendRegData(@Body body: RequestRegistration): Response<Unit>

    @POST("/check-email-code")
    suspend fun sendVerificationCode(@Body body: RequestCode): Response<TokensModel>
}