package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.ui.screen.DefaultScreen

class BaseHomePagerScreen : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier) {
        LazyColumn(
            modifier = modifier
        ) {
            items()
        }
    }
}