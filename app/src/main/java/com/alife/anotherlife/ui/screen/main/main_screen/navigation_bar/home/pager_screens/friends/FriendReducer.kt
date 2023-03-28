package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.friends

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.BaseHomeChildReducer
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreateAlifeCardModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.ProfileCardUseCase

class FriendReducer(
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    mapper: Mapper<ProfileCardEntity, UICardModel>,
    profileCardUseCase: ProfileCardUseCase,
) : BaseHomeChildReducer(uiStore, mapper, profileCardUseCase) {

    suspend fun onInit() {

        val profileCardsEntity = profileCardUseCase.getProfileCards()

        val uiCardModels = if (profileCardsEntity.isEmpty())
            profileCardsEntity.map { mapper.map(it) }
        else
            listOf<UICardModel>(UIPlzCreateAlifeCardModel())

        setState { copy(profileList = uiCardModels) }
    }
}