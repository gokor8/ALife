package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model

import com.alife.anotherlife.core.ui.image.ImageExtModel

open class UIProfileInfoModel(
    val username: String,
    val photo: ImageExtModel,
    val name: String,
    val description: String
) {
    fun copy(newPhoto: ImageExtModel) = UIProfileInfoModel(username, newPhoto, name, description)

    fun copyLoadPhoto() = copy(ImageExtModel.Loading())
}

class InitUIProfileInfoModel : UIProfileInfoModel("", ImageExtModel.Loading(), "", "")