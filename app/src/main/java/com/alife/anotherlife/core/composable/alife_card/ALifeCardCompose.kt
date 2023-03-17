package com.alife.anotherlife.core.composable.alife_card

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.image.ImageBase

@Composable
fun ALifeCardCompose(modifier: Modifier = Modifier) {
    val offsetX = remember { mutableStateOf(OffsetModel()) }
    val offsetY = remember { mutableStateOf(OffsetModel()) }

    BoxWithConstraints(
        modifier = modifier
    ) {
        ImageBase(
            R.drawable.img_tutor_back,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        ImageBase(
            R.drawable.img_tutor_front,
            modifier = Modifier
                .size(100.dp, 150.dp)
                .draggableALifeModifier(offsetX, offsetY, maxWidth, maxHeight)
        )
    }
}

@Preview
@Composable
fun ALifeCardComposePreview() {
    ALifeCardCompose()
}