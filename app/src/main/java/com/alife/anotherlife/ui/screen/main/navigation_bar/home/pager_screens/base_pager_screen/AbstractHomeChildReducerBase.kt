package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.BaseProfileCardUseCase
import com.alife.domain.main.home.child.ProfileCardEntity

abstract class AbstractHomeChildReducerBase(
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    protected val mapper: Mapper<ProfileCardEntity, UICardModel>,
    protected val profileCardUseCase: BaseProfileCardUseCase,
) : HandlerBaseVMReducer<HomeChildState, HomeChildEffect>(), BaseHomeChildReducer {

    override suspend fun onTakeALife() {
        setEffect(HomeChildEffect.NavigateToTakeALife())
    }
}