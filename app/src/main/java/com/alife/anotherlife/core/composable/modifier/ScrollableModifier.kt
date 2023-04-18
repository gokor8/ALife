package com.alife.anotherlife.core.composable.modifier

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class ScrollableModifier : ModifierProvider {

    @Composable
    override fun provideModifier(): Modifier {
        return ImeModifier()
            .provideModifier()
            .verticalScroll(rememberScrollState())
    }
}