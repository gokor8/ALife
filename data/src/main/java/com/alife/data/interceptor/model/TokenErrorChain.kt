package com.alife.data.interceptor.model

import com.alife.core.chain.ChainHandler
import com.alife.domain.core.exception_global.RefreshTokenDied
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import javax.inject.Inject


interface BaseTokenErrorChain : ChainHandler.Base<TokenErrorChainModel, Response>

class RefreshTokenErrorChain @Inject constructor(
    private val gson: Gson
) : BaseTokenErrorChain {

    private val refreshAuthTokenUrl = "/refresh" // TODO Add baseUrl maybe?

    override fun handle(inputModel: TokenErrorChainModel) = with(inputModel) {

        val request = Request.Builder()
            .url(refreshAuthTokenUrl)
            .post(
                RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"),
                    gson.toJson(RequestRefreshModel(refreshToken))
                )
            )
            .build()

        chain.proceed(request).takeIf { response ->
            response.isSuccessful
        } ?: throw RefreshTokenDied()
    }
}