package com.alife.data.core

import com.alife.data.interceptor.model.RetrofitAnnotation
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.RequestBody
import javax.inject.Inject

interface BaseTokenRequestFactory {
    fun create(refreshToken: String): Request
}

class TokenRequestFactory @Inject constructor(
    @RetrofitAnnotation.BaseUrl
    private val baseUrl: String
) : BaseTokenRequestFactory {

    private val refreshAuthTokenUrl = "$baseUrl/refresh"
    private val mediaType = "application/json; charset=utf-8"

    override fun create(jsonRefreshToken: String): Request {
        return Request.Builder()
            .url(refreshAuthTokenUrl)
            .post(RequestBody.create(MediaType.parse(mediaType), jsonRefreshToken))
            .build()
    }
}