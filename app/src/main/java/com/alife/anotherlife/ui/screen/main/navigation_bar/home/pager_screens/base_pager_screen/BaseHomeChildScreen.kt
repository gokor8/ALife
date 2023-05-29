package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import androidx.paging.compose.items
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction

abstract class BaseHomeChildScreen(
    override val navController: NavController,
    private val pagingVisibility: (Boolean) -> Unit
) : VMScreen<AbstractHomeChildViewModel>() {

    override suspend fun onInit() {
        viewModel.reduce(HomeChildAction.OnInit())
    }

    @Composable
    override fun Content(modifier: Modifier) {
        val state = viewModel.getUIState()

        val lazyColumnState = rememberLazyListState()

        val lazyPosts = state.postsPagingData?.collectAsLazyPagingItems()

        lazyPosts?.also {
            LazyColumn(
                state = lazyColumnState,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.fillMaxSize().statusBarsPadding(),
            ) {
                item {
                    Spacer(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                    )
                }

                items(
                    count = lazyPosts.itemCount,
                    key = lazyPosts.itemKey(key = { it.itemKey() }),
                    contentType = lazyPosts.itemContentType()
                ) { index ->
                    val item = lazyPosts[index]
                    item?.Card(viewModel = viewModel, modifier = Modifier)
                }
            }
        }
    }
}