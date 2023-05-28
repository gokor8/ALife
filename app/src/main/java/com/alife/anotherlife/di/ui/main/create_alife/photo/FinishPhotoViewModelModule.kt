package com.alife.anotherlife.di.ui.main.create_alife.photo

import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.BaseFinishPictureReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.FinishPictureReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FinishPhotoViewModelModule {

    @Binds
    fun bindFinishPictureReducer(reducer: FinishPictureReducer): BaseFinishPictureReducer
}