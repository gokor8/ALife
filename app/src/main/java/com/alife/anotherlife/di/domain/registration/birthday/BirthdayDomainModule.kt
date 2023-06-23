package com.alife.anotherlife.di.domain.registration.birthday

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.registration.usecase.reg_log.birthday.BaseBirthdayUseCase
import com.alife.domain.registration.usecase.reg_log.birthday.BirthdayReadRegStageUC
import com.alife.domain.registration.usecase.reg_log.birthday.BirthdaySaveRegRegStageUC
import com.alife.domain.registration.usecase.reg_log.birthday.entity.BirthdayRegEntity
import com.alife.domain.registration.usecase.reg_log.birthday.mapper.ThrowToBirthdayRegEntity
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
    fun bindBirthdaySaveUseCase(useCase: BirthdaySaveRegRegStageUC): BaseBirthdayUseCase.Save

    @Binds
    fun bindBirthdayThrowMapper(throwMapper: ThrowToBirthdayRegEntity): ThrowableUCMapper<BirthdayRegEntity>
}