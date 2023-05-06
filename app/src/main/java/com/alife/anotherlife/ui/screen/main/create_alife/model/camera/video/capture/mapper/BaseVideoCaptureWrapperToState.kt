package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.CreateAlifeVideoReducer

interface BaseVideoCaptureWrapperToState {

    fun map(
        reducer: CreateAlifeVideoReducer,
        callbackVideoEvent: CallbackVideoEvent,
        captureWrapper: BaseVideoCaptureWrapper
    )
}