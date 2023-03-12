package com.alife.domain.registration.usecase.birthday

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity

sealed interface BaseBirthdayUseCase : UseCase {

    interface Read : BaseBirthdayUseCase, BaseRegStageUseCase.Read<BirthdayRegEntity>

    interface Save : BaseBirthdayUseCase, BaseRegStageUseCase.Save<BirthdayRegEntity>
}