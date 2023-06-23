package com.alife.anotherlife.ui.screen.main.navigation_bar.home.list

import androidx.compose.runtime.Composable
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.model.BaseHomePagerItem
import com.alife.domain.core.list.IndexWrapperModel

class HomePagerIndexWrapper(
    index: Int,
    homePagerItem: BaseHomePagerItem,
) : IndexWrapperModel<BaseHomePagerItem>(index, homePagerItem) {

    @Composable
    fun TabContent(position: Int, onClick: (Int) -> Unit) {
        model.TabContent(selected = position == index) { onClick(index) }
    }
}