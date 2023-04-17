package com.alife.anotherlife.core.composable.modifier

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class ScrollableModifier(
    private val expandableModifier: Modifier? = null
) : ModifierProvider {

    @Composable
    override fun provideModifier(): Modifier {
        val expandModifier = ImeModifier()
            .provideModifier()
            .verticalScroll(rememberScrollState())

        return expandableModifier?.then(expandModifier) ?: expandModifier
    }
}