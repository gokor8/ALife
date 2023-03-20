package com.alife.anotherlife.di.ui.registration.tutorial

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialEffect
import com.alife.anotherlife.ui.screen.registration.tutorial.state.TutorialState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class TutorialViewModelModuleP {

    @Provides
    fun nameRegUIStore(): UIStore<TutorialState, TutorialEffect> = DefaultUIStore(TutorialState())
}