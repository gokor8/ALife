package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.alife.anotherlife.R
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.core.mvi.MVI
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

interface CreateAlifeEffect : MVI.Effect {

    class CreateAlifeFinish : CreateAlifeEffect, NavigationWrapper.Back()

    class GoBack : CreateAlifeEffect, NavigationWrapper.Back()

    abstract class SnackBarError(
        @StringRes private val text: Int
    ) : CreateAlifeEffect {
        fun showSnackbar() {

        }
    }

    class SnackVideoError : SnackBarError(text = R.string.camera_snackbar_video_error)

    class DefaultSnackError(
        @StringRes private val text: Int
    ) : SnackBarError(text)

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