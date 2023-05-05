package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base

import com.alife.anotherlife.core.FakeUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeReducerBase
import com.alife.anotherlife.ui.screen.main.create_alife.model.FakePictureScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.FakeVideoScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import org.junit.Before

class TestCreateAlifeReducerBase_ChangeCamera {

    lateinit var copyListPicture: MutableList<ScreenPagerItem.Picture>
    lateinit var copyListVideo: MutableList<ScreenPagerItem.Video>

    lateinit var uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
    lateinit var createAlifeReducerBase: CreateAlifeReducerBase

    @Before
    fun before() {
        copyListPicture = mutableListOf()
        copyListVideo = mutableListOf()

        uiStore = FakeUIStore(
            CreateAlifeState(
                pagerContainer = ScreenPagerContainer(
                    FakePictureScreenPagerItem(copyListPicture),
                    FakeVideoScreenPagerItem(copyListVideo)
                ),
                settingsIntent = null
            )
        )
    }
}