package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual

import android.net.Uri
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ProfileUIDataModel

interface BaseProfileUsualReducer : BaseVMReducer<ProfileUsualState, ProfileUsualEffect> {

    fun onProfileUIDataModel(profileUIDataModel: ProfileUIDataModel)

    fun onChanging()

    fun onBack()
}