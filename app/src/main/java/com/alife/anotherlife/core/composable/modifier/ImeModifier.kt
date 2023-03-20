package com.alife.anotherlife.core.composable.modifier

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ImeModifier : ModifierProvider {

    @Composable
    override fun provideModifier(): Modifier {
        return Modifier
            .fillMaxSize()
            .imePadding()
            .statusBarsPadding()
            .navigationBarsPadding()
    }
}