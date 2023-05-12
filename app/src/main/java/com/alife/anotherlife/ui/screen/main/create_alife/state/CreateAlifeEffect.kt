package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.alife.anotherlife.R
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.core.ui.dialog.AbstractAlertDialog
import com.alife.anotherlife.core.ui.dialog.DefaultDialog
import com.alife.anotherlife.core.ui.text.TextWrapper
import com.alife.core.mvi.MVI

interface CreateAlifeEffect : MVI.Effect {

    class CreateAlifeFinish : CreateAlifeEffect, NavigationWrapper.Back()

    class GoBack : CreateAlifeEffect, NavigationWrapper.Back()

    interface BaseSnackBarError : CreateAlifeEffect {
        suspend fun showSnackBar(snackBarVisibility: MutableState<BaseSnackBarError>) = Unit

        @Composable
        fun ShowSnackBar(modifier: Modifier) = Unit
    }

    class PictureDialogErrorEffect : AbstractDialogErrorEffect(
        R.string.camera_snackbar_photo_error,
        R.string.camera_snackbar_camera_description_error
    )

    class VideoDialogErrorEffect : AbstractDialogErrorEffect(
        R.string.camera_snackbar_video_error,
        R.string.camera_snackbar_camera_description_error
    )

    @OptIn(ExperimentalFoundationApi::class)
    class VideoToMainPage(
        private val pagerState: PagerState,
        private val videoPageIndex: Int
    ) : CreateAlifeEffect {
        suspend fun scrollToVideoPage() {
            pagerState.animateScrollToPage(videoPageIndex)
        }
    }
}