package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.pager_container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState

interface BasePagerListItem {
    fun copyInvert(): BasePagerListItem

    fun canInvert(): Boolean
}

abstract class PagerListItem : BasePagerListItem {

    abstract val pagerItem: CreateAlifePagerItem
    abstract val screenState: ScreenState

    override fun canInvert(): Boolean {
        return pagerItem is InvertiblePagerItem && screenState is InvertibleScreenState
    }

    override fun copyInvert(): BasePagerListItem {
        val screenState = screenState
        if(screenState !is InvertibleScreenState) return this

        return copyScreenState(screenState.copyInvertCamera())
    }

    protected abstract fun copyScreenState(screenState: ScreenState): PagerListItem


    data class Picture(
        override val pagerItem: PicturePagerItem,
        override val screenState: ScreenState,
    ) : PagerListItem() {
        override fun copyScreenState(screenState: ScreenState): PagerListItem {
            return copy(screenState = screenState)
        }
    }

    data class Video(
        override val pagerItem: VideoPagerItem,
        override val screenState: ScreenState,
    ) : PagerListItem() {
        override fun copyScreenState(screenState: ScreenState): PagerListItem {
            return copy(screenState = screenState)
        }
    }

    class Empty : BasePagerListItem {
        override fun copyInvert(): BasePagerListItem = this
        override fun canInvert(): Boolean = false
    }
}