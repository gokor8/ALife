package com.alife.anotherlife.core.ui.state.error_text

import androidx.annotation.StringRes

data class TextWithErrorModel(
    val text: String = "",
    @StringRes val errorResId: Int? = null
) {

    fun copyEmptyError(): TextWithErrorModel {
        return errorResId?.let { TextWithErrorModel(text) } ?: this
    }

    fun copyEmptyError(text: String): TextWithErrorModel {
        return TextWithErrorModel(text, null)
    }
}