package com.alife.anotherlife.di.domain.main.home

import com.alife.domain.main.BasePostsUseCase
import com.alife.domain.main.PostsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface HomeDomainModule {

    @Binds
    fun bindPostsUseCase(useCase: PostsUseCase): BasePostsUseCase
}