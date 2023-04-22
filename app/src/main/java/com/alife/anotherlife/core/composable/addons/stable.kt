package com.alife.anotherlife.core.composable.addons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.remember

@Composable
inline fun <T> stable(crossinline calculation: @DisallowComposableCalls () -> T): () -> T {
    return remember { { calculation() } }
}

@Composable
inline fun <M, T> stable(crossinline calculation: @DisallowComposableCalls (M) -> T): (M) -> T {
    return remember { { calculation(it) } }
}