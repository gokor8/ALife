package com.alife.domain.registration.usecase.token.cache

interface BaseTokensUseCase {

    suspend fun saveTokens(authorizationToken: String, refreshToken: String)

    suspend fun getTokens(): TokenStateEntity

    suspend fun deleteTokens()
}