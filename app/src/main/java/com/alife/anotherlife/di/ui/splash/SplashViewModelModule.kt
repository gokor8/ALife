package com.alife.anotherlife.di.ui.splash

import com.alife.anotherlife.ui.screen.splash.BaseSplashReducer
import com.alife.anotherlife.ui.screen.splash.SplashReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface SplashViewModelModule {

    @Binds
    fun bindSplashReducer(reducer: SplashReducer): BaseSplashReducer
}