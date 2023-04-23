package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.addons.stroke6Draw
import com.alife.anotherlife.core.composable.clickable
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

interface VideoCameraPagerItem : CreateAlifePagerItem {

    interface CapturingVideo : VideoCameraPagerItem {
        @Composable
        override fun Content(
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            val colorScheme = MaterialTheme.colorScheme

            Canvas(modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .clickable(rememberCoroutineScope()) {

                }
            ) {
                drawCircle(color = colorScheme.onPrimary, style = stroke6Draw())
                drawCircle(color = colorScheme.onPrimary, size.maxDimension / 2.5f)
                drawCircle(color = colorScheme.primary, 20f)
            }
        }
    }

    class InitCaptureVideo : CapturingVideo {
        @OptIn(ExperimentalPermissionsApi::class)
        @Composable
        override fun Content(captureWrapper: BaseCaptureWrapper, viewModel: CreateAlifeViewModel) {
            val audioPermission = viewModel.audioPermission.requirePermission(viewModel)

            // TODO проверять в листе(цепочке), если тстатус Granted, либо Fatal, запускать второй пермишн

            viewModel.cameraPermission.requirePermission { status ->
                if(status is PermissionStatus.Success)
                    audioPermission.launchPermissionRequest()
                else
                    viewModel.reduce(CreateAlifeAction.PermissionFatalAction())
            }

            super.Content(captureWrapper, viewModel)
        }
    }

    class CaptureVideo : CapturingVideo

    class OnCapturingVideo : VideoCameraPagerItem {
        @Composable
        override fun Content(captureWrapper: BaseCaptureWrapper, viewModel: CreateAlifeViewModel) {
            // TODO Add canvas
        }
    }
}