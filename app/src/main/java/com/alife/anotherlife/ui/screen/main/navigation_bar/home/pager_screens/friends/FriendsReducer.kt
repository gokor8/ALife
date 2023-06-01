package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends

import androidx.paging.PagingSource
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.main.home.child.friends.FriendsAnnotation
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.model.TabsVisibilityContract
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseLoadStatesToStateEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.child_friends.BaseFriendsProfileCardUC
import javax.inject.Inject

class FriendsReducer @Inject constructor(
    @FriendsAnnotation.FriendsUIStore
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    mapper: Mapper<ProfileCardEntity, UIPostModel>,
    postsPaging: PagingSource<Int, UIPostModel>,
    loadStateMapper: BaseLoadStatesToStateEffect,
    tabsVisibilityContract: TabsVisibilityContract
) : AbstractHomeChildReducerBase(
    uiStore,
    mapper,
    postsPaging,
    loadStateMapper,
    tabsVisibilityContract
) {

//    override suspend fun onInit(viewModelScope: CoroutineScope) {
//
//        //setLoadState
//
//        //if(getState().profileList.isNotEmpty()) return
//
//        execute {
//
//        }.handle {
//            val profileCards = profileCardUseCase.getProfileCards().profileCards
//
//            val uiPostModels = if(profileCards.isNotEmpty()) {
//                profileCards.map { mapper.map(it) }
//            } else {
//                listOf<UIPostModel>(UIPlzCreatePostModel())
//            }
//
//            setState { copy(profileList = uiPostModels) }
//        }
//    }
}