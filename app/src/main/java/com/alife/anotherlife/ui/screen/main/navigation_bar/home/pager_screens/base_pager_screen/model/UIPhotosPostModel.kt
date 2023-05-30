package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.model.UILocalPicturesModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.PostPhotoCardCompose

data class UIPhotosPostModel(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null,
    val frontAlife: String,
    val backAlife: String,
) : UIPostModel.Abstract() {

    override fun itemKey() = username + timestamp

    @Composable
    override fun Card(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
        PostPhotoCardCompose(
            profileName = username,
            avatar = avatar,
            timestamp = timestamp,
            photoCardModel = UICloudPicturesModel(frontAlife, backAlife)
        )
    }
}