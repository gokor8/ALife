package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.main.home.child.friends.FriendsAnnotation
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.model.TabsVisibilityContract
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseLoadStatesToStateEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging.BasePagingSourceFactory
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging.PostsPagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.BaseMyPostUseCase
import com.alife.domain.main.home.child.ProfileCardEntity
import javax.inject.Inject

class FriendsReducer @Inject constructor(
    @FriendsAnnotation.FriendsUIStore
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    mapper: Mapper<ProfileCardEntity, UIPostModel>,
    loadStateMapper: BaseLoadStatesToStateEffect,
    pagingFactory: BasePagingSourceFactory.Friends,
    tabsVisibilityContract: TabsVisibilityContract,
    myPostUseCase: BaseMyPostUseCase
) : AbstractHomeChildReducerBase(
    uiStore,
    mapper,
    loadStateMapper,
    pagingFactory,
    tabsVisibilityContract,
    myPostUseCase
)