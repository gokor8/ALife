package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.main.home.child.world.WorldAnnotation
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreateAlifeCardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.home.child.BaseProfileCardUseCase
import com.alife.domain.main.home.child.ProfileCardEntity
import javax.inject.Inject

class WorldReducer @Inject constructor(
    @WorldAnnotation.WorldUIStore
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    mapper: Mapper<ProfileCardEntity, UICardModel>,
    @WorldAnnotation.WorldProfileUseCase
    profileCardUseCase: BaseProfileCardUseCase,
) : AbstractHomeChildReducer(uiStore, mapper, profileCardUseCase) {

    override suspend fun onInit() {

        //setLoadState

        if(getState().profileList.isNotEmpty()) return

        val profileCardsEntity = profileCardUseCase.getProfileCards()

        if (profileCardsEntity is UseCaseResult.Fail) {
            // show error
        }

        (profileCardsEntity as? UseCaseResult.Success)?.model?.let { entity ->
            val uiCardModels = if (entity.profileCards.isNotEmpty())
                entity.profileCards.map { mapper.map(it) }
            else
                listOf<UICardModel>(UIPlzCreateAlifeCardModel())
            // TODO set error

            setState { copy(profileList = uiCardModels) }
        } ?: {} //Set ERROR setState { copy(profileList = uiCardModels) }
    }
}