package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.BaseHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.compose.ProfileCardCompose

class UIProfileCardModel(
    val username: String,
    val frontAlife: String,
    val backAlife: String,
    val timestamp: String,
    val avatar: String? = null
) : UICardModel {

    override fun itemKey() = username

    @Composable
    override fun Card(viewModel: BaseHomeChildViewModel, modifier: Modifier) {
        ProfileCardCompose(
            profileName = username,
            avatar = avatar,
            timestamp = timestamp
        )
    }
}