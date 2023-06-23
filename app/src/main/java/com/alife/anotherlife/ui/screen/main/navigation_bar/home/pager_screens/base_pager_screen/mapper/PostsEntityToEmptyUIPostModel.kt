package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.PlzCreatePostContainerUI
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer
import com.alife.core.mapper.Mapper
import java.lang.IllegalStateException
import javax.inject.Inject

class NoPostsWithAvailableTodayPostException : IllegalStateException()

interface BasePostsEntityToEmptyUIPostModel : Mapper<Boolean, UIBasePostContainer>

class PostsEntityToEmptyUIPostModel @Inject constructor() : BasePostsEntityToEmptyUIPostModel {
    override fun map(isHavePostToday: Boolean): UIBasePostContainer {
        if(isHavePostToday) throw NoPostsWithAvailableTodayPostException()

        return PlzCreatePostContainerUI()
    }
}