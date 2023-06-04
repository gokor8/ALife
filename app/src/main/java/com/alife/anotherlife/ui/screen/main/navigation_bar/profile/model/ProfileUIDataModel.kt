package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model

open class ProfileUIDataModel(
    val name: String,
    val username: String,
    val photo: String,
    val description: String
) {

    fun isEmpty() = name.isEmpty() && username.isEmpty() && photo.isEmpty()
}

class EmptyProfileUIDataModel: ProfileUIDataModel("", "", "", "")