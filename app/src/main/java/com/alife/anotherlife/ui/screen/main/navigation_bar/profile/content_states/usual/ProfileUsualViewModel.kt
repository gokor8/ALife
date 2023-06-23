package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual

import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state.ProfileUsualState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileUsualViewModel @Inject constructor(reducer: BaseProfileUsualReducer) :
    DefaultViewModel<BaseProfileUsualReducer, ProfileUsualAction, ProfileUsualState, ProfileUsualEffect>(
        reducer
    )