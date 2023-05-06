package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import android.content.Context
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.BaseCameraPermissionReducer
import java.util.concurrent.Executor

interface BaseCreateAlifeVideoReducer : ImplCreateAlifeVideoReducer, BaseCameraPermissionReducer {

    suspend fun onStart(
        context: Context,
        mainExecutor: Executor,
        videoCapture: BaseStartVideoCaptureState
    )

    suspend fun onRecordingAction(
        recordingWrapper: RecordingWrapper,
        recordingAction: RecordingAction
    )

    fun onVideoPrepare(captureWrapper: BaseVideoCaptureWrapper)
}