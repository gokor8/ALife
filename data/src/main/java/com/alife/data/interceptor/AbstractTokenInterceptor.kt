package com.alife.data.interceptor

import com.alife.domain.core.exception_global.GlobalExceptionHandler
import com.alife.domain.core.exception_global.LogOut
import com.alife.domain.registration.usecase.token.BaseTokensUseCase
import com.alife.domain.registration.usecase.token.TokenStateEntity
import okhttp3.Interceptor
import okhttp3.Response

abstract class AbstractTokenInterceptor(
    globalExceptionHandler: GlobalExceptionHandler,
    protected val tokensUseCase: BaseTokensUseCase
) : AbstractSuspendInterceptor(globalExceptionHandler) {

    private val exceptionsLinks = ("")

    override suspend fun suspendIntercept(chain: Interceptor.Chain): Response {
        return when (val tokens = tokensUseCase.getTokens()) {
            is TokenStateEntity.Fill -> tokensIntercept(tokens, chain)
            else -> throw LogOut()// TODO to reg
        }
    }

    protected abstract suspend fun tokensIntercept(
        tokens: TokenStateEntity.Fill,
        chain: Interceptor.Chain
    ): Response
}