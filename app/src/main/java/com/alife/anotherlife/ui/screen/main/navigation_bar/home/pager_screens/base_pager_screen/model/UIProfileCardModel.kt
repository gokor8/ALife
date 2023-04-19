package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.ProfileCardCompose

data class UIProfileCardModel(
    val username: String,
    val frontAlife: String,
    val backAlife: String,
    val timestamp: String,
    val avatar: String? = null
) : UICardModel {

    override fun itemKey() = username

    @Composable
    override fun Card(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
        ProfileCardCompose(
            profileName = username,
            avatar = avatar,
            timestamp = timestamp
        )
    }
}