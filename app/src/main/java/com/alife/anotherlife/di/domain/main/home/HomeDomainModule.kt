package com.alife.anotherlife.di.domain.main.home

import com.alife.domain.main.BaseFriendsPostsUseCase
import com.alife.domain.main.BaseMyPostUseCase
import com.alife.domain.main.FriendsPostsUseCase
import com.alife.domain.main.MyPostUseCase
import com.alife.domain.main.WorldPostsUseCase
import com.alife.domain.main.BaseWorldPostsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface HomeDomainModule {

    @Binds
    fun bindWorldPostsUseCase(useCase: WorldPostsUseCase): BaseWorldPostsUseCase

    @Binds
    fun bindFriendsPostsUseCase(useCase: FriendsPostsUseCase): BaseFriendsPostsUseCase

    @Binds
    fun bindMyPostUseCase(useCase: MyPostUseCase): BaseMyPostUseCase
}