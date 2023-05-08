package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper

class EmptyAlifePagerItem : CreateAlifePagerItem, CreateAlifePagerItem.Abstract() {
    
    @Composable
    override fun Content(
        size: Dp,
        viewModel: CreateAlifeViewModel
    ) {}
}