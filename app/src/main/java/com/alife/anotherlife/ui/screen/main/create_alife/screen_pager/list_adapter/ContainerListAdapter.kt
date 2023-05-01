package com.alife.anotherlife.ui.screen.main.create_alife.screen_pager.list_adapter

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.screen_pager.AbstractScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.screen_pager.ScreenPagerItem

interface ContainerListAdapter {

    fun createPagerItems(): List<ScreenPagerItem>

    fun getItemByIndex(index: Int): ScreenPagerItem


    class Default(
        picture: ScreenPagerItem.Picture,
        video: ScreenPagerItem.Video
    ) : ContainerListAdapter {

        private val pictureWrap = ListAdapterNode(0, picture)
        private val videoWrap = ListAdapterNode(1, video)
        private val emptyWrap = ListAdapterNode(2, AbstractScreenPagerItem.Empty())

        private val listWrap = listOf(pictureWrap, videoWrap, emptyWrap)

        override fun createPagerItems() = listWrap.map { it.screenPagerItem }

        override fun getItemByIndex(index: Int): ScreenPagerItem {
            return listWrap.find { it.index == index }?.screenPagerItem ?: emptyWrap.screenPagerItem
        }
    }
}