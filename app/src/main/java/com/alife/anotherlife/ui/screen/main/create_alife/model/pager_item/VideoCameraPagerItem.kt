package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.addons.stroke6Draw
import com.alife.anotherlife.core.composable.clickable
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.VideoCircleComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.PagerItemSize
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

interface VideoCameraPagerItem : CreateAlifePagerItem {

    abstract class SizablePagerItem : VideoCameraPagerItem, CreateAlifePagerItem.Abstract() {
        @Composable
        override fun Content(
            size: Dp,
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            val defaultSize = pagerItemSize.sizeDp()

            if(size == defaultSize) {
                FullVideCamera(defaultSize)
            } else {
                SizableVideCamera(size)
            }.Content(captureWrapper, viewModel)
        }
    }

    class DefaultSizable : SizablePagerItem()

    abstract class SizedVideoCamera(private val size: Dp) {
        @Composable
        fun Content(
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
                        .clickable(rememberCoroutineScope(), onClick = {
                            onClick(captureWrapper, viewModel)
                        })
                )
            }
        }

        abstract suspend fun onClick(
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        )
    }

    class FullVideCamera(size: Dp) : SizedVideoCamera(size) {
        override suspend fun onClick(
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            Log.e("Aboba", "Start recording")
        }
    }

    class SizableVideCamera(size: Dp) : SizedVideoCamera(size) {
        override suspend fun onClick(
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            Log.e("Aboba", "Set video to main pager")
            viewModel.reduce(CreateAlifeAction.ClickSmallVideo())
        }
    }
}

//class VideoCameraPagerItem : CreateAlifePagerItem {
//
//    @Composable
//    override fun Content(
//        size: Dp,
//        captureWrapper: BaseCaptureWrapper,
//        viewModel: CreateAlifeViewModel
//    ) {
//        MaterialTheme.colorScheme.apply {
//            VideoCircle(
//                onPrimary,
//                onPrimary,
//                primary,
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .clickable(rememberCoroutineScope()) {
//
//                    }
//            )
//        }
//    }
//}
//
//@Preview
//@Composable
//fun VideoCirclePreview() {
//    VideoCameraPagerItem().VideoCircle(
//        Color.White,
//        Color.White,
//        Color.Black,
//        modifier = Modifier.size(60.dp)
//    )
//}