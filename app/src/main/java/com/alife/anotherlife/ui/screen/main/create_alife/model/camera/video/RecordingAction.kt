package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper

interface RecordingAction {

    suspend fun onRecordingAction(recordingWrapper: RecordingWrapper)


    class Resume : RecordingAction {
        override suspend fun onRecordingAction(recordingWrapper: RecordingWrapper) {
            recordingWrapper.resume()
        }
    }

    class Pause : RecordingAction {
        override suspend fun onRecordingAction(recordingWrapper: RecordingWrapper) {
            recordingWrapper.resume()
        }
    }

    class Stop : RecordingAction {
        override suspend fun onRecordingAction(recordingWrapper: RecordingWrapper) {
            recordingWrapper.resume()
        }
    }
}