package com.alife.anotherlife.core.composable.modifier

import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class OnlyImeModifier : ModifierProvider {

    @Composable
    override fun provideModifier(): Modifier {
        return Modifier
            .imePadding()
            .statusBarsPadding()
            .navigationBarsPadding()
    }
}