package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.style16Bold
import com.alife.anotherlife.core.composable.text.style.style18Bold
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.PostPhotoCardCompose
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.UICloudPicturesModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction
import java.time.format.TextStyle

abstract class AbstractUIPhotosPostModel(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null,
    private val frontAlife: String,
    private val backAlife: String,
) : UIPostModel.Abstract() {

    override fun itemKey() = username + timestamp

    @Composable
    override fun Card(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
        PostPhotoCardCompose(
            profileName = username,
            avatar = avatar,
            timestamp = timestamp,
            photoCardModel = UICloudPicturesModel(frontAlife, backAlife),
            modifier = modifier
        ) {
            viewModel.reduce(HomeChildAction.OnPostProfile(username))
        }
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
    override fun Card(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            super.Card(viewModel, modifier.blur(30.dp))
            Column(Modifier.padding(horizontal = 40.dp)) {
                TextBase(
                    textResId = R.string.create_alife_on_post,
                    textAlign = TextAlign.Center,
                    style = style16Bold()
                )
                Spacer(modifier = Modifier.padding(bottom = 22.dp))
                Button18(text = R.string.create_alife_base) {
                    viewModel.reduce(HomeChildAction.OnTakeALife())
                }
            }
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