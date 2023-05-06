package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.list_adapter

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.VideoIndex
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.AbstractScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Empty

interface ContainerListAdapter : VideoIndex {

    fun createPagerItems(): List<ScreenPagerItem<*>>

    fun getItemByIndex(index: Int): ScreenPagerItem<*>


    class Default(
        picture: ScreenPagerItem.Picture,
        video: ScreenPagerItem.Video
    ) : ContainerListAdapter {

        private val pictureWrap = ListAdapterNode(0, picture)
        private val videoWrap = ListAdapterNode(1, video)
        private val emptyWrap = ListAdapterNode(2, Empty())

        private val listWrap = listOf(pictureWrap, videoWrap, emptyWrap)

        override fun getVideoIndex(): Int = videoWrap.index

        override fun createPagerItems() = listWrap.map { it.screenPagerItem }

        override fun getItemByIndex(index: Int): ScreenPagerItem<*> {
            return listWrap.find { it.index == index }?.screenPagerItem ?: emptyWrap.screenPagerItem
        }
    }
}