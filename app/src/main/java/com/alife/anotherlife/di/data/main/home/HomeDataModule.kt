package com.alife.anotherlife.di.data.main.home

import com.alife.data.repository.main.home.child.MainRepository
import com.alife.data.repository.main.home.child.mapper.BasePostsResponseToPostsEntity
import com.alife.data.repository.main.home.child.mapper.PostsResponseToPostsEntity
import com.alife.domain.main.home.child.BaseMainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface HomeDataModule {

    @Binds
    fun bindMainRepository(repository: MainRepository): BaseMainRepository

    @Binds
    fun bindPostsResponseToPostsEntity(mapper: PostsResponseToPostsEntity)
            : BasePostsResponseToPostsEntity
}