package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import android.util.Log
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.UIPostsModelList
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.PlzCreatePostContainerUI
import javax.inject.Inject

interface BasePagingKeyMapper {

    fun mapPreviousKey(uiPostsList: UIPostsModelList, page: Int): Int?

    fun mapNextKey(uiPostsList: UIPostsModelList, page: Int): Int?
}

class PagingKeyMapper @Inject constructor() : BasePagingKeyMapper {

    override fun mapPreviousKey(uiPostsList: UIPostsModelList, page: Int): Int? {
        return page.minus(1).takeUnless { page == 1 }.apply {
            Log.d("Key prev", this.toString())
        }
    }

    override fun mapNextKey(uiPostsList: UIPostsModelList, page: Int): Int? {
        return page.plus(1).takeUnless {
            uiPostsList.isEmpty() || uiPostsList.first() is PlzCreatePostContainerUI
        }.apply { Log.d("Key next", this.toString()) }
    }
}