package com.alife.anotherlife.di.ui.splash

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.splash.state.SplashEffect
import com.alife.anotherlife.ui.screen.splash.state.SplashState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class SplashViewModelModuleP {

    @Provides
    fun splashUIStore(): UIStore<SplashState, SplashEffect> = DefaultUIStore(SplashState())
}