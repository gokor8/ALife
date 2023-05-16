package com.alife.anotherlife.ui.screen.main.create_alife.state

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.ui.screen.main.create_alife.model.audio.AudioModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.audio.BaseAudioModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Picture
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Video
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.LoadPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.LoadVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.timer.BaseTimerUnit

data class CreateAlifeState @OptIn(ExperimentalFoundationApi::class) constructor(
    override val lceModel: LCEModel = LCEContent,
    val pagerState: PagerState = PagerState(0),
    val audioEnabledModel: BaseAudioModel = AudioModel(),
    val timerUnit: BaseTimerUnit = BaseTimerUnit.Init(),
    val pagerContainer: ScreenPagerContainer = ScreenPagerContainer(
        Picture(LoadPictureScreenState(), PicturePagerItem.InitTakePicture()),
        Video(LoadVideoScreenState(), VideoPagerItem.InitSizable())
    ),
    @IntentModule.IntentAnnotation.Settings
    val settingsIntent: Intent
) : StateLCE {

    @OptIn(ExperimentalFoundationApi::class)
    fun currentScreenPager() = pagerContainer.getScreenPagerItem(pagerState.currentPage)

    @OptIn(ExperimentalFoundationApi::class)
    fun canPagerItemScroll() = pagerContainer.canCurrentScroll(pagerState.currentPage)

    fun tryCopyWithInvert() = currentScreenPager().invertCamera(pagerContainer)
}