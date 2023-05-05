package com.alife.anotherlife.di.ui.main.create_alife

import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducerBase
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeReducerBase
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.BaseCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.CreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.BaseCreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.CreateAlifeVideoReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAlifeReducerModule {

    @Binds
    fun bindCreateAlifeReducer(reducer: CreateAlifeReducerBase): BaseCreateAlifeReducerBase

    @Binds
    fun bindCreateAlifePhotoReducer(reducer: CreateAlifePhotoReducer): BaseCreateAlifePhotoReducer

    @Binds
    fun bindCreateAlifeVideoReducer(reducer: CreateAlifeVideoReducer): BaseCreateAlifeVideoReducer
}