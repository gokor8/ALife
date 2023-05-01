package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

fun pagerContainerOf(
    picture: PicturePagerItem,
    video: VideoPagerItem
) = PagerContainer(
    PagerContainerItem.Picture(picture, LoadScreenState()),
    PagerContainerItem.Video(video, LoadScreenState()),
)

data class PagerContainer(
    override val picture: PagerContainerItem.Picture,
    override val video: PagerContainerItem.Video,
    private val adapter: PagerListAdapter = PagerListAdapter.Default(picture, video)
) : BasePagerContainer {

    override fun getPagerItems() = adapter.createPagerItemsList()

    override fun currentScreenState(index: Int) = adapter.getItemByIndex(index).screenState

    override fun replacePicture(pictureScreenState: ScreenState): PagerContainer {
        return copy(picture = picture.copy(screenState = pictureScreenState))
    }

    override fun replacePicture(picturePagerItem: PicturePagerItem): PagerContainer {
        return copy(picture = picture.copy(pagerItem = picturePagerItem))
    }

    override fun replaceVideo(videoCameraPagerItem: VideoPagerItem): PagerContainer {
        return copy(video = video.copy(pagerItem = videoCameraPagerItem))
    }

    override fun tryInvertCamera(itemIndex: Int): PagerContainer {
        return adapter.getItemByIndex(itemIndex).copyWithInvert(this)
    }

    override fun canInvertCamera(itemIndex: Int): Boolean {
        return adapter.getItemByIndex(itemIndex).canInvert()
    }

    override fun getVideoIndex(): Int = adapter.getVideoIndex()

    override fun size() = adapter.size()
}