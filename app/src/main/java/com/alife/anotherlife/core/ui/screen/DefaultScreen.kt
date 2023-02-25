package com.alife.anotherlife.core.ui.screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.modifier.ModifierProvider
import com.alife.anotherlife.core.composable.modifier.ScrollableModifier

abstract class DefaultScreen(private val modifier: ModifierProvider = ScrollableModifier()) :
    Screen {

    @Composable
    override fun SetupContent() {
        Content(modifier = modifier.provideModifier())
    }

    @Composable
    protected abstract fun Content(modifier: Modifier)
}