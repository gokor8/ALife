package com.alife.domain.registration.usecase.birthday

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity

sealed interface BaseBirthdayUseCase  : UseCase {

    interface Read : BaseBirthdayUseCase {
        suspend fun readBirthday(): BirthdayRegEntity
    }

    interface Save : BaseBirthdayUseCase {
        suspend fun saveData(inputData: String)
    }
}