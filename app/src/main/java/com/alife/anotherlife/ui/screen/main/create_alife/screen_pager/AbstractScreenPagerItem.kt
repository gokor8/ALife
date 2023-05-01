package com.alife.anotherlife.ui.screen.main.create_alife.screen_pager

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState

abstract class AbstractScreenPagerItem(
    override val screenState: ScreenState,
    override val pagerItem: CreateAlifePagerItem
) : ScreenPagerItem {

    override fun invertCamera(): ScreenPagerItem {
        return if(canInvert()) invertScreenState(screenState as InvertibleScreenState) else this
    }

    abstract fun invertScreenState(screenState: InvertibleScreenState): ScreenPagerItem


    class Picture(
        screenState: ScreenState,
        override val pagerItem: PicturePagerItem
    ) : ScreenPagerItem.Picture, AbstractScreenPagerItem(screenState, pagerItem) {
        override fun invertScreenState(screenState: InvertibleScreenState): ScreenPagerItem {
            return Picture(screenState.copyInvertCamera(), pagerItem)
        }

        override fun copy(picturePagerItem: PicturePagerItem): ScreenPagerItem.Picture {
            return Picture(screenState, picturePagerItem)
        }
    }

    class Video(
        screenState: ScreenState,
        override val pagerItem: VideoPagerItem
    ) : ScreenPagerItem.Video, AbstractScreenPagerItem(screenState, pagerItem) {
        override fun invertScreenState(screenState: InvertibleScreenState): ScreenPagerItem {
            return Video(screenState.copyInvertCamera(), pagerItem)
        }
    }

    class Empty : ScreenPagerItem {

        override val screenState: ScreenState = ScreenState.Empty()
        override val pagerItem: CreateAlifePagerItem = EmptyAlifePagerItem()

        override fun invertCamera(): ScreenPagerItem = this
    }
}