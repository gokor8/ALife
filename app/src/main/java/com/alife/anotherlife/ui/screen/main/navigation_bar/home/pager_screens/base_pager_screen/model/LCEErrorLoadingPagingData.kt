package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.state.lce.ErrorScreen
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.BaseHomeChildReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect

//class LCEErrorLoadingPagingData(
//    private val reducer: BaseHomeChildReducer
//) : LCEModel.Error {
//
//    @Composable
//    override fun LCEContent(modifier: Modifier) {
//        ErrorScreen(
//            stringResource(R.string.home_chile_paging_error_title),
//            stringResource(R.string.home_chile_paging_error_description),
//            stringResource(R.string.upload)
//        ) { reducer.trySetEffect(HomeChildEffect.RequireInit()) }
//    }
//}