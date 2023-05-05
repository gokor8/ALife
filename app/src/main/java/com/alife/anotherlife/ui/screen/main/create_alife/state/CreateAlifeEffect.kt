package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.core.mvi.MVI
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

interface CreateAlifeEffect : MVI.Effect {

    class CreateAlifeFinish : CreateAlifeEffect, NavigationWrapper.Back()

    class GoBack : CreateAlifeEffect, NavigationWrapper.Back()

    @OptIn(ExperimentalFoundationApi::class)
    class VideoToMainPage(
        private val pagerState: PagerState,
        private val videoPageIndex: Int
    ) : CreateAlifeEffect {
        suspend fun scrollToVideoPage() {
            pagerState.animateScrollToPage(videoPageIndex)
        }
    }

    class RequestAudioPermission @OptIn(ExperimentalPermissionsApi::class) constructor(
        private val audioPermission: PermissionState
    ) : CreateAlifeEffect {
        @OptIn(ExperimentalPermissionsApi::class)
        fun requestPermission() {
            audioPermission.launchPermissionRequest()
        }
    }
}