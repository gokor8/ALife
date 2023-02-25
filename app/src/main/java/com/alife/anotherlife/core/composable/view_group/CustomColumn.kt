package com.alife.anotherlife.core.composable.view_group

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.alife.anotherlife.core.composable.clickableNoRipple

@Composable
fun CustomColumn(
    modifier: Modifier = Modifier.fillMaxSize(),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier.clickableNoRipple { focusManager.clearFocus() },
        verticalArrangement,
        horizontalAlignment,
        content
    )
}