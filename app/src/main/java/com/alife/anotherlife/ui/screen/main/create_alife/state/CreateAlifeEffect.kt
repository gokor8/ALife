package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Stable
import com.alife.anotherlife.R
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.navigation.FinishPictureNavigator
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.navigation.FinishVideoNavigator
import com.alife.core.mvi.MVI

interface CreateAlifeEffect : MVI.Effect {

    class CreateAlifePhotoFinish : CreateAlifeEffect, NavigationWrapper.Forward(FinishPictureNavigator())
    class CreateAlifeVideoFinish : CreateAlifeEffect, NavigationWrapper.Forward(FinishVideoNavigator())

    class GoBack : CreateAlifeEffect, NavigationWrapper.Back()

    class SnackVideoError : BaseSnackBarEffect.Abstract(R.string.camera_snackbar_video_error), CreateAlifeEffect

    class SnackPictureError : BaseSnackBarEffect.Abstract(R.string.camera_snackbar_photo_error), CreateAlifeEffect

    class EmptySnackError : BaseSnackBarEffect

    class EmptyDialogError : BaseDialogErrorEffect

    @Stable
    class AudioDialogError : AbstractDialogErrorEffect(
        R.string.dialog_audio_title,
        R.string.dialog_audio_description
    )

    class VideoToMainPage(
        private val videoPageIndex: Int
    ) : CreateAlifeEffect {
        @OptIn(ExperimentalFoundationApi::class)
        suspend fun scrollToVideoPage(pagerState: PagerState) {
            pagerState.animateScrollToPage(videoPageIndex)
        }
    }
}