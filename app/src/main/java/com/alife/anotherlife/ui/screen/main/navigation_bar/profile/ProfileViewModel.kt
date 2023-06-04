package com.alife.anotherlife.ui.screen.main.navigation_bar.profile

import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    profileReducer: BaseProfileReducer
) : ViewModelLCE<BaseProfileReducer, ProfileAction, ProfileState, ProfileEffect>(profileReducer)