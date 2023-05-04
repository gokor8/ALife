package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.EmptyCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.screenPagerContainerOf
import com.alife.core.mvi.MVI
import javax.inject.Inject

data class CreateAlifeState @OptIn(ExperimentalFoundationApi::class) @Inject constructor(
    val blockingScreen: ScreenState? = null,
    val pagerState: PagerState = PagerState(0),
    val pagerContainer: ScreenPagerContainer = screenPagerContainerOf(
        PicturePagerItem.InitTakePicture(),
        VideoPagerItem.Sizable()
    ),
    val captureWrapper: BaseCaptureWrapper = EmptyCaptureWrapper(),
    val isAudioEnabled: Boolean = true,
    @IntentModule.IntentAnnotation.Settings
    val settingsIntent: Intent?
) : MVI.State {

    @OptIn(ExperimentalFoundationApi::class)
    fun currentContainerState(): ScreenPagerItem {
        return pagerContainer.getScreenPagerItem(pagerState.currentPage)
    }

    fun tryCopyWithInvert() = currentContainerState().invertCamera(pagerContainer)

    @OptIn(ExperimentalFoundationApi::class)
    fun changeCurrentScreen(screenState: ScreenState): ScreenPagerContainer {
        return pagerContainer.changeScreenPagerItem(pagerState.currentPage, screenState)
    }

    fun copyCurrentScreenPage(captureWrapper: CookedCaptureWrapper): ScreenPagerContainer {
        return currentContainerState().copy(pagerContainer, captureWrapper)
    }
}