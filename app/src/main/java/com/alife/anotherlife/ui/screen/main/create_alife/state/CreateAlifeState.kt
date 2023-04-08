package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.content.Intent
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.EmptyCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.UselessCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleCamera
import com.alife.core.mvi.MVI
import javax.inject.Inject

data class CreateAlifeState @Inject constructor(
    val screenState: ScreenState = LoadScreenState(),
    val captureWrapper: BaseCaptureWrapper = EmptyCaptureWrapper(),
    @IntentModule.IntentAnnotation.Settings
    val settingsIntent: Intent?,
    val isInvertButtonEnable: Boolean = captureWrapper !is UselessCaptureWrapper && screenState is InvertibleCamera
) : MVI.State