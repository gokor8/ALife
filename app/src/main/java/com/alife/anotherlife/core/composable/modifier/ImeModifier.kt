package com.alife.anotherlife.core.composable.modifier

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ImeModifier(
    private val modifierProvider: ModifierProvider? = null
) : ModifierProvider {

    @Composable
    override fun provideModifier(): Modifier {
        val expandModifier = Modifier
            .fillMaxSize()
            .imePadding()
            .statusBarsPadding()
            .navigationBarsPadding()

        return modifierProvider?.provideModifier()?.then(expandModifier) ?: expandModifier
    }
}