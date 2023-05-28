package com.alife.domain.registration.usecase.token.cloud

interface BaseTokenCheckUseCase {

    suspend fun tokensCheck()
}