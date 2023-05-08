package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.EmptyVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.VideoCaptureCallback

@Stable
interface VideoPagerItem : CreateAlifePagerItem {

    fun onCallback(videoCaptureCallback: VideoCaptureCallback) = Unit

    fun onStopRecording() = Unit


    abstract class Sizable<VC : BaseVideoCaptureState>(
        protected val captureState: VC,
        private val isEnabled: Boolean
    ) : VideoPagerItem, CreateAlifePagerItem.Abstract() {

        @Composable
        override fun Content(
            size: Dp,
            viewModel: CreateAlifeViewModel
        ) {
            val defaultSize = pagerItemSize.sizeDp()

            if (size == defaultSize) {
                normalVideoContent(isEnabled, defaultSize)
            } else {
                SmallVideoContent(size)
            }.Content(viewModel)
        }

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
    ) : Sizable<BaseStartVideoCaptureState>(captureState, true), InvertiblePagerItem {
        override fun onCallback(videoCaptureCallback: VideoCaptureCallback) {
            videoCaptureCallback.setupVideoCaptureState(captureState)
        }

        @Composable
        override fun normalVideoContent(isEnabled: Boolean, size: Dp) =
            NormalVideoContent.VideoStartable(captureState, isEnabled, size)
    }

}