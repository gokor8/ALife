package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.exoplayer.ExoPlayer
import com.alife.anotherlife.core.composable.text.style.Title20Style
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel

interface DefaultPostModel : UIPostModel {

    @Composable
    fun Card(
        viewModel: AbstractHomeChildViewModel,
        modifier: Modifier
    ) {
        Text("Bad Post", style = Title20Style().style())
    }
}

class UIBadPostModel(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null
) : UIPostModel.Abstract(), DefaultPostModel {

    override fun itemKey() = username

    @Composable
    override fun Card(
        viewModel: AbstractHomeChildViewModel,
        modifier: Modifier
    ) {
        Text("Bad Post", style = Title20Style().style())
    }
}