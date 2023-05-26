package com.alife.anotherlife.di.ui.main.create_alife.video

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoState
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class FinishVideoViewModelModuleP {

    @Reusable
    @Provides
    fun createFinishVideoUIStore(): UIStore<FinishVideoState, FinishVideoEffect> =
        DefaultUIStore(FinishVideoState())
}