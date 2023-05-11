package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper

import androidx.camera.video.VideoRecordEvent
import androidx.core.util.Consumer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.BaseCreateAlifeVideoReducer

interface BaseVideoCaptureWrapperToState {

    fun map(
        reducer: BaseCreateAlifeVideoReducer,
        callbackVideoEvent: Consumer<VideoRecordEvent>,
        captureWrapper: BaseVideoCaptureWrapper
    )
}