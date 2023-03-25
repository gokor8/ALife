package com.alife.anotherlife.di.ui.main.home

import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.BaseHomeReducer
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.HomeReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface HomeViewModelModule {

    @Binds
    fun bindHomeReducer(reducer: HomeReducer): BaseHomeReducer
}