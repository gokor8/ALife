package com.alife.data.interceptor

import com.alife.core.chain.ChainHandler
import okhttp3.Response
import javax.inject.Inject


interface BaseTokenErrorChain : ChainHandler.Base<TokenErrorChainModel, Response>

class TokenErrorChain @Inject constructor(
    private val errorAuthToken: BaseTokenErrorChain
) : BaseTokenErrorChain {

    override fun handle(inputModel: TokenErrorChainModel): Response {
        val request = inputModel.chain.request()
        val response = inputModel.chain.proceed(request)

        return when(response.code()) {
            403 -> errorAuthToken.handle(inputModel)
            404 -> throw RefreshTokenDied()
            else -> response
        }
    }
}

class AuthTokenErrorChain @Inject constructor() : BaseTokenErrorChain {

    private val refreshAuthTokenUrl = "/refresh" // TODO Add baseUrl maybe?

    override fun handle(inputModel: TokenErrorChainModel): Response = with(inputModel) {

        // TODO Add to body refresh token
        val request = chain.request().newBuilder().url(refreshAuthTokenUrl).build()
        // TODO Add to body refresh token
        val response = chain.proceed(request)

        if(!response.isSuccessful) throw RefreshTokenDied()

        return response
    }
}