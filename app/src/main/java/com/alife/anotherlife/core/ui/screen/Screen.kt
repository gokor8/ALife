package com.alife.anotherlife.core.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface Screen {

    @Composable
    fun SetupContent()

    @Composable
    fun Content(modifier: Modifier)
}