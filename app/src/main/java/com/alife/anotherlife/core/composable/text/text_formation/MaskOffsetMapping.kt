package com.alife.anotherlife.core.composable.text.text_formation

import android.util.Log
import androidx.compose.ui.text.input.OffsetMapping
import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList

class MaskOffsetMapping(private val maskList: MaskList) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        val currentOffset = maskList.toTransformOffsetPosition(offset)
        Log.e("Mask originalToTransformed", "$offset + res: $currentOffset")
        return currentOffset
    }

    override fun transformedToOriginal(offset: Int): Int {
        val currentOffset = maskList.toOriginOffsetPosition(offset)
        Log.e("Mask transformedToOriginal", "$offset - $currentOffset")
        return currentOffset
    }
}