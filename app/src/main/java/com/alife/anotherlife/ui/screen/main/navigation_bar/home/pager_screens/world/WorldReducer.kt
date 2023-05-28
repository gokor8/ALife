package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.main.home.child.world.WorldAnnotation
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreateAlifeCardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.home.child.BaseProfileCardUseCase
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.child_world.BaseWorldProfileCardUC
import javax.inject.Inject

class WorldReducer @Inject constructor(
    @WorldAnnotation.WorldUIStore
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    mapper: Mapper<ProfileCardEntity, UICardModel>,
    @WorldAnnotation.WorldProfileUseCase
    worldCardUseCase: BaseWorldProfileCardUC,
) : AbstractHomeChildReducerBase(uiStore, mapper, worldCardUseCase) {

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