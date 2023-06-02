package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.paging.CombinedLoadStates
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.model.TabsVisibilityContract
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseLoadStatesToStateEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging.BasePagingSourceFactory
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging.PagingLoadCallback
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging.PostsPagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.BaseMyPostUseCase
import com.alife.domain.main.MyPostUseCase
import com.alife.domain.main.home.child.ProfileCardEntity
import kotlinx.coroutines.CoroutineScope

abstract class AbstractHomeChildReducerBase(
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    protected val mapper: Mapper<ProfileCardEntity, UIPostModel>,
    private val loadStateMapper: BaseLoadStatesToStateEffect,
    private val pagingFactory: BasePagingSourceFactory<PostsPagingSource>,
    private val tabsVisibilityContract: TabsVisibilityContract,
    private val myPostUseCase: BaseMyPostUseCase
) : HandlerBaseVMReducer<HomeChildState, HomeChildEffect>(), BaseHomeChildReducer,
    PagingLoadCallback {

    private val pageSize = 10

    override suspend fun onInit(viewModelScoped: CoroutineScope) {
        if(getState().postsPagingData != null) return

        val pagingFlow = Pager(
            config = PagingConfig(pageSize = pageSize),
            pagingSourceFactory = { pagingFactory.create(this) }
        ).flow.cachedIn(viewModelScoped)

        setState { copy(postsPagingData = pagingFlow) }
    }

    override suspend fun onPagingLoadState(loadStates: CombinedLoadStates) {
        loadStateMapper.map(this, loadStates)
        onLoad(myPostUseCase.isHavePostToday())
    }

    override suspend fun onTakeALife() {
        setEffect(HomeChildEffect.NavigateToTakeALife())
    }

    override suspend fun onPostProfile(username: String) {
        setEffect(HomeChildEffect.NavigateToPostProfile(username))
    }

    override suspend fun onScrollPosition(isScrolledUp: Boolean) {
        tabsVisibilityContract.onTabVisibility(isScrolledUp)
    }

    override suspend fun onLoad(isHavePostToday: Boolean) {
        setState { copy(isHavePostToday = isHavePostToday) }
    }
}