package com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.mapper

import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.callback.CallbackVideoEvent
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.VideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.StartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.ErrorCameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.CreateAlifeVideoReducer
import javax.inject.Inject

class VideoCaptureWrapperToState @Inject constructor(
    private val fileOutputOptions: BaseFileOutputOptions,
) {

    @OptIn(ExperimentalFoundationApi::class)
    fun map(
        reducer: CreateAlifeVideoReducer,
        callbackVideoEvent: CallbackVideoEvent,
        captureWrapper: BaseVideoCaptureWrapper
    ) {
        when (captureWrapper) {
            is VideoCaptureWrapper -> reducer.setState {
                copy(
                    pagerContainer = pagerContainer.video.copyContainer(
                        pagerContainer,
                        VideoPagerItem.DefaultSizable(
                            StartVideoCaptureState(
                                captureWrapper.videoCapture,
                                fileOutputOptions.options(),
                                callbackVideoEvent
                            )
                        )
                    )
                )
            }
            else -> reducer.setState { copy(blockingScreen = ErrorCameraScreenState()) }
        }
    }
}