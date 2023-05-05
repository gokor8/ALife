package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.LoadPictureScreenState

class FakePictureScreenPagerItem(
    copyList: MutableList<ScreenPagerItem.Picture>,
    override val screenState: ScreenState = LoadPictureScreenState()
): FakeAbstractScreenPagerItem<ScreenPagerItem.Picture>(copyList), ScreenPagerItem.Picture {

    override val pagerItem: PicturePagerItem = FakePicturePagerItem()

    override fun copy(picturePagerItem: PicturePagerItem) = copy()

    override fun copy(screenState: ScreenState) = copy()
    override fun copy(
        container: ScreenPagerContainer,
        captureWrapper: CookedCaptureWrapper
    ): ScreenPagerContainer = container.copy(picture = copy())

    override fun invertCamera(container: ScreenPagerContainer) = container.copy(picture = copy())

    override fun copyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ) = container.copy(picture = copy())

    override fun copyThis() = this
}