package com.alife.anotherlife.ui.screen.main.create_alife.model

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.PagerContainerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.PagerContainerListNode
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.PagerListAdapter
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class TestPagerListAdapter {

    private val picture =
        PagerContainerItem.Picture(FakePicturePagerItem(), LoadScreenState())
    private val video =
        PagerContainerItem.Video(FakeVideoPagerItem(), LoadScreenState())

    private val pagerAdapter = PagerListAdapter.Default(picture, video)

    @Test
    fun `get video node index`() {
        val actual = pagerAdapter.getVideoIndex()
        val expected = 1

        assertEquals(expected, actual)
    }

    @Test
    fun `get item by correct index 0`() {
        val index = 0

        val actual = pagerAdapter.getItemByIndex(index)
        assertTrue(actual is PagerContainerItem.Picture)
    }

    @Test
    fun `get item by correct index 1`() {
        val index = 1

        val actual = pagerAdapter.getItemByIndex(index)
        assertTrue(actual is PagerContainerItem.Video)
    }

    @Test
    fun `get item by correct index 2`() {
        val index = 2

        val actual = pagerAdapter.getItemByIndex(index)
        assertTrue(actual is PagerContainerItem.Empty)
    }

    @Test
    fun `get item by incorrect index 3`() {
        val index = 3

        val actual = pagerAdapter.getItemByIndex(index)
        assertTrue(actual is PagerContainerItem.Empty)
    }
}