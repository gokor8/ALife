package com.alife.domain.registration.usecase.name

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import com.alife.domain.registration.usecase.name.addons.NameRegEntity

sealed interface BaseNameUseCase : UseCase {

    interface Read : BaseNameUseCase, BaseRegStageUseCase.Read<NameRegEntity>

    interface Save : BaseNameUseCase, BaseRegStageUseCase.Save<NameRegEntity>
}