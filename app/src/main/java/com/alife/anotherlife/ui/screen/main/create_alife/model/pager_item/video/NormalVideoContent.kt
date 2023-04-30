package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video

import android.util.Log
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.core.composable.addons.ClickableSuspendWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper

class NormalVideoContent(size: Dp) : SizableVideoContent(size, ClickableSuspendWrapper.Ripple()) {
    override suspend fun onClick(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    ) {
        Log.e("Aboba", "Start recording")
    }
}