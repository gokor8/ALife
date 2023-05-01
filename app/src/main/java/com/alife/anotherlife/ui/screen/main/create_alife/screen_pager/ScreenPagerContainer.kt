package com.alife.anotherlife.ui.screen.main.create_alife.screen_pager

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.screen_pager.list_adapter.ContainerListAdapter

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
    private val adapter: ContainerListAdapter = ContainerListAdapter.Default(picture, video)
) {
    fun getPagerItems() = adapter.createPagerItems().map { it.pagerItem }
    fun getScreenPagerItem(index: Int) = adapter.getItemByIndex(index)

    fun changePicture(picturePagerItem: PicturePagerItem): ScreenPagerContainer {
        return copy(picture = picture.copy(picturePagerItem))
    }

}