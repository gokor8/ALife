package com.alife.domain.registration.usecase.email

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.base.BaseBaseRegUseCase
import com.alife.domain.registration.usecase.email.entity.EmailRegEntity

sealed interface BaseEmailUseCase : UseCase {

    interface Read : BaseEmailUseCase, BaseBaseRegUseCase.Read<EmailRegEntity>

    interface Save : BaseEmailUseCase, BaseBaseRegUseCase.Save<EmailRegEntity>
}