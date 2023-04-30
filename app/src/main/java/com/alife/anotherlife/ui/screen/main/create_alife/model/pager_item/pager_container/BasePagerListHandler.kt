package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.pager_container

interface BasePagerListHandler {
    val pictureIndex: Int
    val videoIndex: Int

    fun createList(
        picture: PagerListItem.Picture,
        video: PagerListItem.Video
    ): List<BasePagerListItem>


    class Default : BasePagerListHandler {
        override val pictureIndex = 0
        override val videoIndex = 1

        override fun createList(
            picture: PagerListItem.Picture,
            video: PagerListItem.Video
        ) = listOf(picture, video, PagerListItem.Empty())
    }
}