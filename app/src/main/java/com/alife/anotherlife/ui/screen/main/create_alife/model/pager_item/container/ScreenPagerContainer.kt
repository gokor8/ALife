package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.NotScrollablePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.list_adapter.ContainerListAdapterFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Picture
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Video

//fun screenPagerContainerOf(
//    picture: PicturePagerItem,
//    video: VideoPagerItem
//): ScreenPagerContainer {
//    return ScreenPagerContainer(
//        Picture(LoadScreenState(), picture),
//        Video(LoadScreenState(), video)
//    )
//}

data class ScreenPagerContainer(
    val picture: ScreenPagerItem.Picture,
    val video: ScreenPagerItem.Video,
    private val adapterFactory: ContainerListAdapterFactory = ContainerListAdapterFactory.Default()
) : BaseScreenPagerContainer {

    private val adapter = adapterFactory.create(picture, video)

    override fun getVideoIndex() = adapter.getVideoIndex()

    override fun getPagerItems() = adapter.createPagerItems().map { it.pagerItem }
    override fun getScreenPagerItem(index: Int) = adapter.getItemByIndex(index)

    override fun canCurrentScroll(index: Int): Boolean {
        return getScreenPagerItem(index).pagerItem !is NotScrollablePagerItem
    }

    override fun changeScreenPagerItem(index: Int, screenState: ScreenState): ScreenPagerContainer {
        return getScreenPagerItem(index).copyContainer(this, screenState)
    }

    override fun changePicture(picturePagerItem: ScreenPagerItem.Picture): ScreenPagerContainer {
        return copy(picture = picturePagerItem)
    }

    override fun changePicture(screenState: ScreenState): ScreenPagerContainer {
        return copy(picture = picture.copy(screenState))
    }

    override fun changePicture(pagerItem: PicturePagerItem): ScreenPagerContainer {
        return copy(picture = picture.copy(pagerItem))
    }
}