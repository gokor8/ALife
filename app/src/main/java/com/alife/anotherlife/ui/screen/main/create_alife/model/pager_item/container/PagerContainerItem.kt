package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState

interface BasePagerContainerItem {

    val pagerItem: CreateAlifePagerItem
    val screenState: ScreenState

    fun copyWithInvert(pagerContainer: PagerContainer): PagerContainer

    fun canInvert(): Boolean
}

abstract class PagerContainerItem : BasePagerContainerItem {

    override fun canInvert(): Boolean {
        return pagerItem is InvertiblePagerItem && screenState is InvertibleScreenState
    }

    override fun copyWithInvert(pagerContainer: PagerContainer): PagerContainer {
        val screenState = screenState

        return if (screenState is InvertibleScreenState && canInvert())
            copyPagerContainer(pagerContainer, screenState.copyInvertCamera())
        else
            pagerContainer
    }

    protected abstract fun copyPagerContainer(
        pagerContainer: PagerContainer,
        screenState: ScreenState
    ): PagerContainer


    data class Picture(
        override val pagerItem: PicturePagerItem,
        override val screenState: ScreenState
    ) : PagerContainerItem() {
        override fun copyPagerContainer(
            pagerContainer: PagerContainer,
            screenState: ScreenState
        ) = pagerContainer.copy(picture = copy(screenState = screenState))
    }

    data class Video(
        override val pagerItem: VideoPagerItem,
        override val screenState: ScreenState
    ) : PagerContainerItem() {
        override fun copyPagerContainer(
            pagerContainer: PagerContainer,
            screenState: ScreenState
        ) = pagerContainer.copy(video = copy(screenState = screenState))
    }

    class Empty : BasePagerContainerItem {
        override val pagerItem: CreateAlifePagerItem = EmptyAlifePagerItem()
        override val screenState: ScreenState = LoadScreenState()
        override fun copyWithInvert(pagerContainer: PagerContainer) = pagerContainer
        override fun canInvert(): Boolean = false
    }
}