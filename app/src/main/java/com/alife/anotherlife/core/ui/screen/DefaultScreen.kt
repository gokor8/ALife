package com.alife.anotherlife.core.ui.screen

import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.composable.modifier.ModifierProvider

abstract class DefaultScreen(private val modifier: ModifierProvider) : Screen {

    @Composable
    override fun SetupContent() {
        Content(modifier = modifier.provideModifier())
    }
}