package com.alife.anotherlife.di.data.main.home

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseDateAgoFormatMapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.DateAgoFormatMapper
import com.alife.data.repository.main.home.child.mapper.BasePostResponseToPostEntity
import com.alife.data.repository.main.home.child.mapper.PostResponseToPostEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SingletonHomeDataModule {

    @Binds
    fun bindPostResponseToPostEntity(mapper: PostResponseToPostEntity): BasePostResponseToPostEntity

    @Binds
    fun bindDateAgoFormatMapper(mapper: DateAgoFormatMapper): BaseDateAgoFormatMapper
}