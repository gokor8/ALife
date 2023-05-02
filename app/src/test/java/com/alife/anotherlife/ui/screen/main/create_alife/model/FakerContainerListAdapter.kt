package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.screen_pager.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.screen_pager.list_adapter.ContainerListAdapter

class FakerContainerListAdapter : ContainerListAdapter {

    override fun createPagerItems(): List<ScreenPagerItem> = listOf(FakeEmptyScreenPagerItem())

    override fun getItemByIndex(index: Int): ScreenPagerItem = FakeEmptyScreenPagerItem()

    override fun getVideoIndex(): Int = 0
}