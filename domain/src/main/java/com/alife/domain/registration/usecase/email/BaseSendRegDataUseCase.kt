package com.alife.domain.registration.usecase.email

interface BaseSendRegDataUseCase {

    suspend fun sendRegData(): RegDataState
}