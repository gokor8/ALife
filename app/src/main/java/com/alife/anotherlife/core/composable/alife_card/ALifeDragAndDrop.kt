package com.alife.anotherlife.core.composable.alife_card

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import com.alife.anotherlife.core.composable.alife_card.chain.DragChainValidator
import com.alife.anotherlife.core.composable.alife_card.mapper.DpToPxSize
import com.alife.anotherlife.core.composable.alife_card.model.DragModel
import com.alife.anotherlife.core.composable.alife_card.model.DragSizeModel
import com.alife.anotherlife.core.composable.alife_card.start_strategy.StartStrategy
import com.alife.anotherlife.core.ui.ComposableMapper

fun Modifier.draggableALifeModifier(
    startStrategy: StartStrategy,
    mainImageDpSize: DpSize,
    smallImageDpSize: DpSize,
    dragChainValidator: DragChainValidator,
) = composed {

    val dpToPx = DpToPxSize()

    val mainImageSize = dpToPx.map(mainImageDpSize)
    val smallImageSize = dpToPx.map(smallImageDpSize)

    var offsets by remember {
        mutableStateOf(
            startStrategy.createOffset(
                DragSizeModel(mainImageSize, smallImageSize)
            )
        )
    }

    val offsetXAnimation by animateDpAsState(targetValue = offsets.offsetX.calculateDp())
    val offsetYAnimation by animateDpAsState(targetValue = offsets.offsetY.calculateDp())

    offset(
        x = offsetXAnimation,
        y = offsetYAnimation
    ).pointerInput(Unit) {
        detectDragGestures(
            onDragEnd = {
                val offsetContainer = dragChainValidator.handle(
                    DragModel(
                        offsets,
                        mainImageSize,
                        Size(size.width.toFloat(), size.height.toFloat())
                    )
                )

                offsets = offsetContainer
            }
        ) { change, dragAmount ->
            change.consume()

            offsets = offsets.incrementX(dragAmount.x)

            if (dragAmount.y > 0f)
                offsets = offsets.incrementY(dragAmount.y)
        }
    }
}