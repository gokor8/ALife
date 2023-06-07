package com.alife.data.interceptor

import com.alife.data.interceptor.mapper.BaseRequestToAuthHeader
import com.alife.domain.core.exception_global.CloudExceptionHandler
import com.alife.domain.core.exception_global.CommonExceptionHandler
import com.alife.domain.core.exception_global.GlobalExceptionHandler
import com.alife.domain.registration.usecase.token.cache.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.cache.TokenStateEntity
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class DefaultRequestInterceptor @Inject constructor(
    globalExceptionHandler: CommonExceptionHandler,
    tokensUseCase: BaseTokensUseCase,
    private val requestToAuthHeader: BaseRequestToAuthHeader
) : AbstractTokenInterceptor(globalExceptionHandler, tokensUseCase) {

    override suspend fun tokensIntercept(
        tokens: TokenStateEntity.Fill,
        chain: Interceptor.Chain,
        request: Request
    ): Response {
        // TODO если надо будет на некоторые только запросы добавлять заголовок токена
        // TODO то можно завести интерфейс или енам класс со списком тех, которым нужно добавлять
        // Или инкапсулировать в метод абстрактного класса

        return chain.proceed(
            requestToAuthHeader.map(request, tokens.accessToken).newBuilder()
                .addHeader("Accept", "application/json")
                .build()
        )
    }
}
