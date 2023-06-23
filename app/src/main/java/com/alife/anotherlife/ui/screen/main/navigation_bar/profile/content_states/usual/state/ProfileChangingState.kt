package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state

import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel
import com.alife.core.mvi.MVI

data class ProfileUsualState(val profileInfo: UIProfileInfoModel) : MVI.State