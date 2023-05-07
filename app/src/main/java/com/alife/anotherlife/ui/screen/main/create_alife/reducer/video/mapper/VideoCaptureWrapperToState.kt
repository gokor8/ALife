package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper

import androidx.camera.video.VideoRecordEvent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.core.util.Consumer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.VideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.StartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.ErrorCameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.BaseCreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.CreateAlifeVideoReducer
import javax.inject.Inject

class VideoCaptureWrapperToState @Inject constructor() : BaseVideoCaptureWrapperToState {

    @OptIn(ExperimentalFoundationApi::class)
    override fun map(
        reducer: BaseCreateAlifeVideoReducer,
        callbackVideoEvent: Consumer<VideoRecordEvent>,
        captureWrapper: BaseVideoCaptureWrapper
    ) {
        when (captureWrapper) {
            is VideoCaptureWrapper -> reducer.setState {
                copy(
                    pagerContainer = pagerContainer.video.copyContainer(
                        pagerContainer,
                        VideoPagerItem.DefaultSizable(
                            StartVideoCaptureState(captureWrapper.videoCapture, callbackVideoEvent)
                        )
                    )
                )
            }
            else -> reducer.setState { copy(blockingScreen = ErrorCameraScreenState()) }
        }
    }
}