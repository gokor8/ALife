package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import android.util.Log
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
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import androidx.paging.compose.items
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.composable.snackbar.OnlyTextSnackBar
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
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

    @Composable
    override fun Content(modifier: Modifier) {
        Log.d("modifier", "$modifier")
        val state = viewModel.getUIState()
        Log.d("state", "${state.hashCode()} $state")
        val lazyPosts = state.postsPagingData?.collectAsLazyPagingItems()

        lazyPosts?.apply {
            Log.d("loadState SafeContent", "${loadState}")
            key(loadState) {
                Log.d("loadState SafeContent in", "${loadState}")
                viewModel.reduce(HomeChildAction.OnPagingLoadState(loadState))
            }
        }

        val lceModel = state.lceModel

        if (lceModel is LCEContent)
            SafeContent(lazyPosts, Modifier)
        else
            state.lceModel.LCEContent(Modifier)

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SafeContent(lazyPosts: LazyPagingItems<UIPostModel>?, modifier: Modifier) {
        Log.d("lazyPosts SafeContent", "$lazyPosts")
        val state = viewModel.getUIState()
        Log.d("state SafeContent", "$state")

        val coroutineScope = rememberCoroutineScope()

        val snackbarHostState = remember { SnackbarHostState() }

        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
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

        LaunchedEffect(Unit) {
            viewModel.collectEffect(navController) {
                snackbarHostState.showSnackbar("Произошла ошибка получения элементов")
            }
        }

    }

    override suspend fun setupEventCollector() = Unit
}