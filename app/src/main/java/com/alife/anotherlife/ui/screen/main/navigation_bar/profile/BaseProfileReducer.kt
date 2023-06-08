package com.alife.anotherlife.ui.screen.main.navigation_bar.profile

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.ProfileUsualFillState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileState

interface BaseProfileReducer : BaseVMReducer<ProfileState, ProfileEffect> {

    suspend fun onInit()

    fun onChanging()

    fun onUsual()

    fun onUsual(profileInfo: UIProfileInfoModel)

    fun onBack()
}