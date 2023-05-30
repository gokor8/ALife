package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import androidx.paging.compose.items
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.composable.snackbar.OnlyTextSnackBar
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction
import kotlinx.coroutines.launch

abstract class BaseHomeChildScreen(
    override val navController: NavController,
    private val pagingVisibility: (Boolean) -> Unit
) : VMScreen<AbstractHomeChildViewModel>() {

    override suspend fun onInit() {
        viewModel.reduce(HomeChildAction.OnInit())
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(modifier: Modifier) {
        val state = viewModel.getUIState()

        val lazyColumnState = rememberLazyListState()

        val lazyPosts = state.postsPagingData?.collectAsLazyPagingItems()

        val coroutineScope = rememberCoroutineScope()

        val snackbarHostState = remember { SnackbarHostState() }

        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Box(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()) {
                lazyPosts?.also {

                    if (lazyPosts.loadState.refresh is LoadState.Error
                        || lazyPosts.loadState.append is LoadState.Error
                    ) {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                "Произошла ошибка поулчения элментов"
                            )
                        }
                    }

                    LazyColumn(
                        state = lazyColumnState,
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(30.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding(),
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

                        if (
                            lazyPosts.loadState.refresh is LoadState.Loading
                            || lazyPosts.loadState.append is LoadState.Loading
                        ) {
                            this@LazyColumn.item {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(60.dp),
                                        strokeWidth = 2.dp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}