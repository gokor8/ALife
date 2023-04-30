package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.core.mapper.Mapper

fun pagerContainerOf(
    picture: PicturePagerItem,
    video: VideoPagerItem
) = PagerContainer(
    PagerContainerItem.Picture(picture, LoadScreenState()),
    PagerContainerItem.Video(video, LoadScreenState())
)

data class PagerContainer(
    val picture: PagerContainerItem.Picture,
    val video: PagerContainerItem.Video
) {

    private val pagerList = listOf(picture, video, PagerContainerItem.Empty())
        .mapIndexed { index, item -> PagerContainerListNode(index, item) }

    fun replacePicture(picturePagerItem: PicturePagerItem): PagerContainer {
        return PagerContainer(picture.copy(pagerItem = picturePagerItem), video)
    }

    fun replaceVideo(videoCameraPagerItem: VideoPagerItem): PagerContainer {
        return PagerContainer(picture, video.copy(pagerItem = videoCameraPagerItem))
    }

    fun tryInvertCamera(itemIndex: Int): PagerContainer {

        return copy(pagerList[itemIndex].pagerContainerItem.copyInvert())
    }

    fun canInvertCamera(itemIndex: Int): Boolean {
        return pagerList.getOrNull(itemIndex)?.pagerContainerItem?.canInvert() ?: false
    }

    fun size() = pagerList.size
}

class PagerAdapter(
    val picture: PagerContainerItem.Picture,
    val video: PagerContainerItem.Video
) {

    val pagerList = listOf(picture, video, PagerContainerItem.Empty())
        .mapIndexed { index, item -> PagerContainerListNode(index, item) }


}