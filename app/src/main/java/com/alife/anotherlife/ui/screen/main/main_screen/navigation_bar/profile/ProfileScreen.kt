package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.screen.DefaultScreen

class ProfileScreen : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier) {
        Box(modifier = modifier) {
            Text(text = "Profile")
        }
    }
}