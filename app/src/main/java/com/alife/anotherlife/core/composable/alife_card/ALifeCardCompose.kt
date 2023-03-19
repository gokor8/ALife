package com.alife.anotherlife.core.composable.alife_card

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.alife_card.chain.DefaultDragXChain
import com.alife.anotherlife.core.composable.alife_card.chain.DragChainValidator
import com.alife.anotherlife.core.composable.alife_card.chain.LeftDragXYChain
import com.alife.anotherlife.core.composable.alife_card.start_strategy.PocketStrategy
import com.alife.anotherlife.core.composable.alife_card.start_strategy.StartStrategy
import com.alife.anotherlife.core.composable.image.ImageBase

@Composable
fun ALifeCardCompose(
    offsetsStartStrategy: StartStrategy,
    modifier: Modifier = Modifier,
) {
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
                .draggableALifeModifier(
                    offsetsStartStrategy,
                    DpSize(maxWidth, maxHeight),
                    DpSize(100.dp, 150.dp),
                    DragChainValidator(
                        LeftDragXYChain(),
                        DefaultDragXChain()
                    )
                )
        )
    }
}

@Preview
@Composable
fun ALifeCardComposePreview() {
    ALifeCardCompose(PocketStrategy())
}