package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState

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
}