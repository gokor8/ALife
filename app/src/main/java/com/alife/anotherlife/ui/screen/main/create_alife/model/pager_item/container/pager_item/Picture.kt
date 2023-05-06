package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.AbstractScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.CameraVideoScreenState

class Picture(
    screenState: ScreenState,
    override val pagerItem: PicturePagerItem
) : ScreenPagerItem.Picture, AbstractScreenPagerItem<PicturePagerItem>(screenState, pagerItem) {
    override fun invertScreenState(
        container: ScreenPagerContainer,
        screenState: InvertibleScreenState
    ): ScreenPagerContainer {
        return container.copy(picture = Picture(screenState.copyInvertCamera(), pagerItem))
    }

    override fun isScreenStateFit(screenState: ScreenState): Boolean {
        return screenState !is CameraVideoScreenState
    }

    override fun safeCopyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ) = container.copy(picture = copy(screenState))

    override fun copy(
        container: ScreenPagerContainer,
        captureWrapper: CookedCaptureWrapper
    ) = container.copy(picture = copy(PicturePagerItem.DefaultTakePicture()))

    override fun copyContainer(
        container: ScreenPagerContainer,
        pagerItem: PicturePagerItem
    ) = container.copy(picture = copy(pagerItem))

    override fun copy(picturePagerItem: PicturePagerItem): ScreenPagerItem.Picture {
        return Picture(screenState, picturePagerItem)
    }

    override fun copy(screenState: ScreenState): ScreenPagerItem.Picture {
        return Picture(screenState, pagerItem)
    }
}