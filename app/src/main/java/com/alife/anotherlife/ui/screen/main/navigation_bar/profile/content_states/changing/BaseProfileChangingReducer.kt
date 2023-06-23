package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing

import android.net.Uri
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileEffect

interface BaseProfileChangingReducer : BaseVMReducer<ProfileChangingState, ProfileEffect> {

    suspend fun onProfileUIDataModel(profileInfo: UIProfileInfoModel)
    fun onUsername(newUsername: String)
    suspend fun onPhoto(uri: Uri)
    fun onName(newName: String)
    fun onDescription(newDescription: String)

    suspend fun onSave()
    fun onDiscard()
}