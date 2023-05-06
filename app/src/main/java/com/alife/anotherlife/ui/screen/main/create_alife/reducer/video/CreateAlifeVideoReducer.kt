package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import android.content.Context
import androidx.camera.video.RecordingStats
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.VideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.mapper.VideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.recording.RecordingWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.CameraPermissionReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import java.util.concurrent.Executor
import javax.inject.Inject

class CreateAlifeVideoReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
    private val videoCaptureWrapperToState: VideoCaptureWrapperToState
) : CameraPermissionReducer(uiStore), BaseCreateAlifeVideoReducer {

    override fun onVideoPrepare(captureWrapper: BaseVideoCaptureWrapper) {
        videoCaptureWrapperToState.map(this, CallbackVideoEvent(this), captureWrapper)
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onStart(
        context: Context,
        mainExecutor: Executor,
        videoCapture: BaseStartVideoCaptureState
    ) {
        val recordingWrapper = videoCapture.start(context, mainExecutor)

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