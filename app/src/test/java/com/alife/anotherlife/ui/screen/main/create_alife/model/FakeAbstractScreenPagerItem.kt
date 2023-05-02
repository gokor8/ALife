package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.screen_pager.ScreenPagerItem

abstract class FakeAbstractScreenPagerItem(
    protected val list: MutableList<ScreenPagerItem>
) : ScreenPagerItem