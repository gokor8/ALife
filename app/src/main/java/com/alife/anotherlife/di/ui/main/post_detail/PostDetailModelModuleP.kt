package com.alife.anotherlife.di.ui.main.post_detail

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.state.MapState
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailEffect
import com.alife.anotherlife.ui.screen.main.post_detail.state.PostDetailState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class PostDetailModelModuleP {

    @Provides
    fun providePostDetail(): UIStore<PostDetailState, PostDetailEffect> = DefaultUIStore(PostDetailState())
}

