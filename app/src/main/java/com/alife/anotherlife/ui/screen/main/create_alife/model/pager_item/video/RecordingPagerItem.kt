package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.VideoOnRecordingComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.RecordingAction
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.RecordingCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.NotScrollablePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.VideoCaptureCallback
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction

class RecordingPagerItem(
    private val captureState: RecordingCaptureState
) : CreateAlifePagerItem.Abstract(),
    VideoPagerItem,
    NotScrollablePagerItem {

    @Composable
    override fun Content(
        size: Dp,
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
                        CreateAlifeAction.VideoRecordingAction(captureState, RecordingAction.Stop())
                    )
                }
        )
    }

    override fun onStopRecording() {
        captureState.stop()
    }

    override fun onCallback(videoCaptureCallback: VideoCaptureCallback) {
        videoCaptureCallback.setupVideoCaptureState(captureState.videoCapture)
    }
}