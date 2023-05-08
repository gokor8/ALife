package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

interface InvertibleScreenState<S : ScreenState> {
    fun copyInvertCamera(): S

    fun invertCamera(): CameraSelector
}