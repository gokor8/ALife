package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video

import android.content.Context
import android.util.Log
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.core.composable.addons.ClickableSuspendWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction

class SmallVideoContent(size: Dp) :
    SizableVideoContent(true, size, ClickableSuspendWrapper.NoRipple()) {

    override suspend fun onClick(
        context: Context,
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    ) {
        Log.e("Aboba", "ClickSmallVideo")
        viewModel.reduce(CreateAlifeAction.ClickSmallVideo())
    }
}