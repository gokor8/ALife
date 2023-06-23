package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.image.ImageExtModel

class EmptyImageExtModel : ImageExtModel {

    @Composable
    override fun ImageContent(modifier: Modifier) {
        Box(modifier = modifier.background(Color.Gray)) {
            Image(
                painter = rememberAsyncImagePainter(R.drawable.ic_profile_mock),
                contentDescription = "",
                modifier = Modifier.align(Alignment.Center).size(100.dp)
            )
        }
    }
}