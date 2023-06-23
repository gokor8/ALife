package com.alife.anotherlife.core.composable.alife_card

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.alife_card.chain.DefaultDragXChain
import com.alife.anotherlife.core.composable.alife_card.chain.DragChainValidator
import com.alife.anotherlife.core.composable.alife_card.chain.LeftDragXYChain
import com.alife.anotherlife.core.composable.alife_card.model.UIAlifeCardModel
import com.alife.anotherlife.core.composable.alife_card.start_strategy.PocketStrategy
import com.alife.anotherlife.core.composable.alife_card.start_strategy.StartStrategy
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.view_group.CardWithConstraints
import com.alife.anotherlife.theme.Shapes

@Composable
fun ALifeCardCompose(
    uiAlifeCardModel: UIAlifeCardModel,
    offsetsStartStrategy: StartStrategy = PocketStrategy(),
    modifier: Modifier = Modifier,
    mainImageModifier: Modifier = Modifier.fillMaxSize()
) {
    val shape = Shapes.large

    CardWithConstraints(modifier = modifier, shape = shape) {
        var isReversed by rememberSaveable { mutableStateOf(false) }

        uiAlifeCardModel.Images(
            isReversed = isReversed,
            Modifier
                .size(100.dp, 135.dp)
                .draggableALifeModifier(
                    offsetsStartStrategy,
                    DpSize(maxWidth, maxHeight),
                    DpSize(100.dp, 150.dp),
                    DragChainValidator(
                        LeftDragXYChain(),
                        DefaultDragXChain()
                    )
                )
                .clip(shape)
                .clickableNoRipple {
                    isReversed = !isReversed
                },
            mainImageModifier.clip(shape)
        )
    }
}

@Preview
@Composable
fun ALifeCardComposePreview() {
    val uiPicturesModel = UIAlifeCardModel.Default(
        R.drawable.img_tutor_front, R.drawable.img_tutor_back
    )

    ALifeCardCompose(uiPicturesModel, PocketStrategy())
}