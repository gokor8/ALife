package com.alife.anotherlife.di.ui.main.post_detail

import com.alife.anotherlife.ui.screen.main.post_detail.BasePostDetailReducer
import com.alife.anotherlife.ui.screen.main.post_detail.PostDetailReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface PostDetailModelModule {

    @Binds
    fun bindPostDetailReducer(reducer: PostDetailReducer): BasePostDetailReducer
}