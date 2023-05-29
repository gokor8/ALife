package com.alife.anotherlife.di.ui.main.home.child.friends

import com.alife.domain.main.home.child.child_friends.BaseFriendsProfileCardUC
import com.alife.domain.main.home.child.child_friends.FriendsProfileCardUC
import com.alife.domain.main.home.child.mapper.BaseThrowToProfileEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FriendsUseCaseModule {

    @Binds
    fun bindFriendsUseCase(useCase: FriendsProfileCardUC): BaseFriendsProfileCardUC

    @Binds
    fun bindHomeChildThrowableMapper(mapper: ThrowToProfileEntity): BaseThrowToProfileEntity
}