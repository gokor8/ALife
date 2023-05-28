package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem

class FakeEmptyScreenPagerItem(
    copyList: MutableList<ScreenPagerItem<ScreenState.Empty, CreateAlifePagerItem>>
) : FakeAbstractScreenPagerItem<ScreenPagerItem<ScreenState.Empty, CreateAlifePagerItem>, ScreenState.Empty, CreateAlifePagerItem>(
    copyList
), ScreenPagerItem<ScreenState.Empty, CreateAlifePagerItem> {

    override val screenState: ScreenState.Empty = ScreenState.Empty()
    override val pagerItem: CreateAlifePagerItem = EmptyAlifePagerItem()

    override fun invertCamera(container: ScreenPagerContainer) = container

    override fun copyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState.Empty
    ): ScreenPagerContainer = container

    override fun copyThis() = this

    override fun copyContainer(
        container: ScreenPagerContainer,
        pagerItem: CreateAlifePagerItem
    ) = container
}