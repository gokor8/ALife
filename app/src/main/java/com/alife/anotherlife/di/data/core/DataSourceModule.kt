package com.alife.anotherlife.di.data.core

import com.alife.core.addons.JsonWrapper
import com.alife.data.core.GsonWrapper
import com.alife.data.data_source.cache.shared.CacheSharedPrefDataSource
import com.alife.data.data_source.cache.shared.SharedCacheDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindSharedCacheDataSource(sharedCacheDataSource: CacheSharedPrefDataSource): SharedCacheDataSource

    @Binds
    fun bindGsonWrapper(gsonWrapper: GsonWrapper): JsonWrapper
}