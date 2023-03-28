package com.alife.anotherlife.di.ui.main.home.child.world

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class WorldViewModelModuleP {

    @Reusable
    @Provides
    @WorldAnnotation.WorldUIStore
    fun provideWorldUIStore(): UIStore<HomeChildState, HomeChildEffect> {
        return DefaultUIStore(HomeChildState())
    }
}