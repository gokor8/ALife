package com.alife.anotherlife.ui.screen.main.create_alife.reducer_photo

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.BaseScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Empty
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

class FakeScreenPagerContainer : BaseScreenPagerContainer {

    override fun getPagerItems(): List<CreateAlifePagerItem> = listOf(EmptyAlifePagerItem())

    override fun getScreenPagerItem(index: Int): ScreenPagerItem = Empty()

    override fun changeScreenPagerItem(index: Int, screenState: ScreenState): ScreenPagerContainer {
        TODO("Not yet implemented")
    }

    override fun changePicture(picturePagerItem: ScreenPagerItem.Picture): ScreenPagerContainer {
        TODO("Not yet implemented")
    }

    override fun changePicture(screenState: ScreenState): ScreenPagerContainer {
        TODO("Not yet implemented")
    }

    override fun changePicture(pagerItem: PicturePagerItem): ScreenPagerContainer {
        TODO("Not yet implemented")
    }

    override fun getVideoIndex(): Int = 0
}