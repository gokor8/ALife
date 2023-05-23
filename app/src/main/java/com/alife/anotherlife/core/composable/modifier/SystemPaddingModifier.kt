package com.alife.anotherlife.core.composable.modifier

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object ImeSystemPaddingModifier : ModifierProvider {

    @Composable
    override fun provideModifier(): Modifier {
        return Modifier
            .fillMaxSize()
            .imePadding()
            .statusBarsPadding()
            .navigationBarsPadding()
    }
}

object SystemPaddingModifier : ModifierProvider {

    @Composable
    override fun provideModifier(): Modifier {
        return Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    }
}