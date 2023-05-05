package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem

class FakeEmptyScreenPagerItem(
    copyList: MutableList<ScreenPagerItem>
): FakeAbstractScreenPagerItem<ScreenPagerItem>(copyList), ScreenPagerItem {

    override val screenState: ScreenState = ScreenState.Empty()
    override val pagerItem: CreateAlifePagerItem = EmptyAlifePagerItem()

    override fun invertCamera(container: ScreenPagerContainer) = container

    override fun copyThis() = this

    override fun copy(
        container: ScreenPagerContainer,
        captureWrapper: CookedCaptureWrapper
    ) = container

    override fun copyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ) = container
}