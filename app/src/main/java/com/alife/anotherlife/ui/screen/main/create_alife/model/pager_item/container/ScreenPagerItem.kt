package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.StartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.VideoCaptureWrapperToState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.VideoCaptureCallback

interface ScreenPagerItem<P : CreateAlifePagerItem> {

    val screenState: ScreenState
    val pagerItem: P

    fun canInvert(): Boolean {
        return pagerItem is InvertiblePagerItem && screenState is InvertibleScreenState
    }

    fun invertCamera(container: ScreenPagerContainer): ScreenPagerContainer

    fun copy(
        container: ScreenPagerContainer,
        captureWrapper: CookedCaptureWrapper
    ): ScreenPagerContainer

    fun copyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ): ScreenPagerContainer

    fun copyContainer(
        container: ScreenPagerContainer,
        pagerItem: P
    ): ScreenPagerContainer


    interface Picture : ScreenPagerItem<PicturePagerItem> {
        override val pagerItem: PicturePagerItem

        fun copy(picturePagerItem: PicturePagerItem): Picture
        fun copy(screenState: ScreenState): Picture

    }

    interface Video : ScreenPagerItem<VideoPagerItem> {
        fun onCallback(videoCaptureCallback: VideoCaptureCallback)

        fun isCookedVideoCapture(): Boolean
    }
}