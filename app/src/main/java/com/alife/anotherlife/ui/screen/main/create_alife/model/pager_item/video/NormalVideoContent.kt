package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.core.composable.addons.ClickableSuspendWrapper
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class NormalVideoContent(isEnabled: Boolean, size: Dp) :
    SizableVideoContent(isEnabled, size, ClickableSuspendWrapper.Ripple()) {

    override suspend fun onClick(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    ) {
        Log.e("Aboba", "Start recording")
    }
}