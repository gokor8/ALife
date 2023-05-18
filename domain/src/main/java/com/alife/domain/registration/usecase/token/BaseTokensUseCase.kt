package com.alife.domain.registration.usecase.token

interface BaseTokensUseCase {

    suspend fun getTokens(): TokenStateEntity
}