package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper

interface RecordingAction {

    suspend fun onRecordingAction(recordingWrapper: RecordingCaptureState)


    class Resume : RecordingAction {
        override suspend fun onRecordingAction(recordingWrapper: RecordingCaptureState) {
            recordingWrapper.resume()
        }
    }

    class Pause : RecordingAction {
        override suspend fun onRecordingAction(recordingWrapper: RecordingCaptureState) {
            recordingWrapper.pause()
        }
    }

    class Stop : RecordingAction {
        override suspend fun onRecordingAction(recordingWrapper: RecordingCaptureState) {
            recordingWrapper.stop()
        }
    }
}