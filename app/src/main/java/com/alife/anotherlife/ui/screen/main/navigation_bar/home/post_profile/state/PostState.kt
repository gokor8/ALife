package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state

import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.InitUIProfileInfoModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel

data class PostState(
    override val lceModel: LCEModel = LCEContent,
    val uiProfileInfoModel: UIProfileInfoModel = InitUIProfileInfoModel(),
) : StateLCE