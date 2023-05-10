package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction

abstract class BaseHomeChildScreen(
    override val navController: NavController,
    private val pagingVisibility: (Boolean) -> Unit
) : VMScreen<AbstractHomeChildViewModel>(SystemPaddingModifier) {

    override suspend fun onInit() {
        viewModel.reduce(HomeChildAction.OnInit())
    }

    @Composable
    override fun Content(modifier: Modifier) {
        val state = viewModel.getUIState()

        val lazyColumnState = rememberLazyListState()

        LazyColumn(
            state = lazyColumnState,
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            modifier = modifier,
        ) {
            item { Spacer(modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()) }
            items(
                state.profileList,
                key = { it.itemKey() }
            ) {
                it.Card(viewModel = viewModel, modifier = Modifier)
            }
            item { Spacer(modifier = Modifier
                .height(30.dp)
                .fillMaxWidth()) }
        }
    }
}