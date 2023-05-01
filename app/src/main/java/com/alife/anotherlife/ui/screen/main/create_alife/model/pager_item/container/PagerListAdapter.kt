package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

interface PagerListAdapter : VideoIndex {

    fun getItemByIndex(index: Int): BasePagerContainerItem

    fun size(): Int


    class Default(
        picture: PagerContainerItem.Picture,
        video: PagerContainerItem.Video
    ) : PagerListAdapter {

        private val videoNode = PagerContainerListNode.Video(video)

        private val list = listOf(
            PagerContainerListNode.Picture(picture),
            videoNode,
            PagerContainerListNode.Empty()
        )

        override fun getVideoIndex(): Int = videoNode.index

        override fun size() = list.size

        override fun getItemByIndex(index: Int): BasePagerContainerItem {
            return list.find { it.index == index }?.pagerContainerItem ?: PagerContainerItem.Empty()
        }
    }
}