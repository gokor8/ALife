package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import android.media.MediaRecorder
import androidx.camera.video.VideoRecordEvent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.BaseVideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.timer.BaseTimerUnit
import com.alife.anotherlife.ui.screen.main.create_alife.model.timer.CreateAlifeCountDownTimer
import com.alife.anotherlife.ui.screen.main.create_alife.model.timer.CreateAlifeVideoTimer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.CameraPermissionReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.BaseVideoStorageToOptions
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.BaseVideoCaptureBuilderFactory
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.VideoCaptureCallback
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.alife.domain.main.create_alife.video.BaseVideoStorageAlifeUseCase
import javax.inject.Inject

class CreateAlifeVideoReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
    private val videoCaptureWrapperToState: BaseVideoCaptureWrapperToState,
    private val videoStorageAlifeUseCase: BaseVideoStorageAlifeUseCase,
    private val videoStorageToOptions: BaseVideoStorageToOptions,
    private val videoCaptureBuilderFactory: BaseVideoCaptureBuilderFactory
) : CameraPermissionReducer(uiStore), BaseCreateAlifeVideoReducer, VideoCaptureCallback {

    @OptIn(ExperimentalFoundationApi::class)
    private val countDownTimer = CreateAlifeVideoTimer(
        CreateAlifeCountDownTimer(
            onTick = { newTimerUnit -> setState { copy(timerUnit = newTimerUnit) } },
            onEnd = {
                setState { copy(timerUnit = BaseTimerUnit.Init()) }
                getState().pagerContainer.video.pagerItem.onStopRecording()
            }
        )
    )

    fun onSwitchCamera() {
        
    }

    override fun onVideoPrepare(captureWrapper: BaseVideoCaptureWrapper) {
        videoCaptureWrapperToState.map(this, CallbackVideoEvent(this), captureWrapper)
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onStart(
        contextWrapper: BaseContextMainExecutorWrapper,
        videoCapture: BaseStartVideoCaptureState
    ) {
        val fileOutputOptions = videoStorageToOptions.map(
            videoStorageAlifeUseCase.getVideoStorageEntity()
        )

        val recordingWrapper = videoCapture.start(
            contextWrapper,
            videoCaptureBuilderFactory.getBuilder(getState().isAudioEnabled),
            fileOutputOptions
        )

        setState {
            copy(
                pagerContainer = pagerContainer.video.copyContainer(
                    pagerContainer,
                    VideoPagerItem.Recording(RecordingCaptureState(videoCapture, recordingWrapper))
                )
            )
        }
    }


    override fun onStartRecording(event: VideoRecordEvent.Start) {
        countDownTimer.start()
    }

    override fun onFinalizeRecording(event: VideoRecordEvent.Finalize) {
        countDownTimer.stop()

        if (event.hasError()) {
            //setEffect(CreateAlifeEffect.CreateAlifeFinish)
            // TODO придумать что выводить на ошибку
        }
        getState().pagerContainer.video.onCallback(this@CreateAlifeVideoReducer)
    }

    @OptIn(ExperimentalFoundationApi::class)
    override fun setupVideoCaptureState(captureState: BaseStartVideoCaptureState) {
        setState {
            copy(
                pagerContainer = pagerContainer.video.copyContainer(
                    pagerContainer,
                    VideoPagerItem.DefaultSizable(captureState)
                )
            )
        }
    }

    override suspend fun onRecordingAction(
        recordingWrapper: RecordingCaptureState,
        recordingAction: RecordingAction
    ) {
        // TODO обернуть в executor и обработать ошибки
        execute {
            // TODO обработать ошибки, вызвать snackbar
        }.handle {
            recordingAction.onRecordingAction(recordingWrapper)
        }
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