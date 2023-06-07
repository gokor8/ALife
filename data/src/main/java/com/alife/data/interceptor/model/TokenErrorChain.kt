package com.alife.data.interceptor.model

import android.view.WindowManager.BadTokenException
import com.alife.core.addons.JsonWrapper
import com.alife.core.chain.ChainHandler
import com.alife.data.core.BaseTokenRequestFactory
import com.alife.data.interceptor.mapper.BaseRequestToAuthHeader
import com.alife.data.interceptor.mapper.RequestToAuthHeader
import com.alife.data.services.TokenService
import com.alife.domain.core.exception_global.RefreshTokenDied
import com.alife.domain.registration.usecase.token.cache.BaseTokensUseCase
import okhttp3.Response
import javax.inject.Inject


interface BaseTokenErrorChain : ChainHandler.BaseSuspend<TokenErrorChainModel, Response>

        class RefreshTokenErrorChain @Inject constructor(
            private val tokensUseCase: BaseTokensUseCase,
            private val tokenService: TokenService,
            private val requestToAuthHeader: BaseRequestToAuthHeader
        ) : BaseTokenErrorChain {

            override suspend fun handle(inputModel: TokenErrorChainModel) = with(inputModel) {
                val response = tokenService.sendRegData(RequestRefreshModel(refreshToken))//chain.proceed(request)

                response.takeIf { response ->
                    response.isSuccessful
                } ?: run {
                    //response.close()
                    tokensUseCase.deleteTokens()
                    throw RefreshTokenDied()
                }

                val tokens = response.body()?.apply {
                    tokensUseCase.saveTokens(accessToken, refreshToken)
                } ?: throw BadTokenException()

                response.code()

                return@with chain.proceed(requestToAuthHeader.map(request, tokens.accessToken))
    }
}