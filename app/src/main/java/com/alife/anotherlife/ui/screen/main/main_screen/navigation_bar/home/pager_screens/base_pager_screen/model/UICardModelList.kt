package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model

class UICardModelList(
    uiCardModels: List<UICardModel>
) : ArrayList<UICardModel>(uiCardModels) {

    constructor(vararg uiCardModel: UICardModel) : this(uiCardModel.toList())


    fun needLoadCards(): Boolean = size <= 1 && first() !is UIProfileCardModel
}