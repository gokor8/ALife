package com.alife.anotherlife.core.composable.modifier

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface ModifierProvider {

    @Composable
    fun provideModifier(): Modifier
}