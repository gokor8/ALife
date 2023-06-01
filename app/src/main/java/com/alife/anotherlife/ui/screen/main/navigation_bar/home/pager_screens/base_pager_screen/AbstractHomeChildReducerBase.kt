package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.paging.CombinedLoadStates
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.model.TabsVisibilityContract
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseLoadStatesToStateEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging.BasePagingSourceFactory
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging.PostsPagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.ProfileCardEntity
import kotlinx.coroutines.CoroutineScope

abstract class AbstractHomeChildReducerBase(
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    protected val mapper: Mapper<ProfileCardEntity, UIPostModel>,
    private val loadStateMapper: BaseLoadStatesToStateEffect,
    private val pagingFactory: BasePagingSourceFactory<PostsPagingSource>,
    private val tabsVisibilityContract: TabsVisibilityContract,
) : HandlerBaseVMReducer<HomeChildState, HomeChildEffect>(), BaseHomeChildReducer {

    private val pageSize = 10

    override suspend fun onInit(viewModelScoped: CoroutineScope) {
        if(getState().postsPagingData != null) return

        val pagingFlow = Pager(
            config = PagingConfig(pageSize = pageSize),
            pagingSourceFactory = { pagingFactory.create() }
        ).flow.cachedIn(viewModelScoped)

        setState { copy(postsPagingData = pagingFlow) }
    }

    override suspend fun onPagingLoadState(loadStates: CombinedLoadStates) {
        loadStateMapper.map(this, loadStates)
    }

    override suspend fun onTakeALife() {
        setEffect(HomeChildEffect.NavigateToTakeALife())
    }

    override suspend fun onScrollPosition(isScrolledUp: Boolean) {
        tabsVisibilityContract.onTabVisibility(isScrolledUp)
    }
}