package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.alife.anotherlife.core.composable.modifier.OnlyTopPadding
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.LceErrorNoPostsHaveMyPost
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.LceErrorNoPostsHaveMyPostProvider
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.LceErrorPagingLoad
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.LceErrorPagingLoadProvider
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction

abstract class BaseHomeChildScreen(
    override val navController: NavController,
    private val isVisible: Boolean
) : VMScreen<AbstractHomeChildViewModel>(OnlyTopPadding) {

    override suspend fun onInit() {
        viewModel.reduce(HomeChildAction.OnInit())
    }

    @Composable
    override fun Content(modifier: Modifier) {
        val state = viewModel.getUIState()
        val lazyPosts = state.postsPagingData?.collectAsLazyPagingItems()

        lazyPosts?.apply {
            key(loadState) {
                viewModel.reduce(HomeChildAction.OnPagingLoadState(loadState))
            }
        }

        val localModifier = modifier.fillMaxSize()

        // TODO вынести в маппер
        when (val lceModel = state.lceModel) {
            is LCEContent -> SafeContent(lazyPosts, localModifier)
            is LceErrorNoPostsHaveMyPostProvider -> {
                LceErrorNoPostsHaveMyPost().LCEContent(localModifier, lazyPosts)
            }
            is LceErrorPagingLoadProvider -> {
                LceErrorPagingLoad().LCEContent(localModifier, lazyPosts)
            }
            else -> lceModel.LCEContent(modifier = localModifier)
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun SafeContent(lazyPosts: LazyPagingItems<UIBasePostContainer>?, modifier: Modifier) {
        val state = viewModel.getUIState()

        val snackBarHostState = remember { SnackbarHostState() }

        val refreshState = rememberPullRefreshState(
            refreshing = state.isRefreshing,
            onRefresh = { lazyPosts?.refresh() }
        )

        Scaffold(
            modifier = modifier.pullRefresh(refreshState),
            contentWindowInsets = WindowInsets(bottom = 0.dp),
            snackbarHost = { SnackbarHost(snackBarHostState) }
        ) { innerPadding ->
            innerPadding

            val lazyListState = rememberLazyListState()
            var previousScrollPosition by remember(this::class.simpleName) { mutableStateOf(0) }

            val upOrDownScroll by remember(this::class.simpleName) {
                derivedStateOf {
                    val newPosition = lazyListState.firstVisibleItemIndex

                    val condition = previousScrollPosition >= newPosition

                    if (previousScrollPosition != newPosition)
                        previousScrollPosition = lazyListState.firstVisibleItemIndex

                    condition
                }
            }

            if (isVisible) {
                key(upOrDownScroll) {
                    viewModel.reduce(HomeChildAction.OnScroll(upOrDownScroll))
                }
            }

            Box(modifier = Modifier.fillMaxSize()) {
                PullRefreshIndicator(
                    state.isRefreshing,
                    refreshState,
                    Modifier.align(Alignment.TopCenter)
                )

                lazyPosts?.also {
                    LazyColumn(
                        state = lazyListState,
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(30.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding(),
                    ) {
                        item {
                            Spacer(modifier = Modifier.height(60.dp).fillMaxWidth())
                        }

                        items(
                            count = lazyPosts.itemCount,
                            key = lazyPosts.itemKey(key = { it.itemKey() }),
                            contentType = lazyPosts.itemContentType()
                        ) { index ->
                            lazyPosts[index]?.Post(viewModel = viewModel, modifier = Modifier)
                        }

                        item {
                            state.uiLoaderModel.Loader(modifier = Modifier)
                        }
                    }
                }
            }
        }

        var snackBarErrorEffect by remember {
            mutableStateOf<SnackBarWrapper?>(null)
        }.also { wrapper ->
            wrapper.value?.SnackBar(snackBarHostState)
        }

        LaunchedEffect(Unit) {
            viewModel.collectEffect(navController) { wrapper ->
                snackBarErrorEffect = wrapper
            }
        }

    }

    override suspend fun setupEventCollector() = Unit
}