package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

interface BasePagerContainer : VideoIndex {

    val picture: BasePagerContainerItem
    val video: BasePagerContainerItem

    fun currentScreenState(index: Int): ScreenState

    fun replacePicture(pictureScreenState: ScreenState): PagerContainer

    fun replacePicture(picturePagerItem: PicturePagerItem): PagerContainer

    fun replaceVideo(videoCameraPagerItem: VideoPagerItem): PagerContainer

    fun tryInvertCamera(itemIndex: Int): PagerContainer

    fun canInvertCamera(itemIndex: Int): Boolean

    fun size(): Int
}