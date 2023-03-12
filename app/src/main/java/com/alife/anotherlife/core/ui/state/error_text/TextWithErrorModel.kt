package com.alife.anotherlife.core.ui.state.error_text

import androidx.annotation.StringRes
import androidx.compose.ui.text.input.TextFieldValue

data class TextWithErrorModel(
    val textFieldValue: TextFieldValue = TextFieldValue(""),
    @StringRes val errorResId: Int? = null
) {

    fun getCurrentText() = textFieldValue.text

    fun copyEmptyError(): TextWithErrorModel {
        return errorResId?.let { TextWithErrorModel(textFieldValue) } ?: this
    }

    fun copyEmptyError(textFieldValue: TextFieldValue): TextWithErrorModel {
        return TextWithErrorModel(textFieldValue, null)
    }

    fun copyText(newText: String): TextWithErrorModel {
        return copy(textFieldValue = textFieldValue.copy(newText))
    }
}