package com.alife.anotherlife.di.ui.registration.tutorial

import com.alife.anotherlife.ui.screen.registration.tutorial.BaseTutorialReducerBase
import com.alife.anotherlife.ui.screen.registration.tutorial.TutorialReducerBase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface TutorialViewModelModule {

    @Binds
    fun bindTutorialReducer(reducer: TutorialReducerBase): BaseTutorialReducerBase
}