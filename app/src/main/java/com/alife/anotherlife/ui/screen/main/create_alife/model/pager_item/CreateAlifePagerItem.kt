package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

import androidx.compose.runtime.Composable
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper

interface CreateAlifePagerItem {

    @Composable
    fun Content(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    )

    @Composable
    fun InactiveContent() = Unit
}