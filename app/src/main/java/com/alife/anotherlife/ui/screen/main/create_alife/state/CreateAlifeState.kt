package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.EmptyCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.NotScrollablePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Picture
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Video
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.LoadPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.LoadVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.timer.BaseTimerUnit
import com.alife.core.mvi.MVI
import javax.inject.Inject

data class CreateAlifeState @OptIn(ExperimentalFoundationApi::class) @Inject constructor(
    val blockingScreen: ScreenState? = null,
    val pagerState: PagerState = PagerState(0),
    val captureWrapper: BaseCaptureWrapper = EmptyCaptureWrapper(),
    val isAudioEnabled: Boolean = false, // Todo video builder
    val timerUnit: BaseTimerUnit = BaseTimerUnit.Init(),
    val pagerContainer: ScreenPagerContainer = ScreenPagerContainer(
        Picture(LoadPictureScreenState(), PicturePagerItem.InitTakePicture()),
        Video(LoadVideoScreenState(), VideoPagerItem.InitSizable()) // TODO InitSizable
    ),
    @IntentModule.IntentAnnotation.Settings
    val settingsIntent: Intent?
) : MVI.State {

    @OptIn(ExperimentalFoundationApi::class)
    fun currentContainerState(): ScreenPagerItem<*> {
        return pagerContainer.getScreenPagerItem(pagerState.currentPage)
    }

    @OptIn(ExperimentalFoundationApi::class)
    fun canPagerItemScroll() = pagerContainer.canCurrentScroll(pagerState.currentPage)

    fun tryCopyWithInvert() = currentContainerState().invertCamera(pagerContainer)

    @OptIn(ExperimentalFoundationApi::class)
    fun changeCurrentScreen(screenState: ScreenState): ScreenPagerContainer {
        return pagerContainer.changeScreenPagerItem(pagerState.currentPage, screenState)
    }

    fun copyCurrentScreenPage(captureWrapper: CookedCaptureWrapper): ScreenPagerContainer {
        return currentContainerState().copy(pagerContainer, captureWrapper)
    }
}