package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.list_adapter.ContainerListAdapter
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.list_adapter.ContainerListAdapterFactory

class FakeContainerListAdapterFactory : ContainerListAdapterFactory {
    override fun create(
        picture: ScreenPagerItem.Picture,
        video: ScreenPagerItem.Video
    ): ContainerListAdapter = FakerContainerListAdapter()
}

class FakerContainerListAdapter : ContainerListAdapter {

    override fun createPagerItems(): List<ScreenPagerItem> = listOf(FakeEmptyScreenPagerItem())

    override fun getItemByIndex(index: Int): ScreenPagerItem = FakeEmptyScreenPagerItem()

    override fun getVideoIndex(): Int = 0
}