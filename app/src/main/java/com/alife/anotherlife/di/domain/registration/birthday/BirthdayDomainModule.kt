package com.alife.anotherlife.di.domain.registration.birthday

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.usecase.birthday.BaseBirthdayUseCase
import com.alife.domain.registration.usecase.birthday.BirthdayReadRegUseCase
import com.alife.domain.registration.usecase.birthday.BirthdaySaveRegUseCase
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import com.alife.domain.registration.usecase.birthday.mapper.ThrowToBirthdayRegEntity
import com.alife.domain.registration.usecase.name.BaseNameUseCase
import com.alife.domain.registration.usecase.name.NameReadRegUseCase
import com.alife.domain.registration.usecase.name.NameSaveRegUseCase
import com.alife.domain.registration.usecase.name.addons.NameRegEntity
import com.alife.domain.registration.usecase.name.mapper.ThrowToNameRegEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface BirthdayDomainModule {

    @Binds
    fun bindBirthdayReadUseCase(useCase: BirthdayReadRegUseCase): BaseBirthdayUseCase.Read

    @Binds
    fun bindNameSaveUseCase(useCase: BirthdaySaveRegUseCase): BaseBirthdayUseCase.Save

    @Binds
    fun bindNameThrowMapper(throwMapper: ThrowToBirthdayRegEntity): ThrowableMapper<BirthdayRegEntity>
}