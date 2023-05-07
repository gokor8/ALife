package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState

interface ImplCreateAlifeVideoReducer {

    suspend fun onRecordingAction(
        recordingWrapper: RecordingCaptureState,
        recordingAction: RecordingAction
    )

    //suspend fun onRecordingEvent(recordingAction: VideoRecordEvent)

    suspend fun onClickSmallVideo()

    suspend fun onAudioPermission(permissionStatus: PermissionStatus)
}