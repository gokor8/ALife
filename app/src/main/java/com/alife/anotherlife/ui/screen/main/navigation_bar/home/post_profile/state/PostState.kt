package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state

import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE

data class PostState(
    override val lceModel: LCEModel = LCEContent,
    val username: String = "",
    val name: String = "",
    val country: String = "",
    val description: String = "",
    val pictureUrl: String = ""
) : StateLCE