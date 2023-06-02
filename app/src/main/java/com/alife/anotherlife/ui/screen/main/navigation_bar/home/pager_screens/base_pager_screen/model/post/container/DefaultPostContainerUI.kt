package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel

class DefaultPostContainerUI(
    private val uiPostModel: UIPostModel
) : UIBasePostContainer {

    override fun itemKey() = uiPostModel.itemKey()

    @Composable
    override fun Post(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
        uiPostModel.Card(viewModel = viewModel, modifier = modifier)
    }
}