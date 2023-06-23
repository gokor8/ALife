package com.alife.domain.registration.usecase.reg_log.name

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import com.alife.domain.registration.usecase.reg_log.name.addons.NameRegEntity

sealed interface BaseNameUseCase : UseCase {

    interface Read : BaseNameUseCase, BaseRegStageUseCase.Read<NameRegEntity>

    interface ReadBox : BaseNameUseCase, BaseRegStageUseCase.ReadBox<NameRegEntity>

    interface Save : BaseNameUseCase, BaseRegStageUseCase.Save<NameRegEntity>
}