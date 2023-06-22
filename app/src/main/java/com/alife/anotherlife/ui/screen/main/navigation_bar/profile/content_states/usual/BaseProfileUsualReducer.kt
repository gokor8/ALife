package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel

interface BaseProfileUsualReducer : BaseVMReducer<ProfileUsualState, ProfileUsualEffect> {

    suspend fun onProfileUIDataModel(profileInfo: UIProfileInfoModel)

    fun onChanging()

    fun onExit()

    fun onBack()
}