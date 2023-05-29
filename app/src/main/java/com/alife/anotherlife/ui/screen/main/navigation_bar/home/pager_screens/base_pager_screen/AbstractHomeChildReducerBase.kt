package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.BaseProfileCardUseCase
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.base_entity.PostEntity

abstract class AbstractHomeChildReducerBase(
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    protected val mapper: Mapper<ProfileCardEntity, UIPostModel>,
    protected val profileCardUseCase: BaseProfileCardUseCase,
    private val postsPaging: PagingSource<Int, PostEntity>
) : HandlerBaseVMReducer<HomeChildState, HomeChildEffect>(), BaseHomeChildReducer {

    override suspend fun onInit() {
        Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { postsPaging }
        ).flow
    }

    override suspend fun onTakeALife() {
        setEffect(HomeChildEffect.NavigateToTakeALife())
    }
}