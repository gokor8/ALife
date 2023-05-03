package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem

class FakeVideoScreenPagerItem: ScreenPagerItem.Video {

    override val screenState: ScreenState = LoadScreenState()
    override val pagerItem: CreateAlifePagerItem = EmptyAlifePagerItem()

    override fun invertCamera(screenPagerContainer: ScreenPagerContainer): ScreenPagerContainer {
        return screenPagerContainer
    }

    override fun copyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ): ScreenPagerContainer = container
}