package com.alife.anotherlife.di.ui.main.home.child.friends

import com.alife.data.repository.main.home.child.ThrowToProfileEntity
import com.alife.domain.main.home.child.BaseProfileCardUseCase
import com.alife.domain.main.home.child.child_friends.FriendsProfileCardUC
import com.alife.domain.main.home.child.mapper.BaseThrowToProfileEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FriendsUseCaseModule {

    @FriendsAnnotation.FriendsProfileUseCase
    @Binds
    fun bindFriendsUseCase(useCase: FriendsProfileCardUC): BaseProfileCardUseCase

    @Binds
    fun bindHomeChildThrowableMapper(mapper: ThrowToProfileEntity): BaseThrowToProfileEntity
}