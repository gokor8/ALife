package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.HomeViewModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.BaseHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.compose.PlzCreateAlifeCompose
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.state.HomeAction

class UIPlzCreateAlifeCardModel : UICardModel {

    private val itemStaticKey = "plz_create"

    override fun itemKey() = itemStaticKey

    @Composable
    override fun Card(viewModel: BaseHomeChildViewModel, modifier: Modifier) {
        PlzCreateAlifeCompose {
            viewModel.reduce(HomeChildAction.OnTakeALife())
        }
    }
}