package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.alife.anotherlife.R
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.core.mvi.MVI

interface CreateAlifeEffect : MVI.Effect {

    class CreateAlifeFinish : CreateAlifeEffect, NavigationWrapper.Back()

    class GoBack : CreateAlifeEffect, NavigationWrapper.Back()

    class SnackVideoError : BaseSnackBarEffect.Abstract(R.string.camera_snackbar_video_error)

    class SnackPictureError : BaseSnackBarEffect.Abstract(R.string.camera_snackbar_photo_error)

    class DefaultSnackError(@StringRes text: Int) : BaseSnackBarEffect.Abstract(text)

    class EmptySnackError : BaseSnackBarEffect

    class PictureDialogErrorEffect : AbstractDialogErrorEffect(
        R.string.camera_snackbar_photo_error,
        R.string.camera_snackbar_camera_description_error
    )

    class AudioDialogErrorEffect : AbstractDialogErrorEffect(
        R.string.dialog_audio_title,
        R.string.dialog_audio_description
    )

    class VideoDialogErrorEffect : AbstractDialogErrorEffect(
        R.string.camera_snackbar_video_error,
        R.string.camera_snackbar_camera_description_error
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