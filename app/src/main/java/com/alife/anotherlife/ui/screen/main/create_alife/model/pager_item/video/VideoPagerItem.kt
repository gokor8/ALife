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
import com.alife.anotherlife.ui.screen.main.create_alife.composable.VideoCircleComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem

interface VideoPagerItem : CreateAlifePagerItem, InvertiblePagerItem {

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