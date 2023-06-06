package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing

import android.net.Uri
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileUIDataModel

interface BaseProfileChangingReducer : BaseVMReducer<ProfileChangingState, ProfileChangingEffect> {

    fun onProfileUIDataModel(profileUIDataModel: ProfileUIDataModel)
    fun onUsername(newUsername: String)
    suspend fun onPhoto(uri: Uri)
    fun onName(newName: String)
    fun onDescription(newDescription: String)

    fun onSave()
    fun onDiscard()
}