package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.LoadVideoScreenState

class FakeVideoScreenPagerItem(
    copyList: MutableList<ScreenPagerItem.Video>,
    override val screenState: ScreenState = LoadVideoScreenState()
): FakeAbstractScreenPagerItem<ScreenPagerItem.Video>(copyList), ScreenPagerItem.Video {

    override val pagerItem: CreateAlifePagerItem = EmptyAlifePagerItem()

    override fun invertCamera(container: ScreenPagerContainer) = container.copy(video = copy())

    override fun copy(
        container: ScreenPagerContainer,
        captureWrapper: CookedCaptureWrapper
    ) = container.copy(video = copy())

    override fun copyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ) = container.copy(video = copy())

    override fun copyThis() = this
}