package com.alife.domain.registration.usecase.name

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.name.addons.NameRegEntity

sealed interface BaseNameUseCase : UseCase {

    interface Read : BaseNameUseCase {
        suspend fun readName(): NameRegEntity
    }

    interface Save : BaseNameUseCase {
        suspend fun saveData(inputData: String)
    }
}