package com.alife.anotherlife.ui.screen.registration.username.model

import androidx.compose.ui.text.input.OffsetMapping

class EmailOffsetMapping : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int = offset

    override fun transformedToOriginal(offset: Int): Int = if(offset <= 0) offset + 1 else offset
}