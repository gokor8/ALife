package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState

abstract class AbstractScreenPagerItem<P : CreateAlifePagerItem>(
    override val screenState: ScreenState,
    override val pagerItem: P
) : ScreenPagerItem<P> {

    override fun invertCamera(container: ScreenPagerContainer): ScreenPagerContainer {
        return if (canInvert())
            invertScreenState(container, screenState as InvertibleScreenState)
        else container
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
}