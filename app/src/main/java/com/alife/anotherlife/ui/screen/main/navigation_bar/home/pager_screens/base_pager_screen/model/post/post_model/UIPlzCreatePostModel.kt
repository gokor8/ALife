package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.exoplayer.ExoPlayer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.PlzCreateAlifeCompose
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction

class UIPlzCreatePostModel : UIPostModel {

    private val itemStaticKey = "plz_create"

    override fun itemKey() = itemStaticKey

    @Composable
    override fun Card(
        exoPlayer: ExoPlayer,
        viewModel: AbstractHomeChildViewModel,
        modifier: Modifier
    ) {
        PlzCreateAlifeCompose {
            viewModel.reduce(HomeChildAction.OnTakeALife())
        }
    }
}