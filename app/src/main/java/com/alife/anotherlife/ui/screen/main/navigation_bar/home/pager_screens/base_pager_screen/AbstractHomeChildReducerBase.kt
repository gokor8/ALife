package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.cachedIn
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.map
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseLoadStatesToStateEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeStateEffect
import com.alife.core.mapper.Mapper
import com.alife.domain.main.BasePostsUseCase
import com.alife.domain.main.home.child.BaseProfileCardUseCase
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.base_entity.PostEntity
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

abstract class AbstractHomeChildReducerBase(
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    protected val mapper: Mapper<ProfileCardEntity, UIPostModel>,
    private val postsPaging: PagingSource<Int, UIPostModel>,
    private val loadStateMapper: BaseLoadStatesToStateEffect
) : HandlerBaseVMReducer<HomeChildState, HomeChildEffect>(), BaseHomeChildReducer {

    private val pageSize = 10

    override suspend fun onInit(viewModelScoped: CoroutineScope) {
        if(getState().postsPagingData != null) return

        val pagingFlow = Pager(
            config = PagingConfig(pageSize = pageSize),
            pagingSourceFactory = { postsPaging }
        ).flow.cachedIn(viewModelScoped)

        setState { copy(postsPagingData = pagingFlow) }
    }

    override suspend fun onPagingLoadState(loadStates: CombinedLoadStates) {
        loadStateMapper.map(this, loadStates)
    }

    override suspend fun onTakeALife() {
        setEffect(HomeChildEffect.NavigateToTakeALife())
    }
}