package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.PagerItemSize
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

interface CreateAlifePagerItem {

    @Composable
    fun Content(
        size: Dp,
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    )


    abstract class Abstract(
        protected val pagerItemSize: PagerItemSize = PagerItemSize.Default()
    ) : CreateAlifePagerItem
}