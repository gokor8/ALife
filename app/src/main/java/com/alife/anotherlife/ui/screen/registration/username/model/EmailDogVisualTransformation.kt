package com.alife.anotherlife.ui.screen.registration.username.model

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import javax.inject.Inject

class EmailDogVisualTransformation @Inject constructor() : VisualTransformation{

    override fun filter(text: AnnotatedString): TransformedText {
        val formattedText = if(text.isNotEmpty()) "@${text.text}" else text.text

        return TransformedText(text = AnnotatedString(formattedText), EmailOffsetMapping())
    }
}