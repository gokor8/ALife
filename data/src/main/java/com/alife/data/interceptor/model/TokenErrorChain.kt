package com.alife.data.interceptor.model

import com.alife.core.addons.JsonWrapper
import com.alife.core.chain.ChainHandler
import com.alife.data.core.BaseTokenRequestFactory
import com.alife.domain.core.exception_global.RefreshTokenDied
import com.alife.domain.registration.usecase.token.cache.BaseTokensUseCase
import okhttp3.Response
import javax.inject.Inject


interface BaseTokenErrorChain : ChainHandler.BaseSuspend<TokenErrorChainModel, Response>

class RefreshTokenErrorChain @Inject constructor(
    private val tokensUseCase: BaseTokensUseCase,
    private val jsonWrapper: JsonWrapper,
    private val tokenRequestFactory: BaseTokenRequestFactory
) : BaseTokenErrorChain {

    override suspend fun handle(inputModel: TokenErrorChainModel) = with(inputModel) {
        val request = tokenRequestFactory.create(
            jsonWrapper.toJson(RequestRefreshModel(refreshToken))
        )

        val response = chain.proceed(request)

        response.takeIf { response ->
            response.isSuccessful
        } ?: run {
            response.close()
            tokensUseCase.deleteTokens()
            throw RefreshTokenDied()
        }

        jsonWrapper.fromJson(response.body()?.charStream(), TokensModel::class.java).apply {
            tokensUseCase.saveTokens(accessToken, refreshToken)
        }

        response.code()

        return@with chain.proceed(chain.request())
    }
}