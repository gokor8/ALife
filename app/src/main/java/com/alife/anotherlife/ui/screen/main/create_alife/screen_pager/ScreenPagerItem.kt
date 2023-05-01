package com.alife.anotherlife.ui.screen.main.create_alife.screen_pager

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState

interface ScreenPagerItem {

    val screenState: ScreenState
    val pagerItem: CreateAlifePagerItem

    fun canInvert(): Boolean {
        return pagerItem is InvertiblePagerItem && screenState is InvertibleScreenState
    }

    fun invertCamera(): ScreenPagerItem


    interface Picture : ScreenPagerItem {
        fun copy(picturePagerItem: PicturePagerItem): Picture
    }

    interface Video : ScreenPagerItem
}