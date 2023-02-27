package com.alife.anotherlife.core.composable.text.text_formation

import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation

interface VisualTransformationDelegate {

    fun createVisualTransformation(): VisualTransformation

    fun onValue(textFieldValue: TextFieldValue)

    fun getMaskedText(regexPattern: String = ""): String

    fun getMaskedText(regexPattern: Regex): String
}