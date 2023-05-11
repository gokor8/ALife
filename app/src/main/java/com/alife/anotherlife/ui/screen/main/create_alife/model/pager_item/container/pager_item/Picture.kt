package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.AbstractScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseInvertPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState

class Picture(
    screenState: BasePictureScreenState,
    override val pagerItem: PicturePagerItem
) : AbstractScreenPagerItem<BasePictureScreenState, PicturePagerItem>(screenState, pagerItem),
    ScreenPagerItem.Picture {

    override fun invertCamera(container: ScreenPagerContainer): ScreenPagerContainer {
        if(screenState !is BaseInvertPictureScreenState) return container

        val newPicture = if(pagerItem is InvertiblePagerItem)
            Picture(screenState.copyInvertCamera(), pagerItem)
        else
            this

        return container.copy(picture = newPicture)
    }

    override fun copyContainer(
        container: ScreenPagerContainer,
        pagerItem: PicturePagerItem
    ) = container.copy(picture = copy(pagerItem))

    override fun copyContainer(
        container: ScreenPagerContainer,
        screenState: BasePictureScreenState
    ) = container.copy(picture = copy(screenState))

    override fun copy(picturePagerItem: PicturePagerItem): ScreenPagerItem.Picture {
        return Picture(screenState, picturePagerItem)
    }

    override fun copy(screenState: BasePictureScreenState): ScreenPagerItem.Picture {
        return Picture(screenState, pagerItem)
    }
}