package com.alife.anotherlife.core.composable.alife_card

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.alife_card.chain.DragChainValidator
import com.alife.anotherlife.core.composable.alife_card.model.DpToPxSize
import com.alife.anotherlife.core.composable.alife_card.model.DragModel
import com.alife.anotherlife.core.ui.ComposableMapper

@Composable
fun Modifier.draggableALifeModifier(
    offsetX: MutableState<OffsetModel>,
    offsetY: MutableState<OffsetModel>,
    maxDpSize: DpSize,
    dragChainValidator: DragChainValidator
) = composed {

    val offsetXAnimation by animateDpAsState(targetValue = offsetX.value.calculateDp())
    val offsetYAnimation by animateDpAsState(targetValue = offsetY.value.calculateDp())

    val mainImageSize = DpToPxSize(DpToPx()).map(maxDpSize)

    offset(
        x = offsetXAnimation,
        y = offsetYAnimation
    ).pointerInput(Unit) {
        detectDragGestures(
            onDragEnd = {
                dragChainValidator.handle(
                    DragModel(
                        offsetX,
                        offsetY,
                        mainImageSize,
                        Size(size.width.toFloat(), size.height.toFloat())
                    )
                )
            }
        ) { change, dragAmount ->
            change.consume()

            offsetX.value = offsetX.value.incrementCopy(dragAmount.x)

            if (dragAmount.y > 0f)
                offsetY.value = offsetY.value.incrementCopy(dragAmount.y)
        }
    }
}

interface BaseDpToPx : ComposableMapper<Dp, Float>

class DpToPx : BaseDpToPx {

    @Composable
    override fun map(value: Dp) = with(LocalDensity.current) { value.toPx() }
}


data class OffsetModel(val offset: Float = 0f) {

    fun incrementCopy(incrementValue: Float): OffsetModel {
        return OffsetModel(offset + incrementValue)
    }

    @Composable
    fun calculateDp(): Dp = (offset / LocalDensity.current.density).dp
}