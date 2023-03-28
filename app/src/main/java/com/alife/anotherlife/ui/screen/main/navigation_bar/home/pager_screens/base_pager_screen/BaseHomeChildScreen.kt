package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.modifier.ImeModifier
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction

abstract class BaseHomeChildScreen(
    override val navController: NavController
) : VMScreen<BaseHomeChildViewModel>(ImeModifier()) {

    override suspend fun onInit() {
        viewModel.reduce(HomeChildAction.OnInit())
    }

    @Composable
    override fun Content(modifier: Modifier) {

        val state = viewModel.getUIState()

        val lazyColumnState = rememberLazyListState()

        LazyColumn(
            state = lazyColumnState,
            modifier = modifier
        ) {
            items(
                state.profileList,
                key = { it.itemKey() }
            ) {
                it.Card(viewModel = viewModel, modifier = Modifier)
            }
        }
    }
}