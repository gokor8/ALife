package com.alife.anotherlife.di.data.main.map

import com.alife.data.repository.main.map.MapRepository
import com.alife.data.repository.main.map.mapper.BaseMapPostDataModelToEntity
import com.alife.data.repository.main.map.mapper.MapPostDataModelToEntity
import com.alife.domain.main.map.BaseMapRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface MapDataModule {

    @Binds
    fun bindMapRepository(repository: MapRepository): BaseMapRepository

    @Binds
    fun bindMapPostDataModelToEntity(mapper: MapPostDataModelToEntity): BaseMapPostDataModelToEntity
}