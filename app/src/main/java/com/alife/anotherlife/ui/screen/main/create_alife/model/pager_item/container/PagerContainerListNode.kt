package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container

abstract class PagerContainerListNode(val index: Int, val pagerContainerItem: BasePagerContainerItem) {

    class Picture(item: PagerContainerItem.Picture) : PagerContainerListNode(0, item)
    class Video(item: PagerContainerItem.Video) : PagerContainerListNode(1, item)
    class Empty : PagerContainerListNode(2, PagerContainerItem.Empty())
}