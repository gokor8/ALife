package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.UselessCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video.VideoPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.ErrorCameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.CameraVideoScreenState

abstract class AbstractScreenPagerItem(
    override val screenState: ScreenState,
    override val pagerItem: CreateAlifePagerItem
) : ScreenPagerItem {

    override fun invertCamera(screenPagerContainer: ScreenPagerContainer): ScreenPagerContainer {
        return if (canInvert())
            invertScreenState(screenPagerContainer, screenState as InvertibleScreenState)
        else screenPagerContainer
    }

    abstract fun invertScreenState(
        container: ScreenPagerContainer,
        screenState: InvertibleScreenState
    ): ScreenPagerContainer

    override fun copyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ) = if (isScreenStateFit(screenState))
        safeCopyContainer(container, screenState)
    else
        container

    abstract fun isScreenStateFit(screenState: ScreenState): Boolean

    abstract fun safeCopyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ): ScreenPagerContainer


    class Picture(
        screenState: ScreenState,
        override val pagerItem: PicturePagerItem
    ) : ScreenPagerItem.Picture, AbstractScreenPagerItem(screenState, pagerItem) {
        override fun invertScreenState(
            container: ScreenPagerContainer,
            screenState: InvertibleScreenState
        ): ScreenPagerContainer {
            return container.copy(picture = Picture(screenState.copyInvertCamera(), pagerItem))
        }

        override fun isScreenStateFit(screenState: ScreenState): Boolean {
            return screenState !is CameraVideoScreenState
        }

        override fun safeCopyContainer(
            container: ScreenPagerContainer,
            screenState: ScreenState
        ) = container.copy(picture = copy(screenState))

        override fun copy(
            container: ScreenPagerContainer,
            captureWrapper: BaseCaptureWrapper
        ): ScreenPagerContainer {
            // TODO вынести в маппер
            val picture = if(captureWrapper !is UselessCaptureWrapper) {
                copy(PicturePagerItem.DefaultTakePicture())
            } else {
                copy(screenState = ErrorCameraScreenState())
            }
            return container.copy(picture = picture)
        }

        override fun copy(picturePagerItem: PicturePagerItem): ScreenPagerItem.Picture {
            return Picture(screenState, picturePagerItem)
        }

        override fun copy(screenState: ScreenState): ScreenPagerItem.Picture {
            return Picture(screenState, pagerItem)
        }
    }

    class Video(
        screenState: ScreenState,
        override val pagerItem: VideoPagerItem
    ) : ScreenPagerItem.Video, AbstractScreenPagerItem(screenState, pagerItem) {
        override fun invertScreenState(
            container: ScreenPagerContainer,
            screenState: InvertibleScreenState
        ): ScreenPagerContainer {
            return container.copy(video = Video(screenState.copyInvertCamera(), pagerItem))
        }

        override fun isScreenStateFit(screenState: ScreenState): Boolean {
            return screenState !is CameraPictureScreenState
        }

        override fun safeCopyContainer(
            container: ScreenPagerContainer,
            screenState: ScreenState
        ) = container.copy(video = Video(screenState, pagerItem))

        override fun copy(
            container: ScreenPagerContainer,
            captureWrapper: BaseCaptureWrapper
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

    class Empty : ScreenPagerItem {

        override val screenState: ScreenState = ScreenState.Empty()
        override val pagerItem: CreateAlifePagerItem = EmptyAlifePagerItem()

        override fun invertCamera(screenPagerContainer: ScreenPagerContainer) = screenPagerContainer
        override fun copy(
            container: ScreenPagerContainer,
            captureWrapper: BaseCaptureWrapper
        ): ScreenPagerContainer = container

        override fun copyContainer(
            container: ScreenPagerContainer,
            screenState: ScreenState
        ): ScreenPagerContainer = container
    }
}