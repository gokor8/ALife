package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model

import com.alife.anotherlife.core.ui.image.ImageExtModel

open class ProfileUIDataModel(
    val name: String,
    val username: String,
    val photo: ImageExtModel,
    val description: String
) {

    fun isEmpty() = name.isEmpty() && username.isEmpty()
}

class EmptyProfileUIDataModel : ProfileUIDataModel("", "", EmptyImageExtModel(), "")