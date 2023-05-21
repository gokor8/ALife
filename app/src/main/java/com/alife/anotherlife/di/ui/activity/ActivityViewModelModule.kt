package com.alife.anotherlife.di.ui.activity

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.activity.state.MainActivityEffect
import com.alife.anotherlife.ui.activity.state.MainActivityState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ActivityViewModelModule {

    @Provides
    fun provideMainActiviyUIStore(): UIStore<MainActivityState, MainActivityEffect> {
        return DefaultUIStore(MainActivityState())
    }
}