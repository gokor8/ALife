package com.alife.anotherlife.core.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.modifier.ModifierProvider
import com.alife.anotherlife.core.composable.modifier.ScrollableModifier

abstract class DefaultScreen(private val modifier: ModifierProvider = ScrollableModifier()) :
    Screen {

    protected open val backHandle: (() -> Unit)? = null

    @Composable
    override fun SetupContent() {
        BackHandler(backHandle != null) { backHandle?.invoke() }
        Content(modifier = modifier.provideModifier())
    }

    @Composable
    protected abstract fun Content(modifier: Modifier)
}