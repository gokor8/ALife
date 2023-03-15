package com.alife.anotherlife.core.composable.alife_card

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ALifeDragAndDropCompose(
    offsetX: MutableState<OffsetModel>,
    offsetY: MutableState<OffsetModel>,
): Modifier {
    return Modifier.offset(
        x = offsetX.value.calculateDp(),
        y = offsetX.value.calculateDp()
    ).pointerInput(Unit) {
        detectDragGestures(
            onDragEnd = {

            }
        ) { change, dragAmount ->
            change.consume()
            offsetX.value = offsetX.value.incrementCopy(dragAmount.x)
            offsetY.value = offsetY.value.incrementCopy(dragAmount.y)
        }
    }
}

data class OffsetModel(private val value: Float = 0f) {

    fun incrementCopy(incrementValue: Float): OffsetModel {
        return OffsetModel(value + incrementValue)
    }

    @Composable
    fun calculateDp(): Dp = (value/LocalDensity.current.density).dp
}