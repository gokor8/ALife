package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.media3.exoplayer.ExoPlayer
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.alife_card.ALifeCardCompose
import com.alife.anotherlife.core.composable.alife_card.start_strategy.DefaultStrategy
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.style16Bold
import com.alife.anotherlife.core.composable.text.style.style18Bold
import com.alife.anotherlife.theme.Shapes
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.BlurCreateAlife
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.PostCardCompose
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.PostPhotoCardCompose
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.UICloudPicturesModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction
import com.skydoves.cloudy.Cloudy
import java.time.format.TextStyle

abstract class AbstractUIPhotosPostModel(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null,
    private val frontAlife: String,
    private val backAlife: String,
) : UIPostModel.Abstract() {

    override fun itemKey() = username + timestamp + avatar + frontAlife + backAlife

    @Composable
    open fun Card(
        viewModel: AbstractHomeChildViewModel,
        modifier: Modifier
    ) {
        PostCardCompose(
            profileName = username,
            avatar = avatar,
            timestamp = timestamp,
            modifier = modifier,
            onProfileClick = { viewModel.reduce(HomeChildAction.OnPostProfile(username)) }
        ) { newModifier -> AlifeCard(viewModel, newModifier) }
    }

    @Composable
    protected open fun AlifeCard(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
        ALifeCardCompose(
            UICloudPicturesModel(frontAlife, backAlife),
            offsetsStartStrategy = DefaultStrategy(),
            modifier = modifier
        )
    }
}

class BlurUIPhotosPostModel(
    username: String,
    timestamp: String,
    avatar: String? = null,
    frontAlife: String,
    backAlife: String
) : AbstractUIPhotosPostModel(username, timestamp, avatar, frontAlife, backAlife) {

    @Composable
    override fun AlifeCard(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
        BlurCreateAlife(
            modifier,
            viewModel::reduce,
        ) {
            super.AlifeCard(viewModel, modifier)
        }
    }
}

class UIPhotosPostModel(
    username: String,
    timestamp: String,
    avatar: String? = null,
    frontAlife: String,
    backAlife: String
) : AbstractUIPhotosPostModel(username, timestamp, avatar, frontAlife, backAlife)