package com.alife.data.interceptor

import com.alife.data.interceptor.model.BaseTokenErrorChain
import com.alife.data.interceptor.model.TokenErrorChainModel
import com.alife.domain.core.exception_global.GlobalExceptionHandler
import com.alife.domain.core.exception_global.ServerUnavailable
import com.alife.domain.registration.usecase.token.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.TokenStateEntity
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenReAuthInterceptor @Inject constructor(
    globalExceptionHandler: GlobalExceptionHandler,
    tokensUseCase: BaseTokensUseCase,
    private val tokenErrorChain: BaseTokenErrorChain,
    private val
    // TODO add MainActivity uiStore
) : AbstractTokenInterceptor(globalExceptionHandler, tokensUseCase) {

    override fun tokensIntercept(
        tokens: TokenStateEntity.Fill,
        chain: Interceptor.Chain
    ): Response {
        // TODO если надо будет на некоторые только запросы добавлять заголовок токена
        // TODO то можно завести интерфейс или енам класс со списком тех, которым нужно добавлять
        // Или инкапсулировать в метод абстрактного класса

        val response = chain.proceed(chain.request())

        // TODO заменить в будующем на классы, с методом(чтобы было ООП)
        return when(response.code()) {
            // TODO сохранять в SharedPrefs новые токены
            403 -> {
                val tempResponse = tokenErrorChain.handle(
                    TokenErrorChainModel(tokens.refreshToken, chain)
                )


            }
            404 -> throw ServerUnavailable()
            else -> response
        }
    }
}