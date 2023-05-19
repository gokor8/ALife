package com.alife.data.interceptor

import com.alife.domain.registration.usecase.token.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.TokenStateEntity
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import java.net.HttpURLConnection
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    globalExceptionHandler: GlobalExceptionHandler,
    private val tokensUseCase: BaseTokensUseCase
) : GlobalInterceptor(globalExceptionHandler) {

    override suspend fun suspendIntercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        // TODO если надо будет на некоторые только запросы добавлять заголовок токена
        // TODO то можно завести интерфейс или енам класс со списком тех, которым нужно добавлять
        // Или инкапсулировать в метод абстрактного класса

        val authToken = when(val tokens = tokensUseCase.getTokens()) {
            is TokenStateEntity.Fill -> tokens.authorizationToken
            else -> throw LogOut()// TODO to reg
        }

        return chain.request().let { request ->
            chain.proceed(
                request.newBuilder()
                    .addHeader("Authorization", authToken)
                    .addHeader("Accept", "application/json")
                    .build()
            )
        }
    }
}
