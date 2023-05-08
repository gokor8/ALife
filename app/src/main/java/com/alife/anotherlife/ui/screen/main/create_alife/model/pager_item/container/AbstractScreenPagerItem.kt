package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

abstract class AbstractScreenPagerItem<S : ScreenState, P : CreateAlifePagerItem>(
    override val screenState: S,
    override val pagerItem: P,
    //protected val mapper: ScreenPagerMapper<AbstractScreenPagerItem<S, P>>
) : ScreenPagerItem<S, P>