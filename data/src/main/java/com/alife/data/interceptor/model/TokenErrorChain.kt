package com.alife.data.interceptor.model

import com.alife.core.addons.JsonWrapper
import com.alife.core.chain.ChainHandler
import com.alife.domain.core.exception_global.RefreshTokenDied
import com.alife.domain.registration.usecase.token.BaseTokensUseCase
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import javax.inject.Inject


interface BaseTokenErrorChain : ChainHandler.BaseSuspend<TokenErrorChainModel, Response>

class RefreshTokenErrorChain @Inject constructor(
    private val tokensUseCase: BaseTokensUseCase,
    private val jsonWrapper: JsonWrapper,
    @RetrofitAnnotation.BaseUrl
    baseUrl: String
) : BaseTokenErrorChain {

    private val refreshAuthTokenUrl = "$baseUrl/refresh"
    private val mediaType = "application/json; charset=utf-8"

    override suspend fun handle(inputModel: TokenErrorChainModel) = with(inputModel) {
        val request = Request.Builder()
            .url(refreshAuthTokenUrl)
            .post(
                RequestBody.create(
                    MediaType.parse(mediaType),
                    jsonWrapper.toJson(RequestRefreshModel(refreshToken))
                )
            )
            .build()

        val response = chain.proceed(request).takeIf { response ->
            response.isSuccessful
        } ?: run {
            tokensUseCase.deleteTokens()
            throw RefreshTokenDied()
        }

        jsonWrapper.fromJson(response.body()?.charStream(), TokensModel::class.java).apply {
            tokensUseCase.saveTokens(accessToken, refreshToken)
        }

        return@with chain.proceed(chain.request())
    }
}