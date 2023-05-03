package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo.PicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem

class FakePictureScreenPagerItem(
    private val copyList: MutableList<ScreenPagerItem>
): FakeAbstractScreenPagerItem(copyList), ScreenPagerItem.Picture {

    override val screenState: ScreenState = LoadScreenState()
    override val pagerItem: PicturePagerItem = FakePicturePagerItem()

    override fun copy(picturePagerItem: PicturePagerItem) = copy()

    override fun copy(screenState: ScreenState) = copy()

    fun copy(): ScreenPagerItem.Picture {
        val copyValue = FakePictureScreenPagerItem(copyList)
        copyList.add(copyValue)
        return copyValue
    }

    override fun invertCamera(screenPagerContainer: ScreenPagerContainer): ScreenPagerContainer {
        return screenPagerContainer
    }

    override fun copyContainer(
        container: ScreenPagerContainer,
        screenState: ScreenState
    ): ScreenPagerContainer = container
}