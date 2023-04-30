package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.pager_container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem

class PagerList(
    picture: PagerListItem.Picture,
    video: PagerListItem.Video,
    private val handler: BasePagerListHandler
) : ArrayList<BasePagerListItem>(handler.createList(picture, video)) {

    fun getPicture() = get(handler.pictureIndex) as PagerListItem.Picture

    fun getVideo() = get(handler.videoIndex) as PagerListItem.Video

    fun replacePicture(picturePagerItem: PicturePagerItem) {
        set(handler.pictureIndex, getPicture().copy(pagerItem = picturePagerItem))
    }

    fun replaceVideo(videoCameraPagerItem: VideoPagerItem) {
        set(handler.videoIndex, getVideo().copy(pagerItem = videoCameraPagerItem))
    }

    fun tryInvertCamera(itemIndex: Int) {
        val item = getOrNull(itemIndex)?.copyInvert() ?: return
        set(itemIndex, item)
    }

    fun canInvertCamera(itemIndex: Int): Boolean {
        return getOrNull(itemIndex)?.canInvert() ?: false
    }
}