package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.VideoOnRecordingComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.EmptyVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.NotScrollablePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.VideoCaptureCallback
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction

@Stable
interface VideoPagerItem : CreateAlifePagerItem, InvertiblePagerItem {

    fun onCallback(videoCaptureCallback: VideoCaptureCallback) = Unit

    fun onStopRecording() = Unit

    fun isCookedVideoCapture(): Boolean


    abstract class Sizable<VC : BaseVideoCaptureState>(
        protected val captureState: VC,
        private val isEnabled: Boolean
    ) : VideoPagerItem, CreateAlifePagerItem.Abstract() {

        @Composable
        override fun Content(
            size: Dp,
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            val defaultSize = pagerItemSize.sizeDp()

            if (size == defaultSize) {
                normalVideoContent(isEnabled, defaultSize)
            } else {
                SmallVideoContent(size)
            }.Content(captureWrapper, viewModel)
        }

        override fun isCookedVideoCapture() = captureState is BaseStartVideoCaptureState

        @Composable
        abstract fun normalVideoContent(isEnabled: Boolean, size: Dp): NormalVideoContent<VC>
    }

    class InitSizable : Sizable<EmptyVideoCaptureState>(EmptyVideoCaptureState(), false) {
        @Composable
        override fun normalVideoContent(isEnabled: Boolean, size: Dp) =
            NormalVideoContent.VideoEmpty(captureState, isEnabled, size)
    }

    class DefaultSizable(
        captureState: BaseStartVideoCaptureState
    ) : Sizable<BaseStartVideoCaptureState>(captureState, true) {
        override fun onCallback(videoCaptureCallback: VideoCaptureCallback) {
            videoCaptureCallback.setupVideoCaptureState(captureState)
        }

        @Composable
        override fun normalVideoContent(isEnabled: Boolean, size: Dp) =
            NormalVideoContent.VideoStartable(captureState, isEnabled, size)
    }

    class Recording(
        private val captureState: RecordingCaptureState
    ) : CreateAlifePagerItem.Abstract(), VideoPagerItem, NotScrollablePagerItem {

        @Composable
        override fun Content(
            size: Dp,
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            VideoOnRecordingComposable(
                MaterialTheme.colorScheme.onPrimary,
                MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(size)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.reduce(
                            CreateAlifeAction.VideoRecordingAction(
                                captureState,
                                RecordingAction.Stop()
                            )
                        )
                    }
            )
        }

        override fun onStopRecording() {
            captureState.stop()
        }

        override fun isCookedVideoCapture() = true

        override fun onCallback(videoCaptureCallback: VideoCaptureCallback) {
            videoCaptureCallback.setupVideoCaptureState(captureState.videoCapture)
        }
    }
}