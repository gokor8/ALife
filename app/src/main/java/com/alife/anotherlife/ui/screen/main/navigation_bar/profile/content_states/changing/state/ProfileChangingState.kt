package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.changing.state

import com.alife.anotherlife.core.ui.image.ImageExtModel
import com.alife.core.mvi.MVI

data class ProfileChangingState(
    val username: String,
    val photo: ImageExtModel,
    val name: String,
    val description: String
) : MVI.State