package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state

import com.alife.anotherlife.core.ui.image.ImageExtModel
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.EmptyUIProfileInfoModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model.UIProfileInfoModel

data class PostState(
    override val lceModel: LCEModel = LCEContent,
    val uiProfileInfoModel: UIProfileInfoModel = EmptyUIProfileInfoModel(),
//    val username: String = "",
//    val name: String = "",
//    val country: String = "",
//    val description: String = "",
//    val photo: ImageExtModel = ImageExtModel.Loading()
) : StateLCE