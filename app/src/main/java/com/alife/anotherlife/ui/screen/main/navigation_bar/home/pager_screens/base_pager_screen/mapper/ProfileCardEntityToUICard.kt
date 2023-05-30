package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPhotosPostModel
import com.alife.core.mapper.Mapper
import com.alife.domain.main.home.child.ProfileCardEntity
import javax.inject.Inject

class ProfileCardEntityToUICard @Inject constructor() : Mapper<ProfileCardEntity, UIPostModel> {
    override fun map(inputModel: ProfileCardEntity): UIPostModel {
        return with(inputModel) {
            val randomPictureRequest = "https://api.api-ninjas.com/v1/randomimage?category=nature"
            UIPhotosPostModel(
                // TODO add timestamp mapper
                username,
                timestamp.toString(),
                randomPictureRequest,//avatar,
                randomPictureRequest,//frontAlife,
                randomPictureRequest//backAlife
            )
        }
    }
}