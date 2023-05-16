package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.util.Log
import androidx.camera.video.VideoRecordEvent
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducerBase
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.audio.AudioModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.audio.BaseAudioActionModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.BaseVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.BaseCameraPermissionReducer
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.CoroutineScope

interface CreateAlifeAction : BaseMVIAction<BaseCreateAlifeReducerBase> {

    class ChangeCameraSelection : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onChangeCamera()
        }
    }

    class OnChangedAudio(
        private val audioActionModel: BaseAudioActionModel
    ) : CreateAlifeAction {

        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onChangedAudio(audioActionModel)
        }
    }

    class OnPictureLoading : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onPictureLoading()
        }
    }

    class OnVideoLoading : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onVideoLoading()
        }
    }

    class OnCaptureWrapper(private val captureWrapper: BaseCaptureWrapper) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onCameraWrapper(captureWrapper)
        }
    }

    abstract class OnVideoWrapper(
        protected val captureWrapper: BaseVideoCaptureWrapper
    ) : CreateAlifeAction {

        class Default(captureWrapper: BaseVideoCaptureWrapper) : OnVideoWrapper(captureWrapper) {
            override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
                reducer.onVideoWrapper(captureWrapper)
            }
        }

        class Switched(captureWrapper: BaseVideoCaptureWrapper) : OnVideoWrapper(captureWrapper) {
            override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
                // TODO изменить на нужный метод
                reducer.onVideoWrapper(captureWrapper)
            }
        }
    }

    class CreatePhoto(
        val contextWrapper: BaseContextMainExecutorWrapper,
        val cookedCaptureWrapper: CookedCaptureWrapper
    ) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) = Unit
    }

    class CreatePhotoScoped(
        private val coroutineScope: CoroutineScope,
        private val contextWrapper: BaseContextMainExecutorWrapper,
        private val cookedCaptureWrapper: CookedCaptureWrapper
    ) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onCreatePhoto(coroutineScope, contextWrapper, cookedCaptureWrapper)
        }
    }


    class ClickSmallVideo : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onClickSmallVideo()
        }
    }

    abstract class CameraPermission<S : ScreenState>(
        protected val status: PermissionStatus,
    ) : CreateAlifeAction {
        suspend fun onPermission(
            reducer: BaseCameraPermissionReducer<S>,
            screenState: S
        ) {
            when (status) {
                is PermissionStatus.Success -> reducer.onPermissionGranted(screenState)
                is PermissionStatus.Fatal -> reducer.onPermissionFatal()
            }
        }
    }

    class PhotoPermission(
        status: PermissionStatus,
        private val screenState: BasePictureScreenState
    ) : CameraPermission<BasePictureScreenState>(status) {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onPicturePermission(this, screenState)
        }
    }

    class VideoPermission(
        status: PermissionStatus,
        private val screenState: BaseVideoScreenState
    ) : CameraPermission<BaseVideoScreenState>(status) {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onVideoPermission(this, screenState)
        }
    }

    class VideoStartRecord(
        private val mainExecutorWrapper: BaseContextMainExecutorWrapper,
        private val captureState: BaseStartVideoCaptureState
    ) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            Log.e("RecordingAction", captureState.toString())
            reducer.onStartVideo(mainExecutorWrapper, captureState)
        }
    }

    class VideoRecordingAction(
        private val captureState: RecordingCaptureState,
        private val recordingAction: RecordingAction
    ) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            Log.e("RecordingAction", recordingAction.toString())
            reducer.onRecordingAction(captureState, recordingAction)
            // reducer.onRecordingActions(recordingAction)
            //TODO
        }
    }

    class AudioPermission(private val permissionStatus: PermissionStatus) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onAudioPermission(permissionStatus)
        }
    }
}