package com.alife.anotherlife.di.ui.main.create_alife.video

import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.BaseFinishVideoReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.FinishVideoReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FinishVideoViewModelModule {

    @Binds
    fun bindFinishVideoReducer(reducer: FinishVideoReducer): BaseFinishVideoReducer
}