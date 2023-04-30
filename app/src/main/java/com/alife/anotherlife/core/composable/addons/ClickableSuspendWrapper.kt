package com.alife.anotherlife.core.composable.addons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.clickable
import com.alife.anotherlife.core.composable.clickableNoRipple
import kotlinx.coroutines.launch

interface ClickableSuspendWrapper {

    @Composable
    fun Clickable(modifier: Modifier, onClick: suspend () -> Unit): Modifier


    class Ripple : ClickableSuspendWrapper {

        @Composable
        override fun Clickable(modifier: Modifier, onClick: suspend () -> Unit): Modifier {
            return modifier.clickable(rememberCoroutineScope(), onClick = onClick)
        }
    }

    class NoRipple : ClickableSuspendWrapper {

        @Composable
        override fun Clickable(modifier: Modifier, onClick: suspend () -> Unit): Modifier {
            return modifier.clickableNoRipple(rememberCoroutineScope(), onClick = onClick)
        }
    }
}