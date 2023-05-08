package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.AbstractScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.BaseInvertVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.BaseVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.VideoCaptureCallback

class Video(
    screenState: BaseVideoScreenState,
    override val pagerItem: VideoPagerItem
) : AbstractScreenPagerItem<BaseVideoScreenState, VideoPagerItem>(screenState, pagerItem),
    ScreenPagerItem.Video {

    override fun invertCamera(container: ScreenPagerContainer): ScreenPagerContainer {
        return if(screenState is BaseInvertVideoScreenState && pagerItem is InvertiblePagerItem)
            container.copy(video = Video(screenState.copyInvertCamera(), pagerItem))
        else
            container
    }

    override fun copyContainer(
        container: ScreenPagerContainer,
        screenState: BaseVideoScreenState
    ) = container.copy(video = Video(screenState, pagerItem))

    override fun copyContainer(
        container: ScreenPagerContainer,
        pagerItem: VideoPagerItem
    ) = container.copy(video = Video(screenState, pagerItem))

    override fun onCallback(videoCaptureCallback: VideoCaptureCallback) {
        pagerItem.onCallback(videoCaptureCallback)
    }
}