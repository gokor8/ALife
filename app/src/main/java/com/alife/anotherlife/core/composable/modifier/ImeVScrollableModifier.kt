package com.alife.anotherlife.core.composable.modifier

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class ImeVScrollableModifier : ModifierProvider {

    @Composable
    override fun provideModifier(): Modifier {
        return ImeModifier()
            .provideModifier()
            .then(
                ScrollableModifier().provideModifier()
            )
    }
}