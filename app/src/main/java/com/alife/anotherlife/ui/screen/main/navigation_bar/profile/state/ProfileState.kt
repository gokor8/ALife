package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state

import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.ProfileUsualFillState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.ContentFillState
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.InitUIProfileInfoModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel

data class ProfileState(
    override val lceModel: LCEModel = LCEContent,
    val profileUIDataModel: UIProfileInfoModel = InitUIProfileInfoModel(),
    val contentFillState: ContentFillState = ProfileUsualFillState(profileUIDataModel)
) : StateLCE