package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.core.composable.addons.ClickableSuspendWrapper
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.addons.ContextMainThreadWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.EmptyVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import java.lang.ref.WeakReference

abstract class NormalVideoContent<VC : BaseVideoCaptureState>(
    protected val captureState: VC,
    isEnabled: Boolean,
    size: Dp
) : SizableVideoContent(isEnabled, size, ClickableSuspendWrapper.Ripple()) {

    class VideoStartable(
        captureState: BaseStartVideoCaptureState,
        isEnabled: Boolean,
        size: Dp
    ) : NormalVideoContent<BaseStartVideoCaptureState>(captureState, isEnabled, size) {
        override suspend fun onClick(context: Context, viewModel: CreateAlifeViewModel) {
            Log.e("Aboba", "Start recording")
            viewModel.reduce(
                CreateAlifeAction.VideoStartRecord(
                    ContextMainThreadWrapper(WeakReference(context)),
                    captureState
                )
            )
        }
    }

    class VideoEmpty(
        captureState: EmptyVideoCaptureState,
        isEnabled: Boolean,
        size: Dp
    ) : NormalVideoContent<EmptyVideoCaptureState>(captureState, isEnabled, size) {
        override suspend fun onClick(context: Context, viewModel: CreateAlifeViewModel) {
            Log.e("Aboba", "VideoEmpty click")
        }
    }
}