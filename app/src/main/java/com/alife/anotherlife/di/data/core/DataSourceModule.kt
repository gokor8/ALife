package com.alife.anotherlife.di.data.core

import com.alife.data.data_source.CacheSharedPrefDataSource
import com.alife.data.data_source.SharedCacheDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DataSourceModule {

    @Binds
    fun bindSharedCacheDataSource(sharedCacheDataSource: CacheSharedPrefDataSource): SharedCacheDataSource
}