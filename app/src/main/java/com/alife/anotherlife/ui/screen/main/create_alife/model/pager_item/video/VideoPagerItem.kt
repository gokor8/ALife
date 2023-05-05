package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video

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
import com.alife.anotherlife.ui.screen.main.create_alife.composable.VideoCircleComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.EmptyVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.StartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.NotScrollablePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction

@Stable
interface VideoPagerItem : CreateAlifePagerItem, InvertiblePagerItem {

    abstract class Sizable(
        private val captureState: BaseVideoCaptureState,
        private val isEnabled: Boolean
    ) : VideoPagerItem,
        CreateAlifePagerItem.Abstract() {
        @Composable
        override fun Content(
            size: Dp,
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            val defaultSize = pagerItemSize.sizeDp()

            if (size == defaultSize) {
                NormalVideoContent(captureState, isEnabled, defaultSize)
            } else {
                SmallVideoContent(size)
            }.Content(captureWrapper, viewModel)
        }
    }

    class InitSizable : Sizable(EmptyVideoCaptureState(), false)
    class DefaultSizable(captureState: StartVideoCaptureState) : Sizable(captureState, true)

    class OnRecording(
        private val captureState: RecordingCaptureState
    ) : CreateAlifePagerItem.Abstract(), VideoPagerItem, NotScrollablePagerItem {
        @Composable
        override fun Content(
            size: Dp,
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            MaterialTheme.colorScheme.apply {
                VideoCircleComposable(
                    onPrimary,
                    onPrimary,
                    primary,
                    modifier = Modifier
                        .size(size)
                        .clip(CircleShape)
                        .clickable {
                            captureState.stop()
//                            viewModel.reduce(
//                                CreateAlifeAction.VideoRecordingAction(RecordingAction.STOP)
//                            )
                            //viewModel.reduce(CreateAlifeAction.)
                        }
                )
            }
        }
    }
}