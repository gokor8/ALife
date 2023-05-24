package com.alife.anotherlife.ui.screen.main.create_alife.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.BaseVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.LoadVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.VideoCaptureCallback

class FakeVideoScreenPagerItem(
    copyList: MutableList<ScreenPagerItem.Video>,
    override val screenState: BaseVideoScreenState = LoadVideoScreenState()
): FakeAbstractScreenPagerItem<ScreenPagerItem.Video, BaseVideoScreenState, VideoPagerItem>(copyList), ScreenPagerItem.Video {

    override fun onCallback(videoCaptureCallback: VideoCaptureCallback) {
        TODO("Not yet implemented")
    }

    override fun canSwitchAudio(): Boolean {
        TODO("Not yet implemented")
    }

    override val pagerItem = FakeVideoPagerItem()

    override fun invertCamera(container: ScreenPagerContainer) = container.copy(video = copy())
    override fun copyContainer(
        container: ScreenPagerContainer,
        screenState: BaseVideoScreenState
    ) = container.copy(video = copy())

    override fun copyContainer(
        container: ScreenPagerContainer,
        pagerItem: VideoPagerItem
    ) = container.copy(video = copy())

    override fun copyThis() = this
}

// Fake Realization
class FakeVideoPagerItem : VideoPagerItem {

    @Composable
    override fun Content(size: Dp, viewModel: CreateAlifeViewModel) {}
}