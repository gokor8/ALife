package com.alife.domain.registration.usecase.reg_log.username

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import com.alife.domain.registration.usecase.reg_log.username.addons.UsernameRegEntity

sealed interface BaseUsernameUseCase : UseCase {

    interface Read : BaseUsernameUseCase, BaseRegStageUseCase.Read<UsernameRegEntity>

    interface ReadBox : BaseUsernameUseCase, BaseRegStageUseCase.ReadBox<UsernameRegEntity>

    interface Save : BaseUsernameUseCase, BaseRegStageUseCase.Save<UsernameRegEntity>
}