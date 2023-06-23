package com.alife.anotherlife.ui.activity.state

import com.alife.anotherlife.core.navigation.nav_navigator.EmptyNavigator
import com.alife.anotherlife.core.navigation.nav_navigator.Navigator
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE

data class MainActivityState(
    override val lceModel: LCEModel = LCEContent,
    val navigationScreen: Navigator = EmptyNavigator()
) : StateLCE