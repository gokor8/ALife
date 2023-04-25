package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.EmptyCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.UselessCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CameraPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.PagerItemList
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.VideoCameraPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleCamera
import com.alife.core.mvi.MVI
import javax.inject.Inject

data class CreateAlifeState @OptIn(ExperimentalFoundationApi::class)
@Inject constructor(
    val screenState: ScreenState = LoadScreenState(),
    val pagerState: PagerState = PagerState(0),
    val pagerItems: PagerItemList = PagerItemList(
        CameraPagerItem.TakePicture(),
        VideoCameraPagerItem.DefaultSizable()
    ),
    val captureWrapper: BaseCaptureWrapper = EmptyCaptureWrapper(),
    @IntentModule.IntentAnnotation.Settings
    val settingsIntent: Intent?
) : MVI.State {

    fun canInvert() = captureWrapper !is UselessCaptureWrapper && screenState is InvertibleCamera
            && pagerItems.getCameraItem() is CameraPagerItem.TakePicture

    @OptIn(ExperimentalFoundationApi::class)
    fun copyReplaceCamera(cameraPagerItem: CameraPagerItem): CreateAlifeState {
        return copy(pagerItems = pagerItems.replaceCamera(cameraPagerItem))
    }
}