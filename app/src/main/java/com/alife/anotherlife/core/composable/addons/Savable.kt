package com.alife.anotherlife.core.composable.addons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun<R> savable(action: () -> R) = remember { action }