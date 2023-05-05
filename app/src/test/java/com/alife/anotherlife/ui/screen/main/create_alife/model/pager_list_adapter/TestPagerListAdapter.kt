package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_list_adapter

import com.alife.anotherlife.ui.screen.main.create_alife.model.FakePictureScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.FakeVideoScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.AbstractScreenPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.list_adapter.ContainerListAdapter
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.pager_item.Empty
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class TestDefaultContainerListAdapter {

    private val containerListAdapter = ContainerListAdapter.Default(
        FakePictureScreenPagerItem(mutableListOf()),
        FakeVideoScreenPagerItem(mutableListOf())
    )

    @Test
    fun `get video node index`() {
        val actual = containerListAdapter.getVideoIndex()
        val expected = 1

        assertEquals(expected, actual)
    }

    @Test
    fun `get item by correct index 0`() {
        val index = 0

        val actual = containerListAdapter.getItemByIndex(index)
        assertTrue(actual is FakePictureScreenPagerItem)
    }

    @Test
    fun `get item by correct index 1`() {
        val index = 1

        val actual = containerListAdapter.getItemByIndex(index)
        assertTrue(actual is FakeVideoScreenPagerItem)
    }

    @Test
    fun `get item by correct index 2`() {
        val index = 2

        val actual = containerListAdapter.getItemByIndex(index)
        assertTrue(actual is Empty)
    }

    @Test
    fun `get item by incorrect index 3`() {
        val index = 3

        val actual = containerListAdapter.getItemByIndex(index)
        assertTrue(actual is Empty)
    }
}