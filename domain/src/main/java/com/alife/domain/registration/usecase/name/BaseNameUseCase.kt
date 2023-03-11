package com.alife.domain.registration.usecase.name

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.base.BaseBaseRegUseCase
import com.alife.domain.registration.usecase.name.addons.NameRegEntity

sealed interface BaseNameUseCase : UseCase {

    interface Read : BaseNameUseCase, BaseBaseRegUseCase.Read<NameRegEntity>

    interface Save : BaseNameUseCase, BaseBaseRegUseCase.Save<NameRegEntity>
}