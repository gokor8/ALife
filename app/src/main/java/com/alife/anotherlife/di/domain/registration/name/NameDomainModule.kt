package com.alife.anotherlife.di.domain.registration.name

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.registration.usecase.reg_log.name.BaseNameUseCase
import com.alife.domain.registration.usecase.reg_log.name.NameReadRegStageUC
import com.alife.domain.registration.usecase.reg_log.name.NameSaveRegRegStageUC
import com.alife.domain.registration.usecase.reg_log.name.addons.NameRegEntity
import com.alife.domain.registration.usecase.reg_log.name.mapper.ThrowToNameRegEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface NameDomainModule {

    @Binds
    fun bindNameReadUseCase(useCase: NameReadRegStageUC): BaseNameUseCase.Read

    @Binds
    fun bindNameSaveUseCase(useCase: NameSaveRegRegStageUC): BaseNameUseCase.Save

    @Binds
    fun bindNameThrowMapper(throwMapper: ThrowToNameRegEntity): ThrowableUCMapper<NameRegEntity>
}