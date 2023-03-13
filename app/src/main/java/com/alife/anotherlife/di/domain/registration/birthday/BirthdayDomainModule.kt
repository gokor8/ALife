package com.alife.anotherlife.di.domain.registration.birthday

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.usecase.birthday.BaseBirthdayUseCase
import com.alife.domain.registration.usecase.birthday.BirthdayReadRegStageUC
import com.alife.domain.registration.usecase.birthday.BirthdaySaveRegStageUC
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
    fun bindBirthdayReadUseCase(useCase: BirthdayReadRegStageUC): BaseBirthdayUseCase.Read

    @Binds
    fun bindBirthdaySaveUseCase(useCase: BirthdaySaveRegStageUC): BaseBirthdayUseCase.Save

    @Binds
    fun bindBirthdayThrowMapper(throwMapper: ThrowToBirthdayRegEntity): ThrowableMapper<BirthdayRegEntity>
}