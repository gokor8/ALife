package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

abstract class FakeAbstractScreenPagerItem<R : ScreenPagerItem<S, P>, S : ScreenState, P : CreateAlifePagerItem>(
    protected val copyList: MutableList<R>
) : ScreenPagerItem<S, P> {

    protected abstract fun copyThis(): R

    protected fun copy(): R {
        val copyValue = copyThis()
        copyList.add(copyValue)
        return copyValue
    }
}