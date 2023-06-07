package com.alife.data.interceptor.mapper

import okhttp3.Request
import javax.inject.Inject

interface BaseRequestToAuthHeader {

    fun map(request: Request, accessToken: String): Request
}

class RequestToAuthHeader @Inject constructor() : BaseRequestToAuthHeader {

    private val headerAuth = "Authorization"

    override fun map(request: Request, accessToken: String): Request {
        return request.newBuilder()
            .removeHeader(headerAuth)
            .addHeader(headerAuth, accessToken)
            .build()
    }
}