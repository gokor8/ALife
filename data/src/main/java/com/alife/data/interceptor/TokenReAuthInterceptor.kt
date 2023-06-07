package com.alife.data.interceptor

import android.util.Log
import com.alife.data.interceptor.model.BaseTokenErrorChain
import com.alife.data.interceptor.model.TokenErrorChainModel
import com.alife.domain.core.exception_global.CommonExceptionHandler
import com.alife.domain.core.exception_global.GlobalExceptionHandler
import com.alife.domain.core.exception_global.ServerUnavailable
import com.alife.domain.registration.usecase.token.cache.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.cache.TokenStateEntity
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class TokenReAuthInterceptor @Inject constructor(
    globalExceptionHandler: CommonExceptionHandler,
    tokensUseCase: BaseTokensUseCase,
    private val tokenErrorChain: BaseTokenErrorChain
) : AbstractTokenInterceptor(globalExceptionHandler, tokensUseCase) {

    override suspend fun tokensIntercept(
        tokens: TokenStateEntity.Fill,
        chain: Interceptor.Chain,
        request: Request
    ): Response {
        // TODO если надо будет на некоторые только запросы добавлять заголовок токена
        // TODO то можно завести интерфейс или енам класс со списком тех, которым нужно добавлять
        // Или инкапсулировать в метод абстрактного класса
        Log.d("Tokens", "${tokens.accessToken} | ${tokens.refreshToken}")

        val response = chain.proceed(request)

        // TODO заменить в будующем на классы, с методом(чтобы было ООП)
        return when(response.code()) {
            401 -> {
                response.close()
                tokenErrorChain.handle(TokenErrorChainModel(tokens.refreshToken, chain, request))
            }
            404 -> {
                //tokensUseCase.deleteTokens()
                response.close()
                throw ServerUnavailable()
            }
            else -> response
        }
    }
}
