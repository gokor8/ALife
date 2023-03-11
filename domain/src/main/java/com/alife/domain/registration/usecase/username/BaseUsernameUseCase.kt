package com.alife.domain.registration.usecase.username

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity

sealed interface BaseUsernameUseCase : UseCase {

    interface Read : BaseUsernameUseCase {
        suspend fun readName(): UsernameRegEntity
    }

    interface Save : BaseUsernameUseCase {
        suspend fun saveData(inputData: String)
    }
}