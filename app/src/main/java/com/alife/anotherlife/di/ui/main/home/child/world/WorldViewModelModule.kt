package com.alife.anotherlife.di.ui.main.home.child.world

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world.WorldReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface WorldViewModelModule {

    @Binds
    fun bindWorldReducer(reducer: WorldReducer): AbstractHomeChildReducerBase
}