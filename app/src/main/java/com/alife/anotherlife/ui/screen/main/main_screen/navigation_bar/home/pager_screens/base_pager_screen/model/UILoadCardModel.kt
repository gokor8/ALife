package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.BaseHomeChildViewModel

class UILoadCardModel : UICardModel {

    private val staticItemKey = "load"

    override fun itemKey() = staticItemKey

    @Composable
    override fun Card(viewModel: BaseHomeChildViewModel, modifier: Modifier) {
        Box(modifier = modifier.fillMaxWidth()) {
            CircularProgressIndicator()
        }
    }
}