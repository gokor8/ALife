package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem

abstract class FakeAbstractScreenPagerItem<R : ScreenPagerItem<M>, M : CreateAlifePagerItem>(
    protected val copyList: MutableList<R>
) : ScreenPagerItem<M> {

    protected abstract fun copyThis(): R

    protected fun copy(): R {
        val copyValue = copyThis()
        copyList.add(copyValue)
        return copyValue
    }
}