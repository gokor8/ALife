package com.alife.anotherlife.di.ui.main.create_alife

import android.content.Intent
import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class CreateAlifeViewModelModuleP {

    @Reusable
    @Provides
    fun createAlifeUIStore(
        @IntentModule.IntentAnnotation.Settings
        settingsIntent: Intent
    ): UIStore<CreateAlifeState, CreateAlifeEffect> =
        DefaultUIStore(CreateAlifeState(settingsIntent = settingsIntent))
}