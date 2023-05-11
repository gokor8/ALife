package com.alife.anotherlife.core.composable.modifier

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class ScrollableModifier : ModifierProvider {

    @Composable
    override fun provideModifier(): Modifier {
        return SystemPaddingModifier
            .provideModifier()
            .verticalScroll(rememberScrollState())
    }
}