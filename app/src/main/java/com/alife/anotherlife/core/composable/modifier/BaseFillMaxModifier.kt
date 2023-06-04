package com.alife.anotherlife.core.composable.modifier

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object BaseFillMaxModifier : ModifierProvider {

    @Composable
    override fun provideModifier() = Modifier.fillMaxSize()
}

object BaseScrollFillMaxModifier : ModifierProvider {

    @Composable
    override fun provideModifier() = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
}