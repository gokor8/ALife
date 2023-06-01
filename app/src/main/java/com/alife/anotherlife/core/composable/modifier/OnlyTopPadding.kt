package com.alife.anotherlife.core.composable.modifier

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object OnlyTopPadding : ModifierProvider {

    @Composable
    override fun provideModifier() = Modifier.statusBarsPadding()
}