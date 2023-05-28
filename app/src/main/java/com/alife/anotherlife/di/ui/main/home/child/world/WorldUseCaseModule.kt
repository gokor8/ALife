package com.alife.anotherlife.di.ui.main.home.child.world

import com.alife.domain.main.home.child.BaseProfileCardUseCase
import com.alife.domain.main.home.child.child_world.BaseWorldProfileCardUC
import com.alife.domain.main.home.child.child_world.WorldProfileCardUC
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface WorldUseCaseModule {

    @WorldAnnotation.WorldProfileUseCase
    @Binds
    fun bindWorldProfileCardUC(useCase: WorldProfileCardUC): BaseWorldProfileCardUC
}