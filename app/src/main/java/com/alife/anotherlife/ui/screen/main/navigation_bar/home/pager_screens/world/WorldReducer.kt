package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world

import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.di.ui.main.home.child.world.WorldAnnotation
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.model.TabsVisibilityContract
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper.BaseLoadStatesToStateEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging.BasePagingSourceFactory
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging.PostsPagingSource
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildState
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.ProfileCardEntity
import javax.inject.Inject

class WorldReducer @Inject constructor(
    @WorldAnnotation.WorldUIStore
    override val uiStore: UIStore<HomeChildState, HomeChildEffect>,
    mapper: Mapper<ProfileCardEntity, UIPostModel>,
    loadStateMapper: BaseLoadStatesToStateEffect,
    pagingFactory: BasePagingSourceFactory<PostsPagingSource>,
    tabsVisibilityContract: TabsVisibilityContract
) : AbstractHomeChildReducerBase(
    uiStore,
    mapper,
    loadStateMapper,
    pagingFactory,
    tabsVisibilityContract
)