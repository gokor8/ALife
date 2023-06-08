package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing

import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state.ProfileChangingState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileChangingViewModel @Inject constructor(reducer: BaseProfileChangingReducer) :
    DefaultViewModel<BaseProfileChangingReducer, ProfileChangingAction, ProfileChangingState, ProfileEffect>(
        reducer
    )