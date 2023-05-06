package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.mapper.BaseVideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.CameraPermissionReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import javax.inject.Inject

class CreateAlifeVideoReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
    private val videoCaptureWrapperToState: BaseVideoCaptureWrapperToState
) : CameraPermissionReducer(uiStore), BaseCreateAlifeVideoReducer {

    override fun onVideoPrepare(captureWrapper: BaseVideoCaptureWrapper) {
        videoCaptureWrapperToState.map(this, CallbackVideoEvent(this), captureWrapper)
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onStart(
        contextWrapper: BaseContextMainExecutorWrapper,
        videoCapture: BaseStartVideoCaptureState
    ) {
        // TODO обернуть в executor и обработать ошибки
        val recordingWrapper = videoCapture.start(contextWrapper)

        setState {
            copy(
                pagerContainer = pagerContainer.video.copyContainer(
                    pagerContainer,
                    VideoPagerItem.OnRecording(
                        RecordingCaptureState(videoCapture, recordingWrapper)
                    )
                )
            )
        }
    }

    override suspend fun onRecordingAction(
        recordingWrapper: RecordingWrapper,
        recordingAction: RecordingAction
    ) {
        // TODO обернуть в executor и обработать ошибки
        recordingAction.onRecordingAction(recordingWrapper)
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onClickSmallVideo() {
        setEffect(
            CreateAlifeEffect.VideoToMainPage(
                getState().pagerState,
                getState().pagerContainer.getVideoIndex()
            )
        )
    }

    override suspend fun onAudioPermission(permissionStatus: PermissionStatus) {

    }
}