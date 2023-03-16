package com.alife.anotherlife.core.composable.alife_card

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
) = composed {
    offset(
        x = offsetX.value.calculateDp(),
        y = offsetY.value.calculateDp()
    ).pointerInput(Unit) {
        detectDragGestures(
            onDragEnd = {
                val resultX = if((extendedTouchPadding.width/2f) > offsetX.value.offset)
                    extendedTouchPadding.width
                else
                    0f

                animateFloatAsState(targetValue = resultX)

                offsetY.value = offsetY.value.copy(0f)
            }
        ) { change, dragAmount ->
            change.consume()
            offsetX.value = offsetX.value.incrementCopy(dragAmount.x)
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