package com.alife.domain.registration.usecase.birthday

import com.alife.core.usecase.UseCase
import com.alife.domain.registration.usecase.base.BaseBaseRegUseCase
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity

sealed interface BaseBirthdayUseCase : UseCase {

    interface Read : BaseBirthdayUseCase, BaseBaseRegUseCase.Read<BirthdayRegEntity>

    interface Save : BaseBirthdayUseCase, BaseBaseRegUseCase.Save<BirthdayRegEntity>
}