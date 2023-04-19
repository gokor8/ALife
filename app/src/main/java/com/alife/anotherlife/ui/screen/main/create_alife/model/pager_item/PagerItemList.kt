package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

class PagerItemList(
    private vararg val init: CreateAlifePagerItem
) : ArrayList<CreateAlifePagerItem>(init.asList()) {

    val initList
        get() = PagerItemList(*init)

    fun getCameraItem(): CameraPagerItem = first() as CameraPagerItem

    fun replaceCamera(cameraPagerItem: CameraPagerItem): PagerItemList {
        return PagerItemList(cameraPagerItem, last())
    }

    fun replaceVideo(videoCameraPagerItem: VideoCameraPagerItem): PagerItemList {
        return PagerItemList(first(), videoCameraPagerItem)
    }
}