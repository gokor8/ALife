package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.main.home.child.friends.FriendsAnnotation
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreateAlifeCardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.child_friends.BaseFriendsProfileCardUC
import javax.inject.Inject

class FriendsReducer @Inject constructor(
    @FriendsAnnotation.FriendsUIStore
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    mapper: Mapper<ProfileCardEntity, UICardModel>,
    friendsCardUseCase: BaseFriendsProfileCardUC,
) : AbstractHomeChildReducerBase(uiStore, mapper, friendsCardUseCase) {

    override suspend fun onInit() {

        //setLoadState

        //if(getState().profileList.isNotEmpty()) return

        execute {

        }.handle {
            val profileCards = profileCardUseCase.getProfileCards().profileCards

            val uiCardModels = if(profileCards.isNotEmpty()) {
                profileCards.map { mapper.map(it) }
            } else {
                listOf<UICardModel>(UIPlzCreateAlifeCardModel())
            }

            setState { copy(profileList = uiCardModels) }
        }
    }
}