package com.alife.anotherlife.core.composable.addons

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BaseProgressBar(modifier: Modifier = Modifier.size(50.dp)) {
    CircularProgressIndicator(strokeWidth = 2.dp, modifier = modifier)
}