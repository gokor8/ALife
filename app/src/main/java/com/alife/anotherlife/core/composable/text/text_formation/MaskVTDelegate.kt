package com.alife.anotherlife.core.composable.text.text_formation

import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.MaskPattern

class MaskVTDelegate(
    private val maskList: MaskList,
    private val onValueChanged: (TextFieldValue) -> Unit
) : VisualTransformationDelegate {

    constructor(
        maskPattern: MaskPattern,
        onValueChanged: (TextFieldValue) -> Unit
    ) : this(maskPattern.getMaskPattern(), onValueChanged)

    override fun onValue(textFieldValue: TextFieldValue) {
        val selection = textFieldValue.selection
        val text = textFieldValue.text

        val symbolCount = maskList.getClearCount()

        val trimmedText =
            text.takeIf { it.length <= symbolCount } ?: if (selection.end + 1 <= symbolCount) {
                text.removeRange(selection.start, selection.end + 1)
            } else {
                text.substring(0, symbolCount)
            }

        onValueChanged(textFieldValue.copy(text = trimmedText))
    }

    override fun getMaskedText(regexPattern: String): String {
        return getMaskedText(regexPattern.toRegex())
    }

    override fun getMaskedText(regexPattern: Regex): String {
        return maskList.toString().replace(regexPattern, "")
    }

    override fun createVisualTransformation(): VisualTransformation {
        return MaskVisualTransformation(maskList)
    }
}