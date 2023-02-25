package com.alife.anotherlife.core.composable.text.text_formation

import android.util.Log
import androidx.compose.ui.text.input.OffsetMapping
import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList

class MaskOffsetMapping(private val maskList: MaskList) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        val staticOffset = maskList.notEmptyUnitCount(offset)
        Log.e("originalToTransformed", "$offset + res: $staticOffset")
        return staticOffset//+ newOffset
    }

    override fun transformedToOriginal(offset: Int): Int {
        val staticOffset = maskList.maskUnitsCount(offset)
        Log.e("transformedToOriginal", "$offset - $staticOffset")
        return offset - staticOffset
        //return offset + maskList.getClearSize(offset - 1)
    }
}

// +7(
//(0)+(1)7(2|(|3)