package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.content_states.usual.state

import com.alife.anotherlife.core.ui.image.ImageExtModel
import com.alife.core.mvi.MVI

data class ProfileUsualState(
    val username: String,
    val photo: ImageExtModel,
    val name: String,
    val description: String,
    val country: String
) : MVI.State