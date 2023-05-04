package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState

interface ScreenPagerItem {

    val screenState: ScreenState
    val pagerItem: CreateAlifePagerItem

    fun canInvert(): Boolean {
        return pagerItem is InvertiblePagerItem && screenState is InvertibleScreenState
    }

    fun invertCamera(screenPagerContainer: ScreenPagerContainer): ScreenPagerContainer

    fun copy(
        container: ScreenPagerContainer,
        captureWrapper: CookedCaptureWrapper
    ): ScreenPagerContainer

    fun copyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ): ScreenPagerContainer

    interface Picture : ScreenPagerItem {
        override val pagerItem: PicturePagerItem

        fun copy(picturePagerItem: PicturePagerItem): Picture
        fun copy(screenState: ScreenState): Picture

    }

    interface Video : ScreenPagerItem
}