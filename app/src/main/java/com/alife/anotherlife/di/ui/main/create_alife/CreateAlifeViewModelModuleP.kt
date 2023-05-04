package com.alife.anotherlife.di.ui.main.create_alife

import android.content.Intent
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.ui.screen.main.create_alife.addons.permission_wrapper.CameraAudioPermissionWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.addons.permission_wrapper.CameraPermissionWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
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
    fun birthdayUIStore(
        @IntentModule.IntentAnnotation.Settings
        settingsIntent: Intent,
        cameraPermissionWrapper: CameraPermissionWrapper,
        cameraAudioPermissionWrapper: CameraAudioPermissionWrapper
    ): UIStore<CreateAlifeState, CreateAlifeEffect> = DefaultUIStore(
        CreateAlifeState(
            cameraPermissionWrapper = cameraPermissionWrapper,
            cameraAudioPermissionWrapper = cameraAudioPermissionWrapper,
            settingsIntent = settingsIntent
        )
    )
}