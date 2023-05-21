package com.alife.data.interceptor

import com.alife.domain.core.exception_global.GlobalExceptionHandler
import com.alife.domain.core.exception_global.LogOut
import com.alife.domain.registration.usecase.token.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.TokenStateEntity
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class DefaultRequestInterceptor @Inject constructor(
    globalExceptionHandler: GlobalExceptionHandler,
    tokensUseCase: BaseTokensUseCase
) : AbstractTokenInterceptor(globalExceptionHandler, tokensUseCase) {

    override suspend fun tokensIntercept(
        tokens: TokenStateEntity.Fill,
        chain: Interceptor.Chain
    ): Response {
        // TODO если надо будет на некоторые только запросы добавлять заголовок токена
        // TODO то можно завести интерфейс или енам класс со списком тех, которым нужно добавлять
        // Или инкапсулировать в метод абстрактного класса

        return chain.request().let { request ->
            chain.proceed(
                request.newBuilder()
                    .addHeader("Authorization", tokens.authorizationToken)
                    .addHeader("Accept", "application/json")
                    .build()
            )
        }
    }
}
