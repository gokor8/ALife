package com.alife.anotherlife.ui.screen.login

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.view_group.CustomColumn
import com.alife.anotherlife.core.ui.screen.Screen

class LoginScreen : Screen {

    @Composable
    override fun Content() = CustomColumn() {
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center
        ) {
            Text
        }
    }
}