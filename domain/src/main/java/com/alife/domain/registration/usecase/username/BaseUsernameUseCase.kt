package com.alife.domain.registration.usecase.username

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.base.BaseBaseRegUseCase
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity

sealed interface BaseUsernameUseCase : UseCase {

    interface Read : BaseUsernameUseCase, BaseBaseRegUseCase.Read<UsernameRegEntity>

    interface Save : BaseUsernameUseCase, BaseBaseRegUseCase.Save<UsernameRegEntity>
}