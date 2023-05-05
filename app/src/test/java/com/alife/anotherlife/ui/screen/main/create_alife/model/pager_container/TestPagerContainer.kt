package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_container

import com.alife.anotherlife.ui.screen.main.create_alife.model.FakeContainerListAdapterFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.FakePicturePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.FakePictureScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.FakeVideoScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.LoadPictureScreenState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotSame
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class TestPagerContainer {

    private lateinit var pagerContainer: ScreenPagerContainer
    private lateinit var pictureCopyActionList: MutableList<ScreenPagerItem.Picture>
    private lateinit var videoCopyActionList: MutableList<ScreenPagerItem.Video>

    @Before
    fun before() {
        pictureCopyActionList = mutableListOf()

        pagerContainer = ScreenPagerContainer(
            FakePictureScreenPagerItem(pictureCopyActionList),
            FakeVideoScreenPagerItem(videoCopyActionList),
            FakeContainerListAdapterFactory()
        )
    }

    @Test
    fun `get pager items`() {
        val actual = pagerContainer.getPagerItems()

        val expectedCount = 1

        assertEquals(expectedCount, actual.size)
        assertTrue(actual.first() is EmptyAlifePagerItem)
    }

    @Test
    fun `changePicture screenState`() {
        val actual = pagerContainer.changePicture(LoadPictureScreenState())

        val expectedCount = 1

        assertEquals(expectedCount, pictureCopyActionList.size)
        assertNotSame(pagerContainer, actual)
        assertNotSame(pagerContainer.picture, actual.picture)
        assertEquals(pagerContainer.video, actual.video)
    }

    @Test
    fun `changePicture pagerItem`() {
        val actual = pagerContainer.changePicture(FakePicturePagerItem())

        val expectedCount = 1

        assertEquals(expectedCount, pictureCopyActionList.size)
        assertNotSame(pagerContainer, actual)
        assertNotSame(pagerContainer.picture, actual.picture)
        assertEquals(pagerContainer.video, actual.video)
    }
}