package com.alife.anotherlife.core.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.modifier.ModifierProvider
import com.alife.anotherlife.core.composable.modifier.ScrollableModifier

abstract class DefaultScreen(
    private val modifier: ModifierProvider = ScrollableModifier()
) : Screen {

    protected open val backHandle: (() -> Unit)? = null

    @Composable
    override fun SetupContent() {
        BackHandler(backHandle != null) { backHandle?.invoke() }

        val focusManager = LocalFocusManager.current
        Content(modifier = modifier
            .provideModifier()
            .padding(vertical = 6.dp)
            .clickableNoRipple {
                focusManager.clearFocus()
            }
        )
    }

    @Composable
    protected abstract fun Content(modifier: Modifier)
}