package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.alife.anotherlife.core.composable.modifier.BaseFillMaxModifier
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.LceErrorPagingLoad
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.LceErrorPagingLoadProvider
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
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
        val lazyPosts = state.postsPagingData?.collectAsLazyPagingItems()

        lazyPosts?.apply {
            Log.d("loadState SafeContent", "${loadState}")
            key(loadState) {
                Log.d("loadState SafeContent in", "${loadState}")
                viewModel.reduce(HomeChildAction.OnPagingLoadState(loadState))
            }
        }

        // TODO вынести в маппер
        when(val lceModel = state.lceModel) {
            is LCEContent -> SafeContent(lazyPosts, modifier)
            is LceErrorPagingLoadProvider -> LceErrorPagingLoad().LCEContent(modifier) {
                lazyPosts?.retry()
            }

            else -> lceModel.LCEContent(modifier = modifier)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SafeContent(lazyPosts: LazyPagingItems<UIPostModel>?, modifier: Modifier) {
        val state = viewModel.getUIState()

        val snackbarHostState = remember { SnackbarHostState() }

        Scaffold(
            modifier = modifier,
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            innerPadding
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                lazyPosts?.also {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(30.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding(),
                    ) {
                        item {
                            Spacer(
                                modifier = Modifier
                                    .height(40.dp)
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
            wrapper.value?.SnackBar(snackbarHostState)
        }

        LaunchedEffect(Unit) {
            viewModel.collectEffect(navController) { wrapper ->
                snackBarErrorEffect = wrapper
            }
        }

    }

    override suspend fun setupEventCollector() = Unit
}