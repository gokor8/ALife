package com.alife.domain.registration.usecase.email.save_read

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import com.alife.domain.registration.usecase.email.save_read.entity.EmailRegEntity

sealed interface BaseEmailUseCase : UseCase {

    interface Read : BaseEmailUseCase, BaseRegStageUseCase.Read<EmailRegEntity>

    interface Save : BaseEmailUseCase, BaseRegStageUseCase.Save<EmailRegEntity>
}