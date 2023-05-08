package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState

interface BaseScreenPagerContainer : VideoIndex {

    fun getPagerItems(): List<CreateAlifePagerItem>

    fun getScreenPagerItem(index: Int) : ScreenPagerItem<*, *>

    fun canCurrentScroll(index: Int): Boolean

    fun changePicture(picturePagerItem: ScreenPagerItem.Picture): BaseScreenPagerContainer

    fun changePicture(screenState: BasePictureScreenState): BaseScreenPagerContainer

    fun changePicture(pagerItem: PicturePagerItem): BaseScreenPagerContainer
}