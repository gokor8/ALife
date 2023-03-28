package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreateAlifeCardModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.ProfileCardUseCase

abstract class BaseHomeChildReducer(
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    protected val mapper: Mapper<ProfileCardEntity, UICardModel>,
    protected val profileCardUseCase: ProfileCardUseCase,
) : BaseVMReducer<HomeChildState, HomeChildEffect>() {

    suspend fun onTakeALife() {
        setEffect(HomeChildEffect.NavigateToTakeALife())
    }
}