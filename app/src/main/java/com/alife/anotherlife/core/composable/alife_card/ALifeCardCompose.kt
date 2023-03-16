package com.alife.anotherlife.core.composable.alife_card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.image.ImageBase

@Composable
fun ALifeCardCompose() {
    val offsetX = remember { mutableStateOf(OffsetModel()) }
    val offsetY = remember { mutableStateOf(OffsetModel()) }
    Box {
        ImageBase(R.drawable.img_tutor_back, modifier = Modifier.fillMaxSize())

        ImageBase(
            R.drawable.img_tutor_front,
            modifier = Modifier
                .size(100.dp, 150.dp)
                .draggableALifeModifier(offsetX, offsetY)
        )
    }
}

@Preview
@Composable
fun ALifeCardComposePreview() {
    ALifeCardCompose()
}