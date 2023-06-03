package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.LceErrorNoPostsHaveMyPostProvider
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.LceErrorPagingLoadProvider
import com.alife.core.mapper.Mapper
import javax.inject.Inject

interface BaseAppendErrorMapper : Mapper<Throwable, LCEModel.Error>

class AppendErrorMapper @Inject constructor() : BaseAppendErrorMapper {

    override fun map(inputModel: Throwable): LCEModel.Error {
        return when(inputModel) {
            is NoPostsWithAvailableTodayPostException -> LceErrorNoPostsHaveMyPostProvider
            else -> LceErrorPagingLoadProvider
        }
    }
}