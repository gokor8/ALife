package com.alife.domain.registration.usecase.email.save_read

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import com.alife.domain.registration.usecase.email.save_read.entity.BoxEmailRegEntity

sealed interface BaseEmailUseCase : UseCase {

    interface Read : BaseEmailUseCase, BaseRegStageUseCase.Read<BoxEmailRegEntity>

    interface Save : BaseEmailUseCase, BaseRegStageUseCase.Save<BoxEmailRegEntity>
}