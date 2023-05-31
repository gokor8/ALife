package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.BaseHomeChildReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.LCEErrorLoadingPagingData
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostLoaderModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import javax.inject.Inject

interface BaseLoadStatesToStateEffect {

    fun map(reducer: BaseHomeChildReducer, inputModel: CombinedLoadStates)
}

class LoadStatesToStateEffect @Inject constructor() : BaseLoadStatesToStateEffect {

    override fun map(reducer: BaseHomeChildReducer, inputModel: CombinedLoadStates) {
        with(reducer.getState()) {
            val refresh = inputModel.refresh
            val append = inputModel.append

            reducer.setState {
                when (refresh) {
                    // TODO Fix with LCELoading
                    is LoadState.Loading -> copy(lceModel = LCELoading)
                    is LoadState.Error -> copy(lceModel = LCEErrorLoadingPagingData(reducer))
                    is LoadState.NotLoading -> copy(lceModel = LCEContent)
                }
            }

            when (append) {
                is LoadState.Loading -> reducer.setState {
                    copy(uiLoaderModel = UIPostLoaderModel.LoaderModel)
                }
                is LoadState.Error -> reducer.trySetEffect(HomeChildEffect.SnackBarPagingError())
                is LoadState.NotLoading -> reducer.setState {
                    copy(uiLoaderModel = UIPostLoaderModel.EmptyModel)
                }
            }
        }
    }
}