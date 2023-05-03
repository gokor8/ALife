package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.list_adapter

import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerItem

interface ContainerListAdapterFactory {

    fun create(
        picture: ScreenPagerItem.Picture,
        video: ScreenPagerItem.Video
    ) : ContainerListAdapter


    class Default : ContainerListAdapterFactory {

        override fun create(
            picture: ScreenPagerItem.Picture,
            video: ScreenPagerItem.Video
        ) = ContainerListAdapter.Default(picture, video)
    }
}