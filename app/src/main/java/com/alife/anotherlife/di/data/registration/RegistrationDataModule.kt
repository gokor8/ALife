package com.alife.anotherlife.di.data.registration

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.data.repository.registration.RegCacheRepository
import com.alife.data.repository.registration.RegistrationRepository
import com.alife.data.repository.registration.mapper.BaseRegDataEntityToRequest
import com.alife.data.repository.registration.mapper.ReadCacheInputEntityToReadRegModel
import com.alife.data.repository.registration.mapper.CacheInputEntityToWriteRegModel
import com.alife.data.repository.registration.mapper.RegDataEntityToRequest
import com.alife.domain.registration.repository.BaseRegCacheRepository
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RegistrationDataModule {

    @Binds
    fun bindRegCacheRepository(repository: RegCacheRepository): BaseRegCacheRepository

    @Binds
    fun bindRegEntityToWriteRegModel(mapper: CacheInputEntityToWriteRegModel)
            : Mapper<RegCacheInputEntity.Save<*>, CacheModel.Write<*>>

    @Binds
    fun bindRegEntityToReadRegModel(mapper: ReadCacheInputEntityToReadRegModel)
            : Mapper<RegCacheInputEntity.Read<*>, CacheModel.Read<*>>
}