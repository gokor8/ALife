package com.alife.anotherlife.ui.screen.main.navigation_bar.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.screen.DefaultScreen

class MapScreen(private val innerPadding: PaddingValues) : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier) {
        Box(modifier = modifier.padding(innerPadding)) {
            Text(text = "Map")
        }
    }
}