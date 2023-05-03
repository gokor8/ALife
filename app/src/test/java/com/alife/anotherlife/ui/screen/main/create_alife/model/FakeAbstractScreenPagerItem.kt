package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem

abstract class FakeAbstractScreenPagerItem(
    protected val list: MutableList<ScreenPagerItem>
) : ScreenPagerItem