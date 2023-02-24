package com.alife.anotherlife.ui.screen.registration.username.model

import androidx.compose.ui.text.input.OffsetMapping

class EmailOffsetMapping : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int = offset + 1

    override fun transformedToOriginal(offset: Int): Int = offset - 1
}