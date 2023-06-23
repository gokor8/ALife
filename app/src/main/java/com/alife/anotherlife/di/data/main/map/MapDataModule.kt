package com.alife.anotherlife.di.data.main.map

import com.alife.anotherlife.ui.screen.main.post_detail.mapper.BasePostDetailEntityToUIDetail
import com.alife.anotherlife.ui.screen.main.post_detail.mapper.PostDetailEntityToUIDetail
import com.alife.data.repository.main.map.MapRepository
import com.alife.data.repository.main.map.mapper.BaseMapPostDataModelToEntity
import com.alife.data.repository.main.map.mapper.BaseMapPostsDataModelToEntity
import com.alife.data.repository.main.map.mapper.MapPostDataModelToEntity
import com.alife.data.repository.main.map.mapper.MapPostsDataModelToEntity
import com.alife.domain.main.map.BaseMapRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MapDataModule {

    @Singleton
    @Binds
    fun bindMapRepository(repository: MapRepository): BaseMapRepository

    @Singleton
    @Binds
    fun bindMapPostDataModelToEntity(mapper: MapPostDataModelToEntity): BaseMapPostDataModelToEntity

    @Singleton
    @Binds
    fun bindMapPostsDataModelToEntity(mapper: MapPostsDataModelToEntity): BaseMapPostsDataModelToEntity

    @Singleton
    @Binds
    fun bindPostDetailEntityToUIDetail(mapper: PostDetailEntityToUIDetail): BasePostDetailEntityToUIDetail
}