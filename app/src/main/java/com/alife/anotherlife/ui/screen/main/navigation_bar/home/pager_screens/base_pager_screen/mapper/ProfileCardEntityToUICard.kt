package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIProfileCardModel
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.ProfileCardEntity
import javax.inject.Inject

class ProfileCardEntityToUICard @Inject constructor() : Mapper<ProfileCardEntity, UICardModel> {
    override fun map(inputModel: ProfileCardEntity): UICardModel {
        return with(inputModel) {
            UIProfileCardModel(
                // TODO add timestamp mapper
                username, frontAlife, backAlife, timestamp.toString(), avatar
            )
        }
    }
}