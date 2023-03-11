package com.alife.anotherlife.di.domain.registration.name

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.usecase.name.BaseNameUseCase
import com.alife.domain.registration.usecase.name.NameReadBaseRegUseCase
import com.alife.domain.registration.usecase.name.NameSaveBaseRegUseCase
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
    fun bindNameReadUseCase(useCase: NameReadBaseRegUseCase): BaseNameUseCase.Read

    @Binds
    fun bindNameSaveUseCase(useCase: NameSaveBaseRegUseCase): BaseNameUseCase.Save

    @Binds
    fun bindNameThrowMapper(throwMapper: ThrowToNameRegEntity): ThrowableMapper<NameRegEntity>
}