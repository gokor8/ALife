package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel

interface UIBasePostContainer {

    fun itemKey(): String

    @Composable
    fun Post(viewModel: AbstractHomeChildViewModel, modifier: Modifier)


    abstract class Abstract: UIBasePostContainer {

        protected abstract val username: String
        protected abstract val timestamp: String
        protected abstract val avatar: String?

        override fun itemKey(): String = username + timestamp

        @Composable
        override fun Post(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
            return if (viewModel.getUIState().isHavePostToday) {
                clear(viewModel = viewModel, modifier = modifier)
            } else {
                blur(viewModel = viewModel, modifier = modifier)
            }.Card(viewModel = viewModel, modifier = modifier)
        }

        @Composable
        protected abstract fun clear(
            viewModel: AbstractHomeChildViewModel,
            modifier: Modifier
        ): UIPostModel

        @Composable
        protected abstract fun blur(
            viewModel: AbstractHomeChildViewModel,
            modifier: Modifier
        ): UIPostModel
    }
}