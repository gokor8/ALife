package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state

import com.alife.anotherlife.core.ui.image.ImageExtModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel
import com.alife.core.mvi.MVI

data class ProfileChangingState(val profileInfo: UIProfileInfoModel) : MVI.State {

    fun copyUsername(newUsername: String): UIProfileInfoModel = with(profileInfo) {
        return UIProfileInfoModel(newUsername, photo, name, description)
    }

    fun copyPhoto(newPhoto: ImageExtModel): UIProfileInfoModel = with(profileInfo) {
        return UIProfileInfoModel(username, newPhoto, name, description)
    }

    fun copyName(newName: String): UIProfileInfoModel = with(profileInfo) {
        return UIProfileInfoModel(username, photo, newName, description)
    }

    fun copyDescription(newDescription: String): UIProfileInfoModel = with(profileInfo) {
        return UIProfileInfoModel(username, photo, name, newDescription)
    }
}