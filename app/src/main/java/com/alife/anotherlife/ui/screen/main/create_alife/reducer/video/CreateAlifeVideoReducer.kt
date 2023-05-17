package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import androidx.camera.video.VideoRecordEvent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.audio.BaseAudioActionModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.BaseVideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.RecordingPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ErrorPermissionScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.LoadPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.BaseVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.LoadVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.VideoErrorPermissionScreenState
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
) : CameraPermissionReducer<BaseVideoScreenState>(uiStore),
    BaseCreateAlifeVideoReducer,
    VideoCaptureCallback {

    @OptIn(ExperimentalFoundationApi::class)
    private val countDownTimer = CreateAlifeVideoTimer(
        CreateAlifeCountDownTimer(
            onTick = { newTimerUnit -> setState { copy(timerUnit = newTimerUnit) } },
            onEnd = { getState().pagerContainer.video.pagerItem.onStopRecording() }
        )
    )

    override fun changeCurrentScreen(screenState: BaseVideoScreenState) = getState {
        pagerContainer.video.copyContainer(pagerContainer, screenState)
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

        // TODO may be catch this code
        val recordingWrapper = videoCapture.start(
            contextWrapper,
            videoCaptureBuilderFactory.getBuilder(getState().audioEnabledModel.isChecked()),
            fileOutputOptions
        )

        setState {
            copy(
                pagerContainer = pagerContainer.video.copyContainer(
                    pagerContainer,
                    RecordingPagerItem(RecordingCaptureState(videoCapture, recordingWrapper))
                )
            )
        }
    }

    override fun onStartRecording(event: VideoRecordEvent.Start) {
        countDownTimer.start()
    }

    @OptIn(ExperimentalFoundationApi::class)
    override fun onFinalizeRecording(event: VideoRecordEvent.Finalize) {
        countDownTimer.stop()

        setState { copy(timerUnit = BaseTimerUnit.Init()) }

        if (event.hasError())
            trySetEffect(CreateAlifeEffect.SnackVideoError())
        else
            trySetEffect(CreateAlifeEffect.GoBack())

        getState().pagerContainer.video.onCallback(this@CreateAlifeVideoReducer)
    }

    override suspend fun onRecordingAction(
        captureState: RecordingCaptureState,
        recordingAction: RecordingAction
    ) {
        execute {
            // TODO check
            trySetEffect(CreateAlifeEffect.SnackVideoError())
            setupVideoCaptureState(captureState.videoCapture)
        }.handle {
            recordingAction.onRecordingAction(captureState)
        }
    }

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

    override suspend fun onClickSmallVideo() {
        setEffect(
            CreateAlifeEffect.VideoToMainPage(
                getState().pagerContainer.getVideoIndex()
            )
        )
    }

    override suspend fun onVideoLoading() {
        setState {
            copy(
                pagerContainer = pagerContainer.video.copyContainer(
                    pagerContainer,
                    LoadVideoScreenState()
                )
            )
        }
    }

    override suspend fun onPermissionFatal() {
        setState {
            copy(
                pagerContainer = pagerContainer.video.copyContainer(
                    pagerContainer,
                    VideoErrorPermissionScreenState()
                )
            )
        }
    }

    override suspend fun onAudioPermission(permissionStatus: PermissionStatus) {
        // TODO придумать как сделать лучше
        if (permissionStatus is PermissionStatus.PreFatal) {
            setEffect(CreateAlifeEffect.AudioDialogErrorEffect())
        }
        //setState { copy(isAudioEnabled = permissionStatus is PermissionStatus.Success) }
    }
}