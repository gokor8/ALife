package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.addons.stroke6Draw
import com.alife.anotherlife.core.composable.clickable
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.VideoCircleComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.NormalVideoContent
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.SmallVideoContent
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi

interface VideoCameraPagerItem : CreateAlifePagerItem {

    class Sizable : VideoPagerItem, CreateAlifePagerItem.Abstract() {
        @Composable
        override fun Content(
            size: Dp,
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            val defaultSize = pagerItemSize.sizeDp()

            if (size == defaultSize) {
                NormalVideoContent(defaultSize)
            } else {
                SmallVideoContent(size)
            }.Content(captureWrapper, viewModel)
        }
    }

    class OnRecording : VideoPagerItem, CreateAlifePagerItem.Abstract() {
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
                            //viewModel.reduce(CreateAlifeAction.)
                        }
                )
            }
        }
    }
}