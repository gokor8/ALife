package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideLazyListPreloader

class BaseHomeChildScreen(
    override val navController: NavController
) : VMScreen<BaseHomeChildViewModel>() {

    @Composable
    override fun setupViewModel(): BaseHomeChildViewModel = hiltViewModel()

    @OptIn(ExperimentalGlideComposeApi::class)
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