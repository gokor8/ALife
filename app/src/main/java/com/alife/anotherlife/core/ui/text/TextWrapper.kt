package com.alife.anotherlife.core.ui.text

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

fun textWrap(text: String) = TextWrapper.StringWrapper(text)

interface TextWrapper {

    @Composable
    fun getString(): String

    class ResWrapper(@StringRes private val id: Int) : TextWrapper {
        @Composable
        override fun getString() = stringResource(id)
    }

    class StringWrapper(private val text: String = "") : TextWrapper {
        @Composable
        override fun getString() = text
    }
}