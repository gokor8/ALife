package com.alife.anotherlife.ui.screen.main.navigation_bar.profile

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileState

interface BaseProfileReducer : BaseVMReducer<ProfileState, ProfileEffect> {

    suspend fun onInit()

    fun onChanging()

    fun onUsual()

    fun onBack()
}