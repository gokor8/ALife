package com.alife.anotherlife.di.domain.registration.birthday

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.usecase.birthday.BaseBirthdayUseCase
import com.alife.domain.registration.usecase.birthday.BirthdayReadBaseRegUseCase
import com.alife.domain.registration.usecase.birthday.BirthdaySaveBaseRegUseCase
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import com.alife.domain.registration.usecase.birthday.mapper.ThrowToBirthdayRegEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface BirthdayDomainModule {

    @Binds
    fun bindBirthdayReadUseCase(useCase: BirthdayReadBaseRegUseCase): BaseBirthdayUseCase.Read

    @Binds
    fun bindBirthdaySaveUseCase(useCase: BirthdaySaveBaseRegUseCase): BaseBirthdayUseCase.Save

    @Binds
    fun bindBirthdayThrowMapper(throwMapper: ThrowToBirthdayRegEntity): ThrowableMapper<BirthdayRegEntity>
}