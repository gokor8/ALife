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

class NormalVideoContent(size: Dp) : SizableVideoContent(size, ClickableSuspendWrapper.Ripple()) {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun Content(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    ) {
        Log.d("Aboba Pager Item", "$this")

        val audioPermission = viewModel.audioPermission.requirePermission(viewModel)

        // TODO проверять в листе(цепочке), если тстатус Granted, либо Fatal, запускать второй пермишн

        viewModel.cameraPermission.requirePermission { status ->

            val isGranted = status is PermissionStatus.Success

            viewModel.reduce(CreateAlifeAction.VideoPermission(isGranted))

            if(isGranted) audioPermission.launchPermissionRequest()
        }

        super.Content(captureWrapper, viewModel)
    }

    override suspend fun onClick(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    ) {
        Log.e("Aboba", "Start recording")
    }
}