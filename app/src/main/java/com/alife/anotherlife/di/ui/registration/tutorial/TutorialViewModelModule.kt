package com.alife.anotherlife.di.ui.registration.tutorial

import com.alife.anotherlife.ui.screen.registration.tutorial.BaseTutorialReducer
import com.alife.anotherlife.ui.screen.registration.tutorial.TutorialReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface TutorialViewModelModule {

    @Binds
    fun bindTutorialReducer(reducer: TutorialReducer): BaseTutorialReducer
}