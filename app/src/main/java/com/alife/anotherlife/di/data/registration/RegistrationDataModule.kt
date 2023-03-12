package com.alife.anotherlife.di.data.registration

import com.alife.anotherlife.di.data.core.DataSourceModule
import com.alife.data.repository.registration.RegistrationRepository
import com.alife.data.repository.registration.mapper.BaseRegEntityToReadRegModel
import com.alife.data.repository.registration.mapper.BaseRegEntityToWriteRegModel
import com.alife.data.repository.registration.mapper.RegEntityToReadRegModel
import com.alife.data.repository.registration.mapper.RegEntityToWriteRegModel
import com.alife.domain.registration.repository.BaseRegistrationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RegistrationDataModule {

    @Binds
    fun bindRegistrationRepository(repository: RegistrationRepository): BaseRegistrationRepository

    @Binds
    fun bindRegEntityToWriteRegModel(mapper: RegEntityToWriteRegModel): BaseRegEntityToWriteRegModel

    @Binds
    fun bindRegEntityToReadRegModel(mapper: RegEntityToReadRegModel): BaseRegEntityToReadRegModel
}