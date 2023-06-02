package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer

class UIPostsModelList(
    uiPostModels: List<UIBasePostContainer>
) : ArrayList<UIBasePostContainer>(uiPostModels) {
    constructor(vararg uiPostModel: UIBasePostContainer) : this(uiPostModel.toList())
}