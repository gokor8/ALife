package com.alife.anotherlife.ui.screen.main.navigation_bar.home.list

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.model.BaseHomePagerItem
import com.alife.domain.core.list.ToIndexWrapperMapper

class HomePagerToIndexWrapper : ToIndexWrapperMapper<HomePagerIndexWrapper, BaseHomePagerItem> {

    override fun map(index: Int, model: BaseHomePagerItem): HomePagerIndexWrapper {
        return HomePagerIndexWrapper(index, model)
    }
}