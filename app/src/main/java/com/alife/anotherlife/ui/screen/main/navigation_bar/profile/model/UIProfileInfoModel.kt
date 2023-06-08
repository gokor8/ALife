package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model

import com.alife.anotherlife.core.ui.image.ImageExtModel

open class UIProfileInfoModel(
    val username: String,
    val photo: ImageExtModel,
    val name: String,
    val description: String
)

class EmptyUIProfileInfoModel : UIProfileInfoModel("", EmptyImageExtModel(), "", "")