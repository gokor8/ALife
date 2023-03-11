package com.alife.anotherlife.di.domain.registration.name

import com.alife.anotherlife.di.data.registration.RegistrationDataModule
import com.alife.domain.core.mapper.ThrowableMapper
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
interface NameDomainModule {

    @Binds
    fun bindNameReadUseCase(useCase: NameReadRegUseCase): BaseNameUseCase.Read

    @Binds
    fun bindNameSaveUseCase(useCase: NameSaveRegUseCase): BaseNameUseCase.Save

    @Binds
    fun bindNameThrowMapper(throwMapper: ThrowToNameRegEntity): ThrowableMapper<NameRegEntity>
}