package com.alife.anotherlife.ui.screen.main.create_alife.screen_pager.list_adapter

import com.alife.anotherlife.ui.screen.main.create_alife.screen_pager.ScreenPagerItem

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