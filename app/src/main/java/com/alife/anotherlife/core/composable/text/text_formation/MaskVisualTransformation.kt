package com.alife.anotherlife.core.composable.text.text_formation

import android.util.Log
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import com.alife.anotherlife.core.composable.text.text_formation.base.MaskTextFormatter
import com.alife.anotherlife.core.composable.text.text_formation.mask.MaskList

class MaskVisualTransformation(private val maskList: MaskList) : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {

        val formattedText = MaskTextFormatter().format(text.text, maskList)

        Log.e("Aboba", "New Text - $text | FormattedText - $formattedText")

        return TransformedText(
            text = AnnotatedString(
                formattedText,
                text.spanStyles,
                text.paragraphStyles
            ),
            offsetMapping = MaskOffsetMapping(maskList)
        )
    }
}