package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.model.BaseHomePagerItem
import com.alife.domain.core.list.IndexWrapperModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch

class HomePagerIndexWrapper(
    index: Int,
    homePagerItem: BaseHomePagerItem,
) : IndexWrapperModel<BaseHomePagerItem>(index, homePagerItem) {

    @Composable
    fun TabContent(position: Int, onClick: (Int) -> Unit) {
        model.TabContent(selected = position == index) { onClick(index) }
    }
}