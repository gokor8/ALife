package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.AbstractScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.model.VideoCaptureCallback

class Video(
    screenState: ScreenState,
    override val pagerItem: VideoPagerItem
) : ScreenPagerItem.Video, AbstractScreenPagerItem<VideoPagerItem>(screenState, pagerItem) {
    override fun invertScreenState(
        container: ScreenPagerContainer,
        screenState: InvertibleScreenState
    ): ScreenPagerContainer {
        return container.copy(video = Video(screenState.copyInvertCamera(), pagerItem))
    }

    override fun isCookedVideoCapture(): Boolean {
        return pagerItem.isCookedVideoCapture()
    }

    override fun isScreenStateFit(screenState: ScreenState): Boolean {
        return screenState !is CameraPictureScreenState
    }

    override fun safeCopyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ) = container.copy(video = Video(screenState, pagerItem))

    override fun copyContainer(
        container: ScreenPagerContainer,
        pagerItem: VideoPagerItem
    ) = container.copy(video = Video(screenState, pagerItem))

    override fun onCallback(videoCaptureCallback: VideoCaptureCallback) {
        pagerItem.onCallback(videoCaptureCallback)
    }

    override fun copy(
        container: ScreenPagerContainer,
        captureWrapper: CookedCaptureWrapper
    ): ScreenPagerContainer {
        // TODO вынести в маппер
//            val video = if(captureWrapper !is UselessCaptureWrapper) {
//                Video(screenState, VideoPagerItem.DefaultTakePicture())
//            } else {
//                copy(screenState = ErrorCameraScreenState())
//            }
        return container.copy(video = this)
    }
}