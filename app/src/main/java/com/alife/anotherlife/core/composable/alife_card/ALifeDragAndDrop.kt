package com.alife.anotherlife.core.composable.alife_card

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.draggableALifeModifier(
    offsetX: MutableState<OffsetModel>,
    offsetY: MutableState<OffsetModel>,
    maxWidthDp: Dp,
    maxHeightDp: Dp
) = composed {

    val offsetXAnimation by animateDpAsState(targetValue = offsetX.value.calculateDp())
    val offsetYAnimation by animateDpAsState(targetValue = offsetY.value.calculateDp())

    val maxWidth = with(LocalDensity.current) { maxWidthDp.toPx() }
    val maxHeight = with(LocalDensity.current) { maxHeightDp.toPx() }

    offset(
        x = offsetXAnimation,
        y = offsetYAnimation
    ).pointerInput(Unit) {
        detectDragGestures(
            onDragEnd = {
                val resultX = if ((maxWidth / 2f) < offsetX.value.offset)
                    maxWidth - size.width.toFloat()
                else
                    0f
                offsetX.value = offsetX.value.copy(resultX)

                offsetY.value = offsetY.value.copy(0f)
            }
        ) { change, dragAmount ->
            change.consume()

            offsetX.value = offsetX.value.incrementCopy(dragAmount.x)

            if(dragAmount.y > 0f)
                offsetY.value = offsetY.value.incrementCopy(dragAmount.y)
        }
    }
}

data class OffsetModel(val offset: Float = 0f) {

    fun incrementCopy(incrementValue: Float): OffsetModel {
        return OffsetModel(offset + incrementValue)
    }

    @Composable
    fun calculateDp(): Dp = (offset / LocalDensity.current.density).dp
}