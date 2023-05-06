package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.BaseCameraPermissionReducer

interface BaseCreateAlifeVideoReducer : ImplCreateAlifeVideoReducer, BaseCameraPermissionReducer {

    suspend fun onStart(
        contextWrapper: BaseContextMainExecutorWrapper,
        videoCapture: BaseStartVideoCaptureState
    )

    suspend fun onRecordingAction(
        recordingWrapper: RecordingWrapper,
        recordingAction: RecordingAction
    )

    fun onVideoPrepare(captureWrapper: BaseVideoCaptureWrapper)
}