package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model

class UICardModelList(
    uiPostModels: List<UIPostModel>
) : ArrayList<UIPostModel>(uiPostModels) {

    constructor(vararg uiPostModel: UIPostModel) : this(uiPostModel.toList())


    fun needLoadCards(): Boolean = size <= 1 && first() !is UIProfilePostModel
}