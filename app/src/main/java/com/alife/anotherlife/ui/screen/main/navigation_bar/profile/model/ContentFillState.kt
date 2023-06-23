package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface ContentFillState {

    @Composable
    fun ContentFill(constraints: ProfileConstraintModel)

}