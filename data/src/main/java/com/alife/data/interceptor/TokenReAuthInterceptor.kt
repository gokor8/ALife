package com.alife.data.interceptor

import com.alife.domain.registration.usecase.token.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.TokenStateEntity
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenReAuthInterceptor @Inject constructor(
    globalExceptionHandler: GlobalExceptionHandler,
    private val tokensUseCase: BaseTokensUseCase,
    private val tokenErrorChain: BaseTokenErrorChain
    // TODO add MainActivity uiStore
) : GlobalInterceptor(globalExceptionHandler) {

    override suspend fun suspendIntercept(chain: Interceptor.Chain): Response {
        // TODO если надо будет на некоторые только запросы добавлять заголовок токена
        // TODO то можно завести интерфейс или енам класс со списком тех, которым нужно добавлять
        // Или инкапсулировать в метод абстрактного класса

        val authToken = when (val tokens = tokensUseCase.getTokens()) {
            is TokenStateEntity.Fill -> tokens
            else -> throw LogOut()// TODO to reg
        }

        return tokenErrorChain.handle(TokenErrorChainModel(authToken, chain))
    }
}
