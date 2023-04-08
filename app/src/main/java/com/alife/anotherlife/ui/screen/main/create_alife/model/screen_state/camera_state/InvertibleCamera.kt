package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

interface InvertibleCamera {
    fun copyInvertCamera(): ScreenState
}