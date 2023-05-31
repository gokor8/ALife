package com.alife.anotherlife.core.composable.modifier

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object BaseFillMaxModifier : ModifierProvider {

    @Composable
    override fun provideModifier() = Modifier.fillMaxSize()
}