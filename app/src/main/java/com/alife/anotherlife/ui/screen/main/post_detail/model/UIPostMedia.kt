package com.alife.anotherlife.ui.screen.main.post_detail.model

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.common.MediaItem
import com.alife.anotherlife.core.composable.alife_card.ALifeCardCompose
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.ExoPlayerSetupState
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.UICloudPicturesModel

interface UIPostMedia {

    @Composable
    fun MediaContent(modifier: Modifier)


    class Empty : UIPostMedia {
        @Composable
        override fun MediaContent(modifier: Modifier) = Unit
    }

    class Photos(
        private val firstPhotoLink: String,
        private val secondPhotoLink: String
    ) : UIPostMedia {

        @Composable
        override fun MediaContent(modifier: Modifier) {
            ALifeCardCompose(
                uiAlifeCardModel = UICloudPicturesModel(
                    firstPhotoLink,
                    secondPhotoLink
                ),
                modifier = Modifier
            )
        }
    }

    class Video(private val link: String) : UIPostMedia {

        @Composable
        override fun MediaContent(modifier: Modifier) {
            VideoPlayerComposable(
                ExoPlayerSetupState.NeedPlayItem(MediaItem.fromUri(Uri.parse(link))),
                true,
                modifier
            )
        }
    }
}