package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.model

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.ui.image.ImageExtModel

class GeoImageExtModel : ImageExtModel {

    @Composable
    override fun ImageContent(modifier: Modifier) {
        IconBase(icon = R.drawable.ic_gps, modifier)
    }
}