package com.alife.anotherlife.core.ui.state.error_text

import androidx.annotation.StringRes
import androidx.compose.ui.text.input.TextFieldValue

data class TextErrorModel(
    val textFieldValue: TextFieldValue = TextFieldValue(""),
    @StringRes val errorResId: Int? = null
) {

    fun getCurrentText() = textFieldValue.text

    fun copyEmptyError(): TextErrorModel {
        return errorResId?.let { TextErrorModel(textFieldValue) } ?: this
    }

    fun copyEmptyError(textFieldValue: TextFieldValue): TextErrorModel {
        return TextErrorModel(textFieldValue, null)
    }

    fun copyText(newText: String): TextErrorModel {
        return copy(textFieldValue = textFieldValue.copy(newText))
    }
}