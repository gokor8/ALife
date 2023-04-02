package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.content.Intent
import androidx.camera.core.CameraSelector
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.core.mvi.MVI
import javax.inject.Inject

data class CreateAlifeState @Inject constructor(
    val screenState: ScreenState = LoadScreenState(),
    @IntentModule.IntentAnnotation.Settings
    val settingsIntent: Intent,
    val cameraSelection: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA
) : MVI.State