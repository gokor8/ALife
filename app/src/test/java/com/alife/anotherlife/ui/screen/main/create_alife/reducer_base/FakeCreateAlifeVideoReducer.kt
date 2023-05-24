package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base

import androidx.camera.video.VideoRecordEvent
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.BaseVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.BaseCreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class FakeCreateAlifeVideoReducer(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
) : AbstractVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCreateAlifeVideoReducer {

    override suspend fun onVideoLoading() {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.VideoLoading())
    }

    override suspend fun onStart(
        contextWrapper: BaseContextMainExecutorWrapper,
        videoCapture: BaseStartVideoCaptureState
    ) {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.ConfirmStartRecording())
    }

    override fun onStartRecording(event: VideoRecordEvent.Start) {
        uiStore.trySetEffect(FakeCreateAlifeEffect.Video.VideoLoading())
    }

    override fun onFinalizeRecording(event: VideoRecordEvent.Finalize) {
        uiStore.trySetEffect(FakeCreateAlifeEffect.Video.ConfirmFinalizeRecording())
    }

    override fun onVideoPrepare(captureWrapper: BaseVideoCaptureWrapper) {
        uiStore.trySetEffect(FakeCreateAlifeEffect.Video.VideoPrepare())
    }

    override suspend fun onRecordingAction(
        captureState: RecordingCaptureState,
        recordingAction: RecordingAction
    ) {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.RecordingAction())
    }

    override suspend fun onClickSmallVideo() {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.ClickSmallVideo())
    }

    override suspend fun onAudioPermission(permissionStatus: PermissionStatus) {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.AudioPermission())
    }

    override suspend fun onPermissionGranted(screenState: BaseVideoScreenState) {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.PermissionGranted())
    }

    override suspend fun onPermissionFatal() {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.PermissionFatal())
    }
}