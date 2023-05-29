package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.main.home.child.world.WorldAnnotation
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreateAlifePostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.child_world.BaseWorldProfileCardUC
import javax.inject.Inject

class WorldReducer @Inject constructor(
    @WorldAnnotation.WorldUIStore
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    mapper: Mapper<ProfileCardEntity, UIPostModel>,
    @WorldAnnotation.WorldProfileUseCase
    worldCardUseCase: BaseWorldProfileCardUC,
) : AbstractHomeChildReducerBase(uiStore, mapper, worldCardUseCase) {

    override suspend fun onInit() {

        //setLoadState

        //if(getState().profileList.isNotEmpty()) return

        execute {

        }.handle {
            val profileCards = profileCardUseCase.getProfileCards().profileCards

            val uiPostModels = if(profileCards.isNotEmpty()) {
                profileCards.map { mapper.map(it) }
            } else {
                listOf<UIPostModel>(UIPlzCreateAlifePostModel())
            }

            setState { copy(profileList = uiPostModels) }
        }
    }
}