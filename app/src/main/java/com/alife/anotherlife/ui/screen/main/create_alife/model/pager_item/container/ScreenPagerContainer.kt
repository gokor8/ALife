package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.list_adapter.ContainerListAdapterFactory

fun screenPagerContainerOf(
    picture: PicturePagerItem,
    video: VideoPagerItem
): ScreenPagerContainer {
    return ScreenPagerContainer(
        AbstractScreenPagerItem.Picture(LoadScreenState(), picture),
        AbstractScreenPagerItem.Video(LoadScreenState(), video)
    )
}

data class ScreenPagerContainer(
    val picture: ScreenPagerItem.Picture,
    val video: ScreenPagerItem.Video,
    val adapterFactory: ContainerListAdapterFactory = ContainerListAdapterFactory.Default()
) : VideoIndex {

    private val adapter = adapterFactory.create(picture, video)

    override fun getVideoIndex() = adapter.getVideoIndex()

    fun getPagerItems() = adapter.createPagerItems().map { it.pagerItem }
    fun getScreenPagerItem(index: Int) = adapter.getItemByIndex(index)

    fun changeScreenPagerItem(index: Int, screenState: ScreenState): ScreenPagerContainer {
        return getScreenPagerItem(index).copyContainer(this, screenState)
    }

    fun changePicture(picturePagerItem: ScreenPagerItem.Picture): ScreenPagerContainer {
        return copy(picture = picturePagerItem)
    }

    fun changePicture(screenState: ScreenState): ScreenPagerContainer {
        return copy(picture = picture.copy(screenState))
    }

    fun changePicture(pagerItem: PicturePagerItem): ScreenPagerContainer {
        return copy(picture = picture.copy(pagerItem))
    }
}