package com.alife.anotherlife.core.composable.text.text_formation

import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList

class MaskVTDelegate(
    private val maskList: MaskList,
    private val onValueChanged: (TextFieldValue) -> Unit
) : VisualTransformationDelegate {

    override fun onValue(textFieldValue: TextFieldValue) {

        val selection = textFieldValue.selection
        val text = textFieldValue.text

        val trimmedText = text.takeIf {
            text.length <= maskList.getClearSize()
        } ?: text.removeRange(selection.start, selection.end + 1)

        onValueChanged(textFieldValue.copy(text = trimmedText))
    }

    override fun createVisualTransformation(): VisualTransformation {
        return MaskVisualTransformation(maskList)
    }
}