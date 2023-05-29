package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.text.style.Title20Style
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel

data class UIVideoPostModel(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null,
    val video: String
) : UIPostModel.Abstract() {

    @Composable
    override fun Card(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
        Text("Video", style = Title20Style().style())
    }
}