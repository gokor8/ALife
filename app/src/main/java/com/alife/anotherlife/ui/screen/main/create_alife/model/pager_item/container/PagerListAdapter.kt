package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.EmptyAlifePagerItem

interface PagerListAdapter : VideoIndex {

    fun createPagerItemsList(): List<CreateAlifePagerItem>

    fun getItemByIndex(index: Int): BasePagerContainerItem

    fun size(): Int


    class Default(
        private val picture: PagerContainerItem.Picture,
        private val video: PagerContainerItem.Video
    ) : PagerListAdapter {

        private val videoNode = PagerContainerListNode.Video(video)

        private val list = listOf(
            PagerContainerListNode.Picture(picture),
            videoNode,
            PagerContainerListNode.Empty()
        )

        override fun getVideoIndex(): Int = videoNode.index

        override fun size() = list.size

        override fun createPagerItemsList() = listOf(picture.pagerItem, video.pagerItem, EmptyAlifePagerItem())

        override fun getItemByIndex(index: Int): BasePagerContainerItem {
            return list.find { it.index == index }?.pagerContainerItem ?: PagerContainerItem.Empty()
        }
    }
}