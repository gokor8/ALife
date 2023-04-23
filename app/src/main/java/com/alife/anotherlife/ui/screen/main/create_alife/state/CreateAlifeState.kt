package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.EmptyCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.UselessCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.PagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.PagerContainerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pagerContainerOf
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.core.mvi.MVI
import javax.inject.Inject

data class CreateAlifeState @OptIn(ExperimentalFoundationApi::class) @Inject constructor(
    val pagerState: PagerState = PagerState(0),
    val pagerItems: PagerContainer = pagerContainerOf(
        PicturePagerItem.TakePicture(),
        VideoPagerItem.Sizable()
    ),
    val captureWrapper: BaseCaptureWrapper = EmptyCaptureWrapper(),
    val isAudioEnabled: Boolean = true,
    @IntentModule.IntentAnnotation.Settings
    val settingsIntent: Intent?
) : MVI.State {

    @OptIn(ExperimentalFoundationApi::class)
    fun currentScreenState() = pagerItems.currentScreenState(pagerState.currentPage)

    @OptIn(ExperimentalFoundationApi::class)
    fun canInvert() = captureWrapper !is UselessCaptureWrapper
            && pagerItems.canInvertCamera(pagerState.currentPage)

    @OptIn(ExperimentalFoundationApi::class)
    fun tryCopyWithInvert() = pagerItems.tryInvertCamera(pagerState.currentPage)

    @OptIn(ExperimentalFoundationApi::class)
    fun copyReplaceCamera(picturePagerItem: PicturePagerItem): CreateAlifeState {
        return copy(pagerItems = pagerItems.replacePicture(picturePagerItem))
    }

    @OptIn(ExperimentalFoundationApi::class)
    fun copyPagerItem(pictureItem: PagerContainerItem.Picture): CreateAlifeState {
        return copy(pagerItems = pagerItems.copy(picture = pictureItem))
    }

    @OptIn(ExperimentalFoundationApi::class)
    fun copyPagerItem(videoItem: PagerContainerItem.Video): CreateAlifeState {
        return copy(pagerItems = pagerItems.copy(video = videoItem))
    }
}