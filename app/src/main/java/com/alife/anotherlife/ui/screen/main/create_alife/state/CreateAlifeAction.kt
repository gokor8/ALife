package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.util.Log
import androidx.camera.video.VideoRecordEvent
import com.alife.anotherlife.core.composable.mvi_extensions.BaseMVIAction
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.BaseCreateAlifeReducerBase
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.BaseCameraPermissionReducer
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

interface CreateAlifeAction : BaseMVIAction<BaseCreateAlifeReducerBase> {

    class ChangeCameraSelection : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onChangeCamera()
        }
    }

    class OnCaptureWrapper(private val captureWrapper: BaseCaptureWrapper) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onCameraWrapper(captureWrapper)
        }
    }

    class CreatePhoto(private val contextWrapper: BaseContextMainExecutorWrapper) :
        CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onCreatePhoto(contextWrapper)
        }
    }

    class ClickSmallVideo : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onClickSmallVideo()
        }
    }

    abstract class CameraPermission(
        protected val status: PermissionStatus,
        private val newScreenState: ScreenState
    ) : CreateAlifeAction {
        suspend fun onPermission(reducer: BaseCameraPermissionReducer) {
            when (status) {
                is PermissionStatus.Success -> reducer.onPermissionGranted(newScreenState)
                is PermissionStatus.Fatal -> reducer.onPermissionFatal()
            }
        }
    }

    class PhotoPermission(
        status: PermissionStatus,
        newScreenState: ScreenState
    ) : CameraPermission(status, newScreenState) {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onPicturePermission(this)
        }
    }

    class VideoPermission(
        status: PermissionStatus,
        newScreenState: ScreenState
    ) : CameraPermission(status, newScreenState) {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onVideoPermission(this)
        }
    }

    class VideoStartRecord(
        private val captureState: BaseVideoCaptureState
    ) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            Log.e("RecordingAction", captureState.toString())
            // reducer.onStartRecord(captureState)
            //TODO
        }
    }

    class VideoRecordingAction(
        private val recordingAction: RecordingAction
    ) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            Log.e("RecordingAction", recordingAction.toString())
            // reducer.onRecordingActions(recordingAction)
            //TODO
        }
    }

    class VideoRecordEventAction(
        private val videoRecordEvent: VideoRecordEvent
    ) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            Log.e("VideoRecordEvent", videoRecordEvent.toString())
            // reducer.onVideoRecordEvent(videoRecordEvent)
            //TODO
        }
    }

    class AudioPermission(private val permissionStatus: PermissionStatus) : CreateAlifeAction {
        override suspend fun onAction(reducer: BaseCreateAlifeReducerBase) {
            reducer.onAudioPermission(permissionStatus)
        }
    }
}