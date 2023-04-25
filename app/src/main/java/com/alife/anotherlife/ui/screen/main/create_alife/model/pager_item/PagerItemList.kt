package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

class PagerItemList(
    private vararg val init: CreateAlifePagerItem
) : ArrayList<CreateAlifePagerItem>(init.toMutableList().apply { add(EmptyAlifePagerItem()) }) {

    val initList
        get() = PagerItemList(*init)

    fun replaceCamera(cameraPagerItem: CameraPagerItem): PagerItemList {
        return PagerItemList(cameraPagerItem, getVideoItem())
    }

    fun replaceVideo(videoCameraPagerItem: VideoCameraPagerItem): PagerItemList {
        return PagerItemList(getCameraItem(), videoCameraPagerItem)
    }

    fun getCameraItem(): CameraPagerItem = first() as CameraPagerItem
    fun getVideoItem(): VideoCameraPagerItem = this[1] as VideoCameraPagerItem

    fun getVideoItemIndex(): Int = lastIndex - 1
}